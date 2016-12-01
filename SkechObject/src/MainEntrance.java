import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import sketchobj.expr.ExprString;
import sketchobj.expr.Expression;
import visitor.JavaVisitor;
import visitor.JsonVisitor;

public class MainEntrance {
	private String json;
	private String correctTrace;
	private int indexOfCorrectTrace;

	private Root root;
	private String code;
	private String targetFunc;
	private Traces traces;

	private List<Integer> repair_range;

	public MainEntrance(String json, String correctTrace, int indexOfCorrectTrace) {
		this.json = json;
		this.correctTrace = correctTrace;
		this.indexOfCorrectTrace = indexOfCorrectTrace;
		this.repair_range = null;
	}

	public Map<Integer, Integer> Synthesize() throws InterruptedException {
		this.targetFunc = extractFuncName(correctTrace);
		this.root = jsonRootCompile(this.json);
		this.code = root.getCode().getCode();

		List<Expression> args = AuxMethods.extractArguments(root.getTraces(), indexOfCorrectTrace);

		this.traces = root.getTraces().findSubTraces(this.targetFunc, indexOfCorrectTrace);
		code = code.replace("\\n", "\n");
		code = code.replace("\\t", "\t");
		System.out.println(code);

		ANTLRInputStream input = new ANTLRInputStream(code);
		Function function = (Function) javaCompile(input, targetFunc);

		ConstraintFactory cf = new ConstraintFactory(traces, jsonTraceCompile(correctTrace),
				new FcnHeader(function.getName(), function.getReturnType(), function.getParames()), args);
		if (this.repair_range != null)
			cf.setRange(this.repair_range);
		String script = cf.getScript(function.getBody());

		// System.out.println(script);

		List<String> externalFuncs = ConstraintFactory.externalFuncNames;
		
		// no external Functions
		if (externalFuncs.size() == 0) {

			Map<Integer, Integer> result = CallSketch.CallByString(script);
			List<Integer> indexset = new ArrayList<Integer>();
			indexset.addAll(result.keySet());
			Map<Integer, Integer> repair = new HashMap<Integer, Integer>();
			for (Integer ke : indexset) {
				repair.put(ConstraintFactory.getconstMapLine().get(ke), result.get(ke));
			}
			System.out.println(repair);
			return repair;
		} else{
			boolean consistancy = false;
			List<ExternalFunction> efs = new ArrayList<ExternalFunction>();
			for(String s: externalFuncs){
				efs.add(new ExternalFunction(s));
			}
			while(!consistancy){
				String script_ex = script;
				for(ExternalFunction ef: efs){
					script_ex = ef.toString()+script_ex;
				}
				System.out.println(script_ex);
				Map<Integer, Integer> result = CallSketch.CallByString(script_ex);
				consistancy= true;
			}
			return null;
		}
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
}