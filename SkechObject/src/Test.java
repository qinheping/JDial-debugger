
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import constraintfactory.ConstraintFactory;
import javaparser.simpleJavaLexer;
import javaparser.simpleJavaParser;
import sketchobj.core.FcnHeader;
import sketchobj.core.Function;
import sketchobj.core.SketchObject;
import sketchobj.core.TypePrimitive;
import sketchobj.stmts.Statement;
import sketchobj.stmts.StmtBlock;
import trace.ProgState;
import trace.Trace;
import visitor.EvalVisitor;

public class Test {

	@org.junit.Test
	public void test1() {
		Function f = ConstraintFactory.addConstFun(0, 5, new TypePrimitive(4));
		//System.out.println(f);
	}
	

	
	@org.junit.Test
	public void test3() {
		Statement s = ConstraintFactory.varArrayDecl("t", 5, new TypePrimitive(4));
		//System.out.println(s);
	}
	
	@org.junit.Test
	public void test4() {
		List<String> otherVars = new ArrayList<String>();
		otherVars.add("y");
		otherVars.add("z");
		Statement s = ConstraintFactory.recordState(0, otherVars);
		//System.out.println(s);
	}
	
	@org.junit.Test
	public void testReplaceConst() {
		ANTLRInputStream input = new ANTLRInputStream(
				"int largestGap(int[] a){ int max = 1; a[1] = 10; c = max++; int min = 100;  for(int i=0; i < a.Length; i++){ if(max < a[i]) max = a[i]; }return max-min;}");
		Function f = (Function) compile(input);
		Statement s = f.getBody();
	//	System.out.println(s);
		//System.out.println(ConstraintFactory.repalceConst(s));
	//	System.out.println(s);
	}
	@org.junit.Test
	public void testRecordStmt() {
		ANTLRInputStream input = new ANTLRInputStream(
				"int largestGap(int[] a){ int max = 1; a[1] = 10; c = max++; int min = 100;  for(int i=0; i < a.Length; i++){ if(max < a[i]) max = a[i]; }return max-min;}");
		Function f = (Function) compile(input);
		Statement s = f.getBody();
		ConstraintFactory.repalceConst(s);
		ConstraintFactory.addRecordStmt((StmtBlock) s);
	//	System.out.println(s);
	}
	
	@org.junit.Test
	public void testSimpleExample() throws InterruptedException{
		ANTLRInputStream input = new ANTLRInputStream(
				"int SimpleJava(){ int a = 2; int b =5; int c = a+ b; return c;}");
		Function root = (Function) compile(input);
	
		
		List<ProgState> traces = new ArrayList<ProgState>();
		// {line = 1, a = 2}
		Map<String, Integer> m1 = new HashMap<String, Integer>();
		m1.put("a", 2);
		ProgState state1 = new ProgState(1,m1);
		traces.add(state1);
		
		// {line = 2, a = 2, b = 5}
		Map<String,Integer> m2 = new HashMap<String, Integer>(m1);
		m2.put("b", 5);
		ProgState state2 = new ProgState(2,m2);
		traces.add(state2);
		
		// {line = 3, a = 2, b = 5, c = 7}		
		Map<String,Integer> m3 = new HashMap<String, Integer>(m2);
		m3.put("c", 7);
		ProgState state3 = new ProgState(3,m3);
		traces.add(state3);
		
		// correct: {line = 3, c = 8}
		Map<String,Integer> m4 = new HashMap<String, Integer>();
		m4.put("c", 8);
		ProgState finalState = new ProgState(3, m4);
		

		Trace oriTrace = new Trace(traces);
		///////
		
		ConstraintFactory cf = new ConstraintFactory(oriTrace, finalState,  new FcnHeader(root.getName(),root.getReturnType(),root.getParames()));
		
		String script = cf.getScript(root.getBody());
		System.out.println(CallSketch.CallByString(script));
	}
	
	public static SketchObject compile(ANTLRInputStream input) {
		simpleJavaLexer lexer = new simpleJavaLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		simpleJavaParser parser = new simpleJavaParser(tokens);
		ParseTree tree = parser.methodDeclaration();
		return new EvalVisitor().visit(tree);
	}
}
