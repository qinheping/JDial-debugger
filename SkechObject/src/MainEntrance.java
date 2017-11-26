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
	private String originalTrace;
	private String manipulation;
	private int indexOfCorrectTrace;

	private Root root;
	private String code;
	private String targetFunc;
	private List<String> function_names;
	private Map<String, String> func_name_to_code;
	private Traces traces;

	private int mod;

	private List<Integer> repair_range;

	//added 11/18
	private HashMap<String, String> funtions = new HashMap<>();
	
	public MainEntrance(String json, String correctTrace, int indexOfCorrectTrace) {
		this(json, correctTrace, indexOfCorrectTrace, 0);
	}

	public MainEntrance(String json, String correctTrace, int indexOfCorrectTrace, int mod) {
		this.originalTrace = json;
		this.manipulation = correctTrace;
		this.indexOfCorrectTrace = indexOfCorrectTrace;
		this.repair_range = null;
		this.function_names = new ArrayList<String>(); 
		this.mod = mod;
	}

	public Map<Integer, String> Synthesize() throws InterruptedException {
		return this.Synthesize(false, false);
	}

	public Map<Integer, String> Synthesize(boolean useLC) throws InterruptedException {
		return this.Synthesize(useLC, false);
	}

	public Map<Integer, String> Synthesize(boolean useLC, boolean oneLine) throws InterruptedException {
		this.targetFunc = extractFuncName(manipulation);
		this.root = jsonRootCompile(this.originalTrace);
		this.buildFuncNameList();
		this.code = root.getCode().getCode();
	
		if (oneLine)
			mod = 1;

		List<Expression> args = AuxMethods.extractArguments(root.getTraces(), indexOfCorrectTrace);

		this.traces = root.getTraces().findSubTraces(this.targetFunc, indexOfCorrectTrace);
		code = code.replace("\\n", "\n");
		code = code.replace("\\t", "\t");
		System.out.println("code");
		System.out.println("--------------------");
		System.out.println(code);

		ANTLRInputStream input = new ANTLRInputStream(code);
		Function function = (Function) javaCompile(input, targetFunc);
//		for(String funcName: this.func_name_to_code.keySet()){
//			//if(!funcName.equals(targetFunc))
//				//TODO
//				
//				
//		}
		System.out.println("function");
		System.out.println("--------------------");
		System.out.println(function);

		//added 11/18
		funtions.put(targetFunc, "");
		while (JavaVisitor.methodNames.size() != 0)
		{
			ANTLRInputStream input1 = new ANTLRInputStream(code);
			String name = JavaVisitor.methodNames.poll();
			if(funtions.containsKey(name))
				continue;

			Function function1 = (Function)javaCompile(input1, name);
			System.out.println(function1);
			funtions.put(name, function1.toString());
		}
		//added 11/18
		
		// added
		System.out.println("--------------------");
		boolean prime_mod = global.Global.prime_mod;
		boolean rec_mod = global.Global.rec_mod;
		ConstraintFactory cf = new ConstraintFactory(traces, jsonTraceCompile(manipulation),
				new FcnHeader(function.getName(), function.getReturnType(), function.getParames()), args, mod, prime_mod);
		ConstraintFactory.correctionIndex = this.indexOfCorrectTrace;
		if (this.repair_range != null)
			cf.setRange(this.repair_range);
		String script;
		// if (useLC)
		//script = cf.getScript_linearCombination(function.getBody(), function.getParames());
		
		// added
		if (rec_mod)
			script = cf.getScript_linearCombination(function.getBody(), funtions);	
		else
			script = cf.getScript_linearCombination(function.getBody());
		//System.err.println("2--------------------------------------------"); // added
		//System.err.println(script); // added
		//System.err.println("2--------------------------------------------"); // added

		// added
		if (prime_mod)
			script = tranScript(script);
		System.err.println("3--------------------------------------------");
		if (rec_mod)
			script = tranScriptCall(script);

		System.err.println("4--------------------------------------------"); // added
		System.err.println(script); // added
		System.err.println("4--------------------------------------------"); // added
		
		//----added
		SketchResult resultS = CallSketch.CallByString(script);

		//-----added

		// else
		// script = cf.getScript(function.getBody());
		if (mod != 2)
			return this.actualSynthesize(useLC, script, cf, null);

		return null;
	}

	//added 11/19


	private void buildFuncNameList() {
		List<Trace> traces = this.root.getTraces().getTraces();
		for(Trace trace: traces){
			if(!this.function_names.contains(trace.getFuncname()))
				this.function_names.add(trace.getFuncname());
		}
	}

	private String addGetArrayDistance(int[][] ori, int tarRow, int tarCol, int iValue)
	{
		int row = ori.length;
		int col = ori[0].length;
		/*
		int getArrayDistance(int[m] a1, int[n] a2, int illegalValue)
		{
			int distance = 0;
			distance += (a1[0] != a2[0]);
			for(int i = 1;i<m && i< n && a1[i] != illegalValue && a2[i] != illegalkValue;i++)
			{
				distance += (abs(a1[i], a1[i-1])  !=  abs(a2[i], a2[i-1]) );
			}
			return distance
		}

		int[col][row] ori;
		ori[0] = {};


		int[tarCol][tarRow] tar;
		iValue = ;

		int dis = 0;
		for(int i = 0;i<tarRow && i < row;i++)
		{
			dis += getArrayDistance(ori[i], tar[i], iValue)
		}

		 */
		StringBuilder result = new StringBuilder();
		result.append("int getArrayDistance(int[m] a1, int[n] a2, int illegalValue)\n");
		result.append("{\n");
		result.append("int distance = 0;\n");
		result.append("distance += (a1[0] != a2[0]);\n");
		result.append("for(int i = 1;i<m && i<n && a1[i] != illegalValue && a2[i] != illegalValue;i++)\n");
		result.append("{\n");
		result.append("distance += (abs(a1[i], a1[i-1]) != abs(a2[i], a2[i-1]));\n");
		result.append("}\n");
		result.append("return distance;\n");
		result.append("}\n");
		result.append("int row = "+row+"\n");
		result.append("int col = "+col+"\n");
		result.append("int tarRow = "+tarRow+"\n");
		result.append("int tarCol = "+tarCol+"\n");


		result.append("int[col][row] ori;\n");
		for(int i = 0;i<ori.length;i++)
		{
			StringBuilder tmp = new StringBuilder();
			for(int j = 0;j<ori[i].length;j++)
			{
				tmp.append(ori[i] + ",");
			}
			String temp = tmp.toString().substring(0,tmp.length()-1);
			result.append("ori["+i+"] = {"+temp+"};\n");
		}

		result.append("int[tarCol][tarRow] tar;\n");
		result.append("iValue = "+iValue+";\n");
		result.append("int dis = 0;\n");
		result.append("for(int i = 0;i<tarRow && i < row;i++)\n");
		result.append("{\n");
		result.append("dis += getArrayDistance(ori[i], tar[i], iValue)");
		result.append("}\n");
		return result.toString();
	}
	//added 11/19
	
	//@1int bfinal = 0; need to know nameOfVar, primes
	//@2int a = 1 + ((Coeff0()) * (Coeff1())); need to know nameOfVar, primes ("Coeff")
	//@3int[3] oringianlaArray = {0,1,1};
	//@4int correctFinal_b = 500; need to know nameOfVar, primes

	private String tranScriptCall(String script)
	{
		StringBuilder result = new StringBuilder();
		int index0 = 0;
		int index1 = 0;
		index1 = script.indexOf("int count = -1;");
		index1 = script.indexOf('\n', index1);
		result.append(script.substring(index0, index1+1));
		index0 = index1 + 1;

		// store the value of the result variable in each iteration 
		result.append("int[10] resArray = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};\n");
		// level of recursion
		result.append("int funcCount = -1;\n");

		index1 = script.indexOf('\n', index0);
		index0 = index1+1;
		index1 = script.indexOf('\n', index0);
		result.append(script.substring(index0, index1+1));
		index0 = index1 + 1;

		result.append("(funcCount)++;\n");
		//step 1--done

		index1 = script.indexOf("finalcount = count;", index0);
		System.err.println("index1: " + index1);
		index1 = index1 -2;
		index1 = script.lastIndexOf('\n', index1);

		result.append(script.substring(index0, index1+1));
		index0 = script.indexOf('\n', index1+1);
		String tmpVarname = script.substring(index1+1, index0);
		System.err.println("tmpVarname: " + tmpVarname);
		int indexEqual = tmpVarname.indexOf('=');
		int indexSemi = tmpVarname.indexOf(';');
		tmpVarname = tmpVarname.substring(indexEqual+1, indexSemi).trim();

		result.append("resArray[funcCount] = "+tmpVarname+";\n");
		result.append("finalcount = count;\n");
		result.append("}\n");
		index0 = script.indexOf('}', index1)+2;
		//step 2--done

		index1 = script.indexOf("assert", index0);
		result.append(script.substring(index0, index1));
		index0 = script.indexOf('\n', index1);
		String tmpLine = script.substring(index1, index0);

		int corIndex = tmpLine.indexOf("correctFinal_");
		int parenIndex = tmpLine.indexOf(")");
		String varName = tmpLine.substring(corIndex, parenIndex);

		String tmpAssert = "assert (resArray[0] == "+varName+" || resArray[1] == "+varName+" ||\n" +
				"resArray[2] == "+varName+" || resArray[3] == "+varName+" ||\n" +
				"resArray[4] == "+varName+" || resArray[5] == "+varName+" ||\n" +
				"resArray[6] == "+varName+" || resArray[7] == "+varName+" ||\n" +
				"resArray[8] == "+varName+" || resArray[9] == "+varName+");\n";
		result.append(tmpAssert);
		result.append(script.substring(index0+1));
		//step 3--done


		return result.toString();
	}

	private String tranScript(String script)
	{


		int beishu = 5;
		int[] primeNumber = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 39};
		ArrayList<Integer> primes = new ArrayList<>();
		int finalValue;
		int maxValue = Integer.MIN_VALUE;
		String nameOfVar;

		//nameOfVar
		int index4 = script.indexOf("@4");
		int last4BN = script.lastIndexOf('\n', index4);
		int index4_ = script.indexOf('_', last4BN);
		int index4space = script.indexOf(' ', index4_);
		nameOfVar = script.substring(index4_+1, index4space);
		//nameOfVar

		//finalValue
		int index4equal = script.indexOf('=', index4_);
		int index4semi = script.indexOf(';', index4equal);
		String tmpFinalValue = script.substring(index4equal+1, index4semi).trim();
		finalValue = Integer.valueOf(tmpFinalValue);
		//finalValue

		//maxValue, primes
		int index3 = 0;
		while ((index3 = script.indexOf("@3", index3+1)) != -1)
		{
			int tmp3BN = script.lastIndexOf('\n', index3);
			int left = script.indexOf('{', tmp3BN);
			int right = script.indexOf('}', tmp3BN);
			String[] tmpArray = script.substring(left+1, right).split(",");
			for(String s : tmpArray)
			{
				int tmpInt = Math.abs(Integer.valueOf(s));
				maxValue = Math.max(maxValue, tmpInt);
			}
		}
		maxValue = Math.max(maxValue, finalValue) * beishu;
		int tmpp = 1;
		for(int n : primeNumber)
		{
			tmpp *= n;
			primes.add(n);
			if(tmpp > maxValue)
				break;
		}
		//maxValue, primes





		StringBuilder result = new StringBuilder();
		int lastIndex = 0;
		int index = 0;

		while ((index = script.indexOf('@',lastIndex)) != -1)
		{
			StringBuilder curString = new StringBuilder();
			int lastBN = script.lastIndexOf('\n', index);
			int nextBN = script.indexOf('\n', index);

			result.append(script.substring(lastIndex, lastBN+1));

			if(script.charAt(index+1) == '1')
			{
				curString.append(script.substring(lastBN+1, index));
				curString.append(script.substring(index+2, nextBN+1));
				//@1int bfinal = 0; need to know nameOfVar, primes
				//int b2 = 0;
				for(Integer i : primes)
				{
					String tmp1 = "int "+nameOfVar+i+" = 0;\n";
					curString.append(tmp1);
				}
			}
			else if(script.charAt(index+1) == '2')
			{
				//@2int a = 1 + ((Coeff0()) * (Coeff1()));
				//int a2 =
				// need to know nameOfVar, primes ("Coeff")
				String tmp2iffor = script.substring(lastBN+1, nextBN+1);
				if(tmp2iffor.contains("if") || (tmp2iffor.contains("for")))
				{
					tmp2iffor = tmp2iffor.replaceAll("@2", "");
					curString.append(tmp2iffor);
				}
				else
				{
					curString.append(script.substring(lastBN+1, index));
					curString.append(script.substring(index+2, nextBN+1));
					for(Integer i : primes)
					{
						String curLine = script.substring(lastBN+1, index) + script.substring(index+2, nextBN+1);
						String[] tmp2Array = curLine.split(" ");
						boolean firstIsInt = tmp2Array[0].equals("int");
						boolean isTargetVar = false;
						String varName = "";
						if (firstIsInt)
						{
							isTargetVar = tmp2Array[1].equals(nameOfVar);
							varName = tmp2Array[1];
						}
						else
						{
							isTargetVar = tmp2Array[0].equals(nameOfVar);
							varName = tmp2Array[0];
						}

						curLine = curLine.substring(curLine.indexOf('=')+1, curLine.indexOf(';'));
						int tmpIndex = 0;
						int tmpIndex1 = 0;
						String tmpCurLine = "";
						//int b = (((10 * a) + 100) + ((Coeff2()) * a)) + ((Coeff3()) * (Coeff4()));
						//int a = 1 + ((Coeff0()) * (Coeff1()));
						while ((tmpIndex1 = curLine.indexOf('*', tmpIndex)) != -1)
						{
							int tmpPare = curLine.indexOf(')', tmpIndex1);
							String tmpVar = curLine.substring(tmpIndex1+1, tmpPare).trim();
							if(!tmpVar.contains("Coeff") && !tmpVar.contains("External_"))
							{
								tmpVar = tmpVar+i;
								tmpCurLine += curLine.substring(tmpIndex, tmpIndex1+1) + " "+ tmpVar+")";
								tmpIndex = tmpPare+1;
							}
							else
							{
								tmpCurLine += curLine.substring(tmpIndex, tmpPare+1);
								tmpIndex = tmpPare+1;
							}
						}
						tmpCurLine += curLine.substring(tmpIndex);
						curLine = tmpCurLine;
						String tmp1 = "";
						if(!isTargetVar)
						{
							tmp1 += "int ";
						}
						tmp1 += varName+i+" = (" + curLine + ") % "+i+";\n";
						curString.append(tmp1);
					}
				}
			}
			if(script.charAt(index+1) == '4' || script.charAt(index+1) == '3')
			{
				curString.append(script.substring(lastBN+1, index));
				curString.append(script.substring(index+2, nextBN+1));
			}
			else if(script.charAt(index+1) == '5')
			{
				//assert (b@5final == correctFinal_b);
				//assert (b2 % 2 == correctFinal_b %2)
				for(Integer i : primes)
				{
					String tmp1 = "assert (" + nameOfVar+i +" % "+i+" == "+"correctFinal_"+nameOfVar+" %"+i+");\n";
					curString.append(tmp1);
				}
			}
			lastIndex = nextBN+1;
			result.append(curString.toString());
		}
		result.append(script.substring(lastIndex));

		//delete External_

		String strResult = result.toString();
		strResult = strResult.replace("External_", "");
		return strResult;
		//delete External_
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