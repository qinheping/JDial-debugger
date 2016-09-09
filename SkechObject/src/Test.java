
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import constraintfactory.ConstraintFactory;
import javaparser.simpleJavaLexer;
import javaparser.simpleJavaParser;
import sketchobj.core.Function;
import sketchobj.core.SketchObject;
import sketchobj.core.TypePrimitive;
import sketchobj.stmts.Statement;
import sketchobj.stmts.StmtBlock;
import visitor.EvalVisitor;

public class Test {

	@org.junit.Test
	public void test1() {
		Function f = ConstraintFactory.addConstFun(0, 5, new TypePrimitive(4));
		System.out.println(f);
	}
	
	@org.junit.Test
	public void test2() {
		Statement s = ConstraintFactory.constChangeDecl(5);
		System.out.println(s);
	}
	
	@org.junit.Test
	public void test3() {
		Statement s = ConstraintFactory.varArrayDecl("t", 5, new TypePrimitive(4));
		System.out.println(s);
	}
	
	@org.junit.Test
	public void test4() {
		List<String> otherVars = new ArrayList<String>();
		otherVars.add("y");
		otherVars.add("z");
		Statement s = ConstraintFactory.recordState(0, otherVars);
		System.out.println(s);
	}
	
	@org.junit.Test
	public void testReplaceConst() {
		ANTLRInputStream input = new ANTLRInputStream(
				"int largestGap(int[] a){ int max = 1; a[1] = 10; c = max++; int min = 100;  for(int i=0; i < a.Length; i++){ if(max < a[i]) max = a[i]; }return max-min;}");
		Function f = (Function) compile(input);
		Statement s = f.getBody();
		System.out.println(s);
		System.out.println(ConstraintFactory.repalceConst(s));
		System.out.println(s);
	}
	@org.junit.Test
	public void testRecordStmt() {
		ANTLRInputStream input = new ANTLRInputStream(
				"int largestGap(int[] a){ int max = 1; a[1] = 10; c = max++; int min = 100;  for(int i=0; i < a.Length; i++){ if(max < a[i]) max = a[i]; }return max-min;}");
		Function f = (Function) compile(input);
		Statement s = f.getBody();
		ConstraintFactory.repalceConst(s);
		ConstraintFactory.addRecordStmt((StmtBlock) s);
		System.out.println(s);
	}
	
	public static SketchObject compile(ANTLRInputStream input) {
		simpleJavaLexer lexer = new simpleJavaLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		simpleJavaParser parser = new simpleJavaParser(tokens);
		ParseTree tree = parser.methodDeclaration();
		return new EvalVisitor().visit(tree);
	}
}
