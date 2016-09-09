import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import constraintfactory.ConstraintFactory;
import javaparser.simpleJavaLexer;
import javaparser.simpleJavaParser;
import sketchobj.core.Function;
import sketchobj.core.SketchObject;
import trace.ProgState;
import trace.Trace;
import visitor.EvalVisitor;

public class Main {
	public static void main(String[] args) throws Exception {
		ANTLRInputStream input = new ANTLRInputStream(
				"int largestGap(int[] a){ int max = 1; a[1] = 10; c = max++; int min = 100;  for(int i=0; i < a.Length; i++){ if(max < a[i]) max = a[i]; }return max-min;}");
		Function root = (Function) compile(input);
		
		///////  specification
		Trace oriTrace = new Trace();
		ProgState finalState = null;
		int finalCount = 0;
		///////
		
		//int finalLine = oriTrace.getTraces().get(finalCount).getLine();
		int finalLine = 0;
		ConstraintFactory cf = new ConstraintFactory(oriTrace, finalState, finalCount, finalLine);
		cf.addConstraint(root.getBody());
	}

	public static SketchObject compile(ANTLRInputStream input) {
		simpleJavaLexer lexer = new simpleJavaLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		simpleJavaParser parser = new simpleJavaParser(tokens);
		ParseTree tree = parser.methodDeclaration();
		return new EvalVisitor().visit(tree);
	}
}
