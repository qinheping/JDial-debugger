import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import constraintfactory.AuxMethods;
import constraintfactory.ConstraintFactory;
import constraintfactory.ExternalFunction;
import javaparser.simpleJavaLexer;
import javaparser.simpleJavaParser;
import jsonast.Root;
import jsonast.Trace;
import jsonast.Traces;
import jsonparser.jsonLexer;
import jsonparser.jsonParser;
import sketchobj.core.FcnHeader;
import sketchobj.core.Function;
import sketchobj.core.SketchObject;
import sketchobj.expr.Expression;
import sketchobj.stmts.Statement;
import visitor.JavaVisitor;
import visitor.JsonVisitor;

import static org.matheclipse.core.expression.F.*;

import org.matheclipse.core.basic.Config;
import org.matheclipse.core.eval.ExprEvaluator;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.parser.client.SyntaxError;
import org.matheclipse.parser.client.math.MathException;

public class MainEntrance {
	private String json;
	private String correctTrace;
	private int indexOfCorrectTrace;

	private Root root;
	private String code;
	private String targetFunc;
	private Traces traces;

	private int mod;

	private List<Integer> repair_range;

	public MainEntrance(String json, String correctTrace, int indexOfCorrectTrace) {
		this(json, correctTrace, indexOfCorrectTrace, 0);
	}

	public MainEntrance(String json, String correctTrace, int indexOfCorrectTrace, int mod) {
		this.json = json;
		this.correctTrace = correctTrace;
		this.indexOfCorrectTrace = indexOfCorrectTrace;
		this.repair_range = null;
		this.mod = mod;
	}

	public Map<Integer, String> Synthesize() throws InterruptedException {
		return this.Synthesize(false, false);
	}

	public Map<Integer, String> Synthesize(boolean useLC) throws InterruptedException {
		return this.Synthesize(useLC, false);
	}

	public Map<Integer, String> Synthesize(boolean useLC, boolean oneLine) throws InterruptedException {
		this.targetFunc = extractFuncName(correctTrace);
		this.root = jsonRootCompile(this.json);
		this.code = root.getCode().getCode();
		if (oneLine)
			mod = 1;

		List<Expression> args = AuxMethods.extractArguments(root.getTraces(), indexOfCorrectTrace);

		this.traces = root.getTraces().findSubTraces(this.targetFunc, indexOfCorrectTrace);
		code = code.replace("\\n", "\n");
		code = code.replace("\\t", "\t");
		System.out.println(code);

		ANTLRInputStream input = new ANTLRInputStream(code);
		Function function = (Function) javaCompile(input, targetFunc);
		System.out.println(function);

		ConstraintFactory cf = new ConstraintFactory(traces, jsonTraceCompile(correctTrace),
				new FcnHeader(function.getName(), function.getReturnType(), function.getParames()), args, mod);
		ConstraintFactory.correctionIndex = this.indexOfCorrectTrace;
		if (this.repair_range != null)
			cf.setRange(this.repair_range);
		String script;
		// if (useLC)
		script = cf.getScript_linearCombination(function.getBody());
		// else
		// script = cf.getScript(function.getBody());
		if (mod != 2)
			return this.actualSynthesize(useLC, script, cf, null);

		return null;
	}

	public Map<Integer, String> actualSynthesize(boolean useLC, String script, ConstraintFactory cf,
			Statement targetStmt) throws InterruptedException {

		List<ExternalFunction> externalFuncs = ConstraintFactory.externalFuncs;

		// System.out.println(script);
		// System.out.println(cf.line_to_string);

		// no external Functions
		if (externalFuncs.size() == 0) {

			SketchResult resultS = CallSketch.CallByString(script);
			Map<Integer, Integer> result = resultS.Result;
			Set<Integer> validIndexSet = resultS.valid_Set;
			List<Integer> indexset = new ArrayList<Integer>();
			indexset.addAll(result.keySet());
			Map<Integer, String> repair = new HashMap<Integer, String>();
			int tmpLine = -1;
			for (int k : result.keySet()) {
				if (ConstraintFactory.coeffIndex_to_Line.get(k) == tmpLine)
					continue;
				if (!validIndexSet.contains(k))
					continue;

				tmpLine = ConstraintFactory.coeffIndex_to_Line.get(k);
				String stmtString = ConstraintFactory.line_to_string.get(tmpLine);
				repair.put(tmpLine, replaceCoeff(stmtString, result, ConstraintFactory.coeffIndex_to_Line, tmpLine));
			}
			System.out.println(repair);
			return repair;
		} else {
			boolean consistancy = false;
			List<ExternalFunction> efs = new ArrayList<ExternalFunction>();
			for (ExternalFunction s : externalFuncs) {
				efs.add(s);
			}
			while (!consistancy) {
				String script_ex = script;
				for (ExternalFunction ef : efs) {
					script_ex = ef.toString() + script_ex;
				}
				// System.out.println(script_ex);
				// Map<Integer, Integer> result =
				// CallSketch.CallByString(script_ex);
				consistancy = true;
			}
			return null;
		}
	}

	private String replaceCoeff(String stmtString, Map<Integer, Integer> result,
			Map<Integer, Integer> coeffIndex_to_Line, int tmpLine) {
		List<Integer> rangedCoeff = new ArrayList<Integer>();
		// System.out.println(result);
		for (int k : coeffIndex_to_Line.keySet()) {
			if (coeffIndex_to_Line.get(k) == tmpLine)
				rangedCoeff.add(k);
		}
		for (int c : rangedCoeff) {
			if (result.containsKey(c))
				stmtString = stmtString.replace("(Coeff" + c + "())", result.get(c).toString());
			else
				stmtString = stmtString.replace("(Coeff" + c + "())", "0");

		}

		stmtString = simplifyByCAS(stmtString);

		return stmtString;
	}

	private String simplifyByCAS(String stmtString) {
		String[] s;
		if (stmtString.substring(0, 2).equals("if")){
			String tmp = stmtString.substring(3, stmtString.length()-1);
			stmtString= "if(" +eval(tmp)+")";
			return stmtString;
		}
		if (stmtString.substring(0, 3).equals("for")) {
			s = stmtString.split(";", 3);
			s[0] = s[0].split("=",2)[0]+"= " + eval(s[0].split("=",2)[1]);
			s[1] = eval(s[1]);
			s[2] = eval(s[2].substring(0, s[2].length()-1));
			return s[0]+";"+s[1]+";"+s[2]+"){";
		}
		s = stmtString.split("=", 2);
		return s[0] + "= " + eval(s[1].substring(0, s[1].length() - 1)) + ";";

	}

	public String simplifyByRegEx(String stmtString) {
		String tmp = "";
		while (!tmp.equals(stmtString)) {
			tmp = stmtString;
			stmtString = stmtString.replaceAll("[(]0( )*[*]( )*[-]?( )*([0-9A-Za-z])*( )*[)]", "0");
			stmtString = stmtString.replaceAll("[(]( )*[-]?( )*([0-9A-Za-z])*( )*[*]( )*[0]( )*[)]", "0");
			stmtString = stmtString.replaceAll("[(]0( )*[+]( )*", "(");
			stmtString = stmtString.replaceAll("( )*[+]( )*0[)]", ")");
			stmtString = stmtString.replaceAll("( )*[-]( )*0[)]", ")");
			stmtString = stmtString.replaceAll("( )*[+]( )*0[;]", ";");
			stmtString = stmtString.replaceAll("( )*[-]( )*0[;]", ";");
			stmtString = stmtString.replaceAll("[(]0[)]", "0");
			stmtString = stmtString.replaceAll("[(]1( )*[*]( )*", "(");
			stmtString = stmtString.replaceAll("( )*[*]( )*1( )*[)]", ")");
			stmtString = stmtString.replaceAll("( )*[*]( )*1( )*[;]", ";");
			stmtString = deleRedPara(stmtString);

		}
		return stmtString;
	}

	public String deleRedPara(String s) {
		int len = s.length();
		for (int k = 2; k < len; k++) {
			for (int i = 0; i <= len - k; i++) {
				if (s.substring(i, i + k).matches("[(]( )*[\\d\\w]*( )*[)]")) {
					s = s.substring(0, i) + s.substring(i + 1, i + k - 1) + s.substring(i + k);
					len = len - 2;
					k = 4;
					i = 0;
					continue;
				}
				if (s.substring(i, i + k).matches("[(]( )*[(][\\w\\W]*[)]()*[)]")) {
					s = s.substring(0, i) + s.substring(i + 1, i + k - 1) + s.substring(i + k);
					len = len - 2;
					k = 4;
					i = 0;
				}
			}
		}
		return s;
	}

	public void setRepairRange(List<Integer> l) {
		this.repair_range = l;
	}

	public String extractFuncName(String trace) {
		Trace tr = jsonTraceCompile(trace);
		return tr.getFuncname();
	}

	public static Root jsonRootCompile(String s) {
		ANTLRInputStream input = new ANTLRInputStream(s);
		jsonLexer lexer = new jsonLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		jsonParser parser = new jsonParser(tokens);
		ParseTree tree = parser.json();
		return (Root) new JsonVisitor().visit(tree);
	}

	public static Trace jsonTraceCompile(String s) {
		ANTLRInputStream input = new ANTLRInputStream(s);
		jsonLexer lexer = new jsonLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		jsonParser parser = new jsonParser(tokens);
		ParseTree tree = parser.trace();
		return (Trace) new JsonVisitor().visit(tree);
	}

	public static SketchObject javaCompile(ANTLRInputStream input, String target) {
		simpleJavaLexer lexer = new simpleJavaLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		simpleJavaParser parser = new simpleJavaParser(tokens);
		ParseTree tree = parser.compilationUnit();
		return new JavaVisitor(target).visit(tree);
	}

	public String eval(String input) {

		ExprEvaluator util = new ExprEvaluator(false, 100);
		IExpr result = util.evaluate(input);
		return result.toString();
	}

}