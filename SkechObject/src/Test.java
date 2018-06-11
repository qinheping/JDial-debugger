
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.script.ScriptException;

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
import java.math.*;

public class Test {

	@org.junit.Test
	public void testSimpleCal() throws FileNotFoundException, InterruptedException {
		String oriTraces = new Scanner(new File("benchmarks/simpleCal/errortrace")).useDelimiter("\\Z").next();
		Root root = MainEntrance.jsonRootCompile(oriTraces);
		String code = root.getCode().getCode();
		code = code.replace("\\n", "\n");
		code = code.replace("\\t", "\t");

		ANTLRInputStream input = new ANTLRInputStream(code);
		Function function = (Function) MainEntrance.javaCompile(input, "main");
		System.out.println(function);
		// assert s.toString().equals("{7=2}") ;
	}

	@org.junit.Test
	public void testSumupExternal_2() throws FileNotFoundException, InterruptedException {
		String oriTraces = new Scanner(new File("benchmarks/sumup_external_2/errortrace")).useDelimiter("\\Z").next();
		String correctTrace = new Scanner(new File("benchmarks/sumup_external_2/correction")).useDelimiter("\\Z")
				.next();

		MainEntrance me = new MainEntrance(oriTraces, correctTrace, 6);
		String s = me.Synthesize().toString();
		// assert s.toString().equals("{7=2}") ;
	}

	@org.junit.Test
	public void testSumupExternal() throws FileNotFoundException, InterruptedException {
		String oriTraces = new Scanner(new File("benchmarks/sumup_external/errortrace")).useDelimiter("\\Z").next();
		String correctTrace = new Scanner(new File("benchmarks/sumup_external/correction")).useDelimiter("\\Z").next();

		MainEntrance me = new MainEntrance(oriTraces, correctTrace, 15);
		String s = me.Synthesize().toString();
		// assert s.toString().equals("{7=2}") ;
	}

	@org.junit.Test
	public void testRange() throws FileNotFoundException, InterruptedException {
		String oriTraces = new Scanner(new File("benchmarks/sumup/oritrace")).useDelimiter("\\Z").next();
		String correctTrace = new Scanner(new File("benchmarks/sumup/correction")).useDelimiter("\\Z").next();
		List<Integer> range = new ArrayList<Integer>();
		range.add(7);
		MainEntrance me = new MainEntrance(oriTraces, correctTrace, 12);
		me.setRepairRange(range);
		String s = me.Synthesize().toString();
		assert s.toString().equals("{7=2}");
	}

	@org.junit.Test
	public void testSumUp() throws FileNotFoundException, InterruptedException {
		int index = 22; // 10 | 22
		String oriTraces = new Scanner(new File("benchmarks/sumup/oritrace")).useDelimiter("\\Z").next();
		String correctTrace = new Scanner(new File("benchmarks/sumup/correction_index_" + index)).useDelimiter("\\Z")
				.next();

		MainEntrance me = new MainEntrance(oriTraces, correctTrace, index);
		me.Synthesize(true);
	}

	@org.junit.Test
	public void testbsh() throws EvalError, FileNotFoundException, IOException {
		Interpreter i = new Interpreter(); // Construct an interpreter
		i.set("foo", 5); // Set variables
		i.set("date", new Date());

		Date date = (Date) i.get("date"); // retrieve a variable

		// Eval a statement and get the result
		i.eval("bar = Math.pow(2,2)");
		assert i.get("bar").equals("4");

	}

	@org.junit.Test
	public void testExternalFunction() {
		ExternalFunction ef = new ExternalFunction("Math.power", "Math.power", 2, 5);
		ef.put(new ExpressionTuple(2, 2), new ExprConstInt(4));

		ef.put(new ExpressionTuple(2, 3), new ExprConstInt(8));
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

		MainEntrance me = new MainEntrance(oriTraces, correctTrace, 6);
		me.Synthesize();
	}


	@org.junit.Test
	public void testReplaceConst() {
		ANTLRInputStream input = new ANTLRInputStream(
				"import java.util.Scanner;public class Main{	public static int largestGap(int[] a)	{	    int max = 1;	    a[1] = 10;	    int c = max++;	    int min = 100; 	    for(int i=0; i < 4; i++)	    {	        if(max < a[i])	        max = a[i];	    }        return max-min;	}	public static void main(String[] args)	{	    int x = largestGap( new int[]{ 2, 3, 7, 1 } );	    System.out.println(x);	}	}");
		// Function f = (Function) compile(input,"largestGap");
		// Statement s = f.getBody();
		// System.out.println(s);
		// System.out.println(ConstraintFactory.repalceConst(s));
		// System.out.println(s);

	}

	@org.junit.Test
	public void testRecordStmt() {
		ANTLRInputStream input = new ANTLRInputStream(
				"int largestGap(int[] a){ int max = 1; a[1] = 10; c = max++; int min = 100;  for(int i=0; i < a.Length; i++){ if(max < a[i]) max = a[i]; }return max-min;}");
		Function f = (Function) compile(input, "main");
		Statement s = f.getBody();
		ConstraintFactory.replaceConst(s);
		// ConstraintFactory.addRecordStmt((StmtBlock) s);
		// System.out.println(s);
	}

	@org.junit.Test
	public void testFileIO() {

		SliceUtil su = SliceUtil.makeSliceUtilFromFilename("experimentsrc/CalcStatic.java");
		ArrayList<Integer> l = su.get_slice_line_nums("CalcStatic", "main", 54, "top");
		for (int n : l) {
			System.out.println(n);
		}
	}

	public static SketchObject compile(ANTLRInputStream input, String target) {
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

	@org.junit.Test
	public void testMedian1() throws FileNotFoundException, InterruptedException {
		String oriTraces = new Scanner(new File("benchmarks/median1/median-test1")).useDelimiter("\\Z").next();
		String correctTrace = new Scanner(new File("benchmarks/median1/median-target1")).useDelimiter("\\Z").next();
		MainEntrance me = new MainEntrance(oriTraces, correctTrace, 8);
		String res = me.Synthesize(true).toString();
		System.out.println(res);
	}

	@org.junit.Test
	public void testMax3() throws FileNotFoundException, InterruptedException {
		String oriTraces = new Scanner(new File("benchmarks/max3/max3-test")).useDelimiter("\\Z").next();
		String correctTrace = new Scanner(new File("benchmarks/max3/max3-target")).useDelimiter("\\Z").next();
		MainEntrance me = new MainEntrance(oriTraces, correctTrace, 8);
		String res = me.Synthesize(true).toString();
		System.out.println(res);
	}

	@org.junit.Test
	public void testFindC() throws FileNotFoundException, InterruptedException {
		int index = 8;
		String oriTraces = new Scanner(new File("benchmarks/FindC/FindC-test")).useDelimiter("\\Z").next();
		String correctTrace = new Scanner(new File("benchmarks/FindC/FindC-target")).useDelimiter("\\Z").next();
		MainEntrance me = new MainEntrance(oriTraces, correctTrace, index);
		String res = me.Synthesize(true).toString();
		System.out.println(res);
	}
	@org.junit.Test
	public void testlargestGap1() throws FileNotFoundException, InterruptedException {
		int index = 12;
		String oriTraces = new Scanner(new File("benchmarks/LargestGap-1/largestGap1-test")).useDelimiter("\\Z").next();
		String correctTrace = new Scanner(new File("benchmarks/LargestGap-1/largestGap1-target")).useDelimiter("\\Z").next();
		MainEntrance me = new MainEntrance(oriTraces, correctTrace, index);
		String res = me.Synthesize(true).toString();
		System.out.println(res);
	}
	@org.junit.Test
	public void testsubsum() throws FileNotFoundException, InterruptedException {
		int index = 40;
		String folder = "";
		String oriTraces = new Scanner(new File("benchmarks/subsum/test")).useDelimiter("\\Z").next();
		String correctTrace = new Scanner(new File("benchmarks/subsum/target-"+index)).useDelimiter("\\Z").next();
		MainEntrance me = new MainEntrance(oriTraces, correctTrace, index);
		String res = me.Synthesize(true).toString();
		System.out.println(res);
	}
	
	@org.junit.Test
	public void testtmp() throws FileNotFoundException, InterruptedException, ScriptException {
		int index = 11;
		String folder = "";
		String oriTraces = new Scanner(new File("benchmarks/tmptest/test")).useDelimiter("\\Z").next();
		String correctTrace = new Scanner(new File("benchmarks/tmptest/target")).useDelimiter("\\Z").next();
		MainEntrance me = new MainEntrance(oriTraces, correctTrace, index);
		String res = me.Synthesize(true,true).toString();
		System.out.println(res);
	}

	@org.junit.Test
	public void testtmp1() throws FileNotFoundException, InterruptedException, ScriptException {
		int index = 5;
		String folder = "";
		String oriTraces = new Scanner(new File("benchmarks/tmptest1/test")).useDelimiter("\\Z").next();
		String correctTrace = new Scanner(new File("benchmarks/tmptest1/target")).useDelimiter("\\Z").next();
		MainEntrance me = new MainEntrance(oriTraces, correctTrace, index);
		String res = me.Synthesize(true,true).toString();
		System.out.println(res);
	}

	@org.junit.Test
	public void testtmp3() throws FileNotFoundException, InterruptedException, ScriptException {
		int index = 4;
		String folder = "";
		String oriTraces = new Scanner(new File("benchmarks/tmptest2/test")).useDelimiter("\\Z").next();
		String correctTrace = new Scanner(new File("benchmarks/tmptest2/target")).useDelimiter("\\Z").next();
		MainEntrance me = new MainEntrance(oriTraces, correctTrace, index);
		String res = me.Synthesize(true,true).toString();
		System.out.println(res);
	}

	@org.junit.Test
	public void testtmpRe() throws FileNotFoundException, InterruptedException, ScriptException {
		int index = 7;
		String folder = "";
		String oriTraces = new Scanner(new File("benchmarks/tmptestRe/test")).useDelimiter("\\Z").next();
		String correctTrace = new Scanner(new File("benchmarks/tmptestRe/target")).useDelimiter("\\Z").next();
		MainEntrance me = new MainEntrance(oriTraces, correctTrace, index);
		String res = me.Synthesize(true,true).toString();
		System.out.println(res);
	}

	@org.junit.Test
	public void testtmpRe1() throws FileNotFoundException, InterruptedException, ScriptException {
		int index = 17;
		String folder = "";
		String oriTraces = new Scanner(new File("benchmarks/tmptestRe/test_re")).useDelimiter("\\Z").next();
		String correctTrace = new Scanner(new File("benchmarks/tmptestRe/target_re")).useDelimiter("\\Z").next();
		MainEntrance me = new MainEntrance(oriTraces, correctTrace, index);
		String res = me.Synthesize(true,true).toString();
		System.out.println(res);
	}

	@org.junit.Test
	public void testtmpEZ() throws FileNotFoundException, InterruptedException, ScriptException {
		int index = 4;
		String folder = "";
		String oriTraces = new Scanner(new File("benchmarks/tmptestEZ/test")).useDelimiter("\\Z").next();
		String correctTrace = new Scanner(new File("benchmarks/tmptestEZ/target")).useDelimiter("\\Z").next();
		MainEntrance me = new MainEntrance(oriTraces, correctTrace, index);
		String res = me.Synthesize(true,true).toString();
		System.out.println(res);
	}


	@org.junit.Test
	public void testtmpBig() throws FileNotFoundException, InterruptedException, ScriptException {
		int index = 5;
		String folder = "";
		String oriTraces = new Scanner(new File("benchmarks/tmptestBig/test")).useDelimiter("\\Z").next();
		String correctTrace = new Scanner(new File("benchmarks/tmptestBig/target")).useDelimiter("\\Z").next();
		MainEntrance me = new MainEntrance(oriTraces, correctTrace, index);
		String res = me.Synthesize(true,true).toString();
		System.out.println(res);
	}

	@org.junit.Test
	public void testtmpBig1() throws FileNotFoundException, InterruptedException, ScriptException {
		int index = 6;
		String folder = "";
		String oriTraces = new Scanner(new File("benchmarks/tmptestBig1/test")).useDelimiter("\\Z").next();
		String correctTrace = new Scanner(new File("benchmarks/tmptestBig1/target")).useDelimiter("\\Z").next();
		MainEntrance me = new MainEntrance(oriTraces, correctTrace, index);
		String res = me.Synthesize(true,true).toString();
		System.out.println(res);
	}

	@org.junit.Test
	public void testtmpIfAndFor() throws FileNotFoundException, InterruptedException, ScriptException {
		int index = 18;
		String folder = "";
		String oriTraces = new Scanner(new File("benchmarks/tmpifandfor/test")).useDelimiter("\\Z").next();
		String correctTrace = new Scanner(new File("benchmarks/tmpifandfor/target")).useDelimiter("\\Z").next();
		MainEntrance me = new MainEntrance(oriTraces, correctTrace, index);
		String res = me.Synthesize(true,true).toString();
		System.out.println(res);
	}

	@org.junit.Test
	public void testtmpSimpleRe() throws FileNotFoundException, InterruptedException, ScriptException {
		int index = 22;
		String folder = "";
		String oriTraces = new Scanner(new File("benchmarks/tmpSimpleRe/test")).useDelimiter("\\Z").next();
		String correctTrace = new Scanner(new File("benchmarks/tmpSimpleRe/target")).useDelimiter("\\Z").next();
		MainEntrance me = new MainEntrance(oriTraces, correctTrace, index);
		String res = me.Synthesize(true,true).toString();
		System.out.println(res);
	}

	@org.junit.Test
	public void testtmpLargestGap() throws FileNotFoundException, InterruptedException, ScriptException {
		int index = 15;
		String folder = "";
		String oriTraces = new Scanner(new File("benchmarks/tmpLargestGap/test")).useDelimiter("\\Z").next();
		String correctTrace = new Scanner(new File("benchmarks/tmpLargestGap/target")).useDelimiter("\\Z").next();
		MainEntrance me = new MainEntrance(oriTraces, correctTrace, index);
		String res = me.Synthesize(true,true).toString();
		System.out.println(res);
	}

	@org.junit.Test
	public void testtmpMax() throws FileNotFoundException, InterruptedException, ScriptException {
		int index = 9;
		String folder = "";
		String oriTraces = new Scanner(new File("benchmarks/tmpMax/test")).useDelimiter("\\Z").next();
		String correctTrace = new Scanner(new File("benchmarks/tmpMax/target")).useDelimiter("\\Z").next();
		MainEntrance me = new MainEntrance(oriTraces, correctTrace, index);
		String res = me.Synthesize(true,true).toString();
		System.out.println(res);
	}

	@org.junit.Test
	public void testtmpReWithoutPrint() throws FileNotFoundException, InterruptedException, ScriptException {
		int index = 10;
		String folder = "";
		String oriTraces = new Scanner(new File("benchmarks/tmpReWithoutPrint/test")).useDelimiter("\\Z").next();
		String correctTrace = new Scanner(new File("benchmarks/tmpReWithoutPrint/target")).useDelimiter("\\Z").next();
		MainEntrance me = new MainEntrance(oriTraces, correctTrace, index);
		String res = me.Synthesize(true,true).toString();
		System.out.println(res);
	}

	@org.junit.Test
	public void testtmpReStack() throws FileNotFoundException, InterruptedException, ScriptException {
		int index = 16;
		String folder = "";
		String oriTraces = new Scanner(new File("benchmarks/tmptestReStack/test")).useDelimiter("\\Z").next();
		String correctTrace = new Scanner(new File("benchmarks/tmptestReStack/target")).useDelimiter("\\Z").next();
		MainEntrance me = new MainEntrance(oriTraces, correctTrace, index);
		String res = me.Synthesize(true,true).toString();
		System.out.println(res);
	}
	
	// new1
	@org.junit.Test
	public void testnew1() throws FileNotFoundException, InterruptedException, ScriptException {
		int index = 6;
		String folder = "";
		String oriTraces = new Scanner(new File("benchmarks/new1/test")).useDelimiter("\\Z").next();
		String correctTrace = new Scanner(new File("benchmarks/new1/target")).useDelimiter("\\Z").next();
		MainEntrance me = new MainEntrance(oriTraces, correctTrace, index);
		String res = me.Synthesize(true,true).toString();
		System.out.println(res);
	}

	// new2
	@org.junit.Test
	public void testnew2() throws FileNotFoundException, InterruptedException, ScriptException {
		int index = 11;
		String folder = "";
		String oriTraces = new Scanner(new File("benchmarks/new2/test")).useDelimiter("\\Z").next();
		String correctTrace = new Scanner(new File("benchmarks/new2/target")).useDelimiter("\\Z").next();
		MainEntrance me = new MainEntrance(oriTraces, correctTrace, index);
		String res = me.Synthesize(true,true).toString();
		System.out.println(res);
	}
	
	// new3
	@org.junit.Test
	public void testnew3() throws FileNotFoundException, InterruptedException, ScriptException {
		int index = 7;
		String folder = "";
		String oriTraces = new Scanner(new File("benchmarks/LargestGap-1/largestGap1-test")).useDelimiter("\\Z").next();
		String correctTrace = new Scanner(new File("benchmarks/LargestGap-1/largestGap1-target")).useDelimiter("\\Z").next();
		MainEntrance me = new MainEntrance(oriTraces, correctTrace, index);
		String res = me.Synthesize(true,true).toString();
		System.err.println(res);
		System.err.println("--------------------------------------------"); // added
		System.err.println(res); // added
	}
}
