import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import constraintfactory.ConstraintFactory;
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

	public MainEntrance(String json, String correctTrace, int indexOfCorrectTrace) {
		this.json = json;
		this.correctTrace = correctTrace;
		this.indexOfCorrectTrace = indexOfCorrectTrace;
	}

	public Feedback Synthesize() {
		this.targetFunc = extractFuncName(correctTrace);
		this.root = jsonRootCompile(this.json);
		this.code = root.getCode().getCode();
		this.traces = root.getTraces();
		
		ANTLRInputStream input = new ANTLRInputStream(code);
		Function function = (Function) javaCompile(input,targetFunc);
		
		ConstraintFactory cf = new ConstraintFactory(traces, jsonTraceCompile(correctTrace),
				new FcnHeader(function.getName(), function.getReturnType(), function.getParames()));
		
		String script = cf.getScript(function.getBody());
		System.out.println(script);
		return null;
	}

	public String extractFuncName(String trace) {
		Trace tr = jsonTraceCompile(trace);
		return tr.getFuncname();
	}

	public static Root jsonRootCompile(String s){
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
	public static SketchObject javaCompile(ANTLRInputStream input,String target) {
		simpleJavaLexer lexer = new simpleJavaLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		simpleJavaParser parser = new simpleJavaParser(tokens);
		ParseTree tree = parser.methodDeclaration();
		return new JavaVisitor(target).visit(tree);
	}
}