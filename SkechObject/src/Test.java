
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import constraintfactory.ConstraintFactory;
import constraintfactory.ExternalFunction;
import javaparser.simpleJavaLexer;
import javaparser.simpleJavaParser;
import jsonast.JsonNode;
import jsonast.Root;
import jsonparser.jsonLexer;
import jsonparser.jsonParser;
import sketchobj.core.ExpressionTuple;
import sketchobj.core.Function;
import sketchobj.core.SketchObject;
import sketchobj.core.TypePrimitive;
import sketchobj.expr.ExprConstInt;
import sketchobj.stmts.Statement;
import sketchobj.stmts.StmtBlock;
import visitor.JavaVisitor;
import visitor.JsonVisitor;
import bsh.EvalError;
import bsh.Interpreter;

public class Test {
	@org.junit.Test
	public void testRange() throws FileNotFoundException, InterruptedException{
		String oriTraces = new Scanner(new File("benchmarks/sumup/oritrace")).useDelimiter("\\Z").next();
		String correctTrace = new Scanner(new File("benchmarks/sumup/correction")).useDelimiter("\\Z").next();
		List<Integer> range = new ArrayList<Integer>();
		range.add(8);
		MainEntrance me = new MainEntrance(oriTraces,correctTrace,12);
		me.setRepairRange(range);
		me.Synthesize();
	}

	
	@org.junit.Test
	public void testSumUp() throws FileNotFoundException, InterruptedException{
		String oriTraces = new Scanner(new File("benchmarks/sumup/oritrace")).useDelimiter("\\Z").next();
		String correctTrace = new Scanner(new File("benchmarks/sumup/correction")).useDelimiter("\\Z").next();
		
		MainEntrance me = new MainEntrance(oriTraces,correctTrace,12);
		me.Synthesize();
	}
	
	@org.junit.Test
	public void testbsh() throws EvalError, FileNotFoundException, IOException{
		Interpreter i = new Interpreter();  // Construct an interpreter
		i.set("foo", 5);                    // Set variables
		i.set("date", new Date() ); 

		Date date = (Date)i.get("date");    // retrieve a variable

		// Eval a statement and get the result
		i.eval("bar = Math.pow(2,2)");             
		System.out.println( i.get("bar") );

	}
	
	@org.junit.Test
	public void testExternalFunction(){
		ExternalFunction ef = new ExternalFunction("Math.power");
		ef.put(new ExpressionTuple(2,2), new ExprConstInt(4));

		ef.put(new ExpressionTuple(2,3), new ExprConstInt(8));
		System.out.println(ef.getFunction());
	}
	
	@org.junit.Test
	public void testJson() throws FileNotFoundException {
		String content = new Scanner(new File("src/jsonexample")).useDelimiter("\\Z").next();
		ANTLRInputStream input = new ANTLRInputStream(content);
		Root root = (Root) jsoncompile(input);
		System.out.println(root.getCode());
	}

	@org.junit.Test
	public void testMainEntrance() throws FileNotFoundException, InterruptedException {
		String oriTraces = new Scanner(new File("src/jsonexample")).useDelimiter("\\Z").next();
		String correctTrace = new Scanner(new File("src/traceexample")).useDelimiter("\\Z").next();
		
		MainEntrance me = new MainEntrance(oriTraces,correctTrace,6);
		me.Synthesize();
	}
	
	@org.junit.Test
	public void test1() {
		Function f = ConstraintFactory.addConstFun(0, 5, new TypePrimitive(4));
		// System.out.println(f);
	}

	@org.junit.Test
	public void test3() {
		Statement s = ConstraintFactory.varArrayDecl("t", 5, new TypePrimitive(4));
		// System.out.println(s);
	}

	@org.junit.Test
	public void test4() {
		List<String> otherVars = new ArrayList<String>();
		otherVars.add("y");
		otherVars.add("z");
		Statement s = ConstraintFactory.recordState(0, otherVars);
		// System.out.println(s);
	}

	@org.junit.Test
	public void testReplaceConst() {
		ANTLRInputStream input = new ANTLRInputStream(
				"import java.util.Scanner;public class Main{	public static int largestGap(int[] a)	{	    int max = 1;	    a[1] = 10;	    int c = max++;	    int min = 100; 	    for(int i=0; i < 4; i++)	    {	        if(max < a[i])	        max = a[i];	    }        return max-min;	}	public static void main(String[] args)	{	    int x = largestGap( new int[]{ 2, 3, 7, 1 } );	    System.out.println(x);	}	}");
		Function f = (Function) compile(input,"largestGap");
		Statement s = f.getBody();
		System.out.println(s);
		// System.out.println(ConstraintFactory.repalceConst(s));
		// System.out.println(s);
	}

	@org.junit.Test
	public void testRecordStmt() {
		ANTLRInputStream input = new ANTLRInputStream(
				"int largestGap(int[] a){ int max = 1; a[1] = 10; c = max++; int min = 100;  for(int i=0; i < a.Length; i++){ if(max < a[i]) max = a[i]; }return max-min;}");
		Function f = (Function) compile(input,"main");
		Statement s = f.getBody();
		ConstraintFactory.replaceConst(s);
		ConstraintFactory.addRecordStmt((StmtBlock) s);
		// System.out.println(s);
	}

/*	@org.junit.Test
	public void testSimpleExample() throws InterruptedException {
		System.out.println();
		System.out.println("testSimpleExample:");
		ANTLRInputStream input = new ANTLRInputStream(
				"int SimpleJava(){ " + "int a = 2; " + "int b = a + 1; " + "int c = a+ b; " + "return c;}");
		Function root = (Function) compile(input,"main");

		List<ProgStateTODELETE> traces = new ArrayList<ProgStateTODELETE>();
		// {line = 1, a = 2}
		Map<String, Integer> m1 = new HashMap<String, Integer>();
		m1.put("a", 2);
		ProgStateTODELETE state1 = new ProgStateTODELETE(1, m1);
		traces.add(state1);

		// {line = 2, a = 2, b = 5}
		Map<String, Integer> m2 = new HashMap<String, Integer>(m1);
		m2.put("b", 5);
		ProgStateTODELETE state2 = new ProgStateTODELETE(2, m2);
		traces.add(state2);

		// {line = 3, a = 2, b = 5, c = 7}
		Map<String, Integer> m3 = new HashMap<String, Integer>(m2);
		m3.put("c", 7);
		ProgStateTODELETE state3 = new ProgStateTODELETE(3, m3);
		traces.add(state3);

		// correct: {line = 3, c = 8}
		Map<String, Integer> m4 = new HashMap<String, Integer>();
		m4.put("c", 8);
		// m4.put("b", 5);
		ProgStateTODELETE finalState = new ProgStateTODELETE(3, m4);

		TraceTODELETE oriTrace = new TraceTODELETE(traces);
		///////

		ConstraintFactory cf = new ConstraintFactory(oriTrace, finalState,
				new FcnHeader(root.getName(), root.getReturnType(), root.getParames()));

		System.out.println(root);

		String script = cf.getScript(root.getBody());
		
		System.out.println(script);
		
		System.out.println(CallSketch.CallByString(script));
	}

	@org.junit.Test
	public void testSumUp() throws InterruptedException {
		System.out.println();
		System.out.println("testSumUp:");
		ANTLRInputStream input = new ANTLRInputStream(
				"int orig(int x){" + "\n\n int t = 1;\n\n  int b = 2;\n" + "for(int i = x; i > 0; i--)" + "{t = t + i;}" + "return t;}");
		Function root = (Function) compile(input,"main");

		List<ProgStateTODELETE> traces = new ArrayList<ProgStateTODELETE>();
		// {line = 1, t = 1}
		Map<String, Integer> m1 = new HashMap<String, Integer>();
		m1.put("t", 1);
		ProgStateTODELETE state1 = new ProgStateTODELETE(1, m1);
		traces.add(state1);

		// {line = 2, t = 1, i = 3}
		Map<String, Integer> m2 = new HashMap<String, Integer>(m1);
		m2.put("i", 3);
		ProgStateTODELETE state2 = new ProgStateTODELETE(2, m2);
		traces.add(state2);

		// {line = 3, t = 4, i = 3}
		Map<String, Integer> m3 = new HashMap<String, Integer>();
		m3.put("t", 4);
		m3.put("i", 3);
		ProgStateTODELETE state3 = new ProgStateTODELETE(3, m3);
		traces.add(state3);

		// {line = 2, t = 4, i = 2}
		Map<String, Integer> m4 = new HashMap<String, Integer>();
		m4.put("t", 4);
		m4.put("i", 2);
		ProgStateTODELETE state4 = new ProgStateTODELETE(2, m3);
		traces.add(state4);

		// {line = 3, t = 6, i = 2}
		Map<String, Integer> m = new HashMap<String, Integer>();
		m.put("t", 4);
		m.put("i", 2);
		ProgStateTODELETE state = new ProgStateTODELETE(3, m);
		traces.add(state);

		// {line = 2, t = 6, i = 1}
		m = new HashMap<String, Integer>();
		m.put("t", 6);
		m.put("i", 1);
		state = new ProgStateTODELETE(2, m);
		traces.add(state);

		// correct: {line = 2, t = 5, i = 1}
		Map<String, Integer> fm = new HashMap<String, Integer>();
		fm.put("t", 5);
		fm.put("i", 1);
		ProgStateTODELETE finalState = new ProgStateTODELETE(2, fm);

		TraceTODELETE oriTrace = new TraceTODELETE(traces);
		///////

		ConstraintFactory cf = new ConstraintFactory(oriTrace, finalState,
				new FcnHeader(root.getName(), root.getReturnType(), root.getParames()), new ExprConstInt(3));

		System.out.println(root);

		String script = cf.getScript(root.getBody());
		System.out.println(script);
		//System.out.println(CallSketch.CallByString(script));
	}

	@org.junit.Test
	public void testLargestGap() throws InterruptedException {
		System.out.println();
		System.out.println("testLargestGap:");
		ANTLRInputStream input = new ANTLRInputStream("int largestGap(int[] a){" + "int max = 100; " + "int min = 0; "
				+ "for(int i=0; i < a.Length; i++){" + "if(max < a[i]) " + "max = a[i];" + "if(min > a[i]) "
				+ "min = a[i];" + "}" + "return max-min;}");
		Function root = (Function) compile(input,"main");

		List<ProgStateTODELETE> traces = new ArrayList<ProgStateTODELETE>();

		Map<String, Integer> m = new HashMap<String, Integer>();
		m.put("max", 100);
		ProgStateTODELETE state = new ProgStateTODELETE(1, m);
		traces.add(state);

		m = new HashMap<String, Integer>();
		m.put("max", 100);
		m.put("min", 0);
		state = new ProgStateTODELETE(2, m);
		traces.add(state);

		m = new HashMap<String, Integer>();
		m.put("max", 100);
		m.put("min", 0);
		m.put("i", 0);
		state = new ProgStateTODELETE(3, m);
		traces.add(state);

		m = new HashMap<String, Integer>();
		m.put("max", 100);
		m.put("min", 0);
		m.put("i", 0);
		state = new ProgStateTODELETE(4, m);
		traces.add(state);

		m = new HashMap<String, Integer>();
		m.put("max", 100);
		m.put("min", 0);
		m.put("i", 0);
		state = new ProgStateTODELETE(6, m);
		traces.add(state);

		m = new HashMap<String, Integer>();
		m.put("max", 100);
		m.put("min", 0);
		m.put("i", 1);
		state = new ProgStateTODELETE(3, m);
		traces.add(state);

		m = new HashMap<String, Integer>();
		m.put("max", 100);
		m.put("min", 0);
		m.put("i", 1);
		state = new ProgStateTODELETE(4, m);
		traces.add(state);

		m = new HashMap<String, Integer>();
		m.put("max", 100);
		m.put("min", 0);
		m.put("i", 1);
		state = new ProgStateTODELETE(6, m);
		traces.add(state);

		m = new HashMap<String, Integer>();
		m.put("max", 100);
		m.put("min", 0);
		m.put("i", 2);
		state = new ProgStateTODELETE(3, m);

		traces.add(state);
		// correct
		Map<String, Integer> fm = new HashMap<String, Integer>();
		fm.put("max", 4);
		fm.put("min", 1);
		fm.put("i", 2);
		ProgStateTODELETE finalState = new ProgStateTODELETE(2, fm);

		TraceTODELETE oriTrace = new TraceTODELETE(traces);
		///////

		List<Expression> parameters = new ArrayList<Expression>();
		parameters.add(new ExprConstInt(1));
		parameters.add(new ExprConstInt(4));
		parameters.add(new ExprConstInt(2));
		parameters.add(new ExprConstInt(7));

		ConstraintFactory cf = new ConstraintFactory(oriTrace, finalState,
				new FcnHeader(root.getName(), root.getReturnType(), root.getParames()), parameters);

		System.out.println(root);

		String script = cf.getScript(root.getBody());
		System.out.println(CallSketch.CallByString(script));
	}*/

	public static SketchObject compile(ANTLRInputStream input,String target) {
		simpleJavaLexer lexer = new simpleJavaLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		simpleJavaParser parser = new simpleJavaParser(tokens);
		ParseTree tree = parser.methodDeclaration();
		return new JavaVisitor(target).visit(tree);
	}

	public static JsonNode jsoncompile(ANTLRInputStream input) {
		jsonLexer lexer = new jsonLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		jsonParser parser = new jsonParser(tokens);
		ParseTree tree = parser.json();
		return new JsonVisitor().visit(tree);
	}
}
