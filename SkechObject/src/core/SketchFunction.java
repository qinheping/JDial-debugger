package core;
import java.util.*;
import stmts.Statement;

public class SketchFunction extends SketchObject {
	public static enum FcnType {
        // Uninterpreted Function
        Uninterp("uninterp"),
        // Async functions used in promela to model forks.
        Async("async"),
        // Static function, non-generator.
        Static(""),
        // Harness function. Also static.
        Harness("harness"),
        // Indicates an auto-generated wrapper function that initializes globals, also
        // static.
        Wrapper(""),
        // Used for SMT solver, which is now unused. Email developers or look for notes on
        // wiki.
        BuiltinHelper("builtin helper"),
        // Function that is inlined, producing more star values. Also helper functions for
        // PROMELA.
        Generator("generator"),
        // Init("init");
        Model("model");

        /** identifier appearing in C code */
        public final String cCodeName;

        private FcnType(String cCodeName) {
            this.cCodeName = cCodeName;
        }
    }
    private  String name; // or null
	private  SketchType returnType;
    private  List<Parameter> params;
    private  Statement body;
    private  FcnType fcnType;
	
    public SketchFunction(String name, SketchType returnType, List<Parameter> params, Statement body, FcnType fcnType){
    	this.name = name;
    	this.returnType = returnType;
    	this.params = params;
    	this.body = body;
    	this.fcnType = fcnType;
    }

}
