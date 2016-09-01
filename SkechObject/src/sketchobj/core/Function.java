package sketchobj.core;

import java.util.*;

import sketchobj.stmts.Statement;

public class Function extends SketchObject {
	public static enum FcnType {
		// Uninterpreted Function
		Uninterp("uninterp"),
		// Async functions used in promela to model forks.
		Async("async"),
		// Static function, non-generator.
		Static(""),
		// Harness function. Also static.
		Harness("harness"),
		// Indicates an auto-generated wrapper function that initializes
		// globals, also
		// static.
		Wrapper(""),
		// Used for SMT solver, which is now unused. Email developers or look
		// for notes on
		// wiki.
		BuiltinHelper("builtin helper"),
		// Function that is inlined, producing more star values. Also helper
		// functions for
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

	private String name; // or null
	private Type returnType;
	private List<Parameter> params;
	private Statement body;
	private FcnType fcnType;

	public Function(String name, Type returnType, List<Parameter> params, Statement body, FcnType fcnType) {
		this.name = name;
		this.returnType = returnType;
		this.params = params;
		this.body = body;
		this.fcnType = fcnType;
	}

	public Function(FcnHeader head, Statement body) {
		this.name = head.name;
		this.returnType = head.returnType;
		this.params = head.params;
		this.body = body;
		this.fcnType = FcnType.Static;
	}

	public String printParams() {
		String s = "";
		boolean notf = false;
		for (Parameter p : params) {
			if (notf) {
				s += ", ";
			}
			if (p.isParameterOutput()) {
				s += "ref ";
			}
			s += p.getType() + " " + p.getName();
			notf = true;
		}
		return s;
	}

	public String toString() {
		String result;
		return fcnType.toString() + " " + returnType.toString()+ " " + name + "(" + printParams() + ")" + "{\n"+ body.toString()+ "}";
	}

}
