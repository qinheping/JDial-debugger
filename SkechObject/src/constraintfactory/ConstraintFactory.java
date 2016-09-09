package constraintfactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import sketchobj.core.*;
import sketchobj.core.Function.FcnType;
import sketchobj.expr.*;
import sketchobj.stmts.*;
import trace.ProgState;
import trace.Trace;

public class ConstraintFactory {
	static int constNumber = 0;
	static int hitline = 0;
	static int hitnumber = 2;
	static int length = 5;
	static int originalLength = 5;

	Trace oriTrace;
	ProgState finalState;
	int finalCount;
	int finalLine;
	FcnHeader fh;

	public ConstraintFactory() {
		constNumber = 0;
	}

	public ConstraintFactory(Trace oriTrace, ProgState finalState, int finalCount, int finalLine, FcnHeader fh) {
		this.fh = fh;
		// TODO Auto-generated constructor stub
	}

	public Statement addConstraint(Statement source) {

		Statement s = source;
		Statement temp = ConstraintFactory.repalceConst(s);
		Map<String, Type> vars = ConstraintFactory.addRecordStmt((StmtBlock) s);
		List<String> varsNames = new ArrayList<String>(vars.keySet());
		List<Type> varsTypes = new ArrayList<Type>();
		for (int i = 0; i < varsNames.size(); i++) {
			varsTypes.add(vars.get(varsNames.get(i)));
		}
		Function f = new Function(this.fh, s);
		System.out.println(temp);
		System.out.println(varArrayDecls(varsNames, varsTypes));
		System.out.println(f);
		return s;
	}

	static public Statement constChangeDecl(int index, Type t) {
		return new StmtVarDecl(t, "const" + index + "change", new ExprStar());
	}

	static public Statement constChangeDecls(int number, Type t) {
		StmtBlock result = new StmtBlock();
		for (int i = 0; i < number; i++) {
			result.addStmt(new StmtVarDecl(t, "const" + i + "change", new ExprStar()));
		}
		return result;
	}
	
	static public Function constraintFunction(){
		List<Statement> stmts = new ArrayList<Statement>();
		
	}
	
	static public Statement constChangeDecl(int number) {
		return constChangeDecls(number, new TypePrimitive(4));
	}

	static public Statement varArrayDecl(String name, int length, Type type) {
		Type t = new TypeArray(type, new ExprConstInt(length));
		return new StmtVarDecl(t, name + "Array", null);
	}

	static public StmtBlock varArrayDecls(List<String> names, List<Type> types) {
		List<Statement> stmts = new ArrayList<Statement>();
		for (int i = 0; i < names.size(); i++) {
			Type tarray = new TypeArray(types.get(i), new ExprConstInt(length));
			stmts.add(new StmtVarDecl(tarray, names.get(i) + "Array", new ExprConstInt(0)));
		}
		return new StmtBlock(stmts);
	}

	static public Function addConstFun(int index, int ori, Type t) {
		Expression condition = new ExprBinary(new ExprVar("const" + index + "change"), "==", new ExprConstInt(1));
		StmtReturn return_1 = new StmtReturn(new ExprStar());
		StmtReturn return_2 = new StmtReturn(new ExprConstInt(ori));
		Statement ifst = new StmtIfThen(condition, return_1, return_2);

		return new Function("Const" + index, t, new ArrayList<Parameter>(), ifst, FcnType.Static);
	}

	static public Statement recordState(int lineNumber, List<String> Vars) {
		StmtBlock result = new StmtBlock();
		// count ++
		result.addStmt(new StmtExpr(new ExprUnary(5, new ExprVar("count"))));
		// varToUpdateArray[count] = varToUpdate;
		result.addStmt(new StmtAssign(
				new ExprArrayRange(new ExprVar("lineArray"), new ExprArrayRange.RangeLen(new ExprVar("count"), null)),
				new ExprConstInt(lineNumber)));
		if (lineNumber == hitline) {
			result.addStmt(new StmtExpr(new ExprUnary(5, new ExprVar("linehit"))));
			// TODO add if
		}
		for (String s : Vars) {
			result.addStmt(new StmtAssign(new ExprArrayRange(new ExprVar(s + "Array"),
					new ExprArrayRange.RangeLen(new ExprVar("count"), null)), new ExprVar(s)));
		}
		return result;
	}

	static public Statement repalceConst(Statement source) {
		List<Statement> list = new ArrayList<Statement>();
		Stack<SketchObject> stmtStack = new Stack<SketchObject>();
		int index = 0;
		stmtStack.push(source);
		while (!stmtStack.empty()) {
			SketchObject target = stmtStack.pop();
			ConstData data = target.replaceConst(index);
			if (data.getType() != null) {
				list.add(constChangeDecl(index, data.getType()));
				list.add(new StmtFunDecl(addConstFun(index, data.getValue(), data.getType())));
			}
			index = data.getIndex();
			pushAll(stmtStack, data.getChildren());
		}
		return new StmtBlock(list);
	}

	static public void buildContext(StmtBlock sb) {
		sb.buildContext(new Context());
	}

	static public Map<String, Type> addRecordStmt(StmtBlock sorce) {
		buildContext(sorce);

		return sorce.addRecordStmt(null, 0, new HashMap<String, Type>(), 1);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	static public void pushAll(Stack s, List l) {
		for (int i = l.size() - 1; i >= 0; i--) {
			s.push(l.get(i));
		}
	}

	public static Statement recordState(int linenumber, Map<String, Type> allVars) {
		return recordState(linenumber, new ArrayList<String>(allVars.keySet()));
	}
}
