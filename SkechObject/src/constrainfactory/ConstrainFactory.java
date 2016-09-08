package constrainfactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import sketchobj.core.*;
import sketchobj.core.Function.FcnType;
import sketchobj.expr.*;
import sketchobj.stmts.*;

public class ConstrainFactory {
	static int constNumber = 0;
	static int hitline = 0;
	static int hitnumber = 2;
	

	static public Function addConstFun(int index, int ori, Type t) {
		Expression condition = new ExprBinary(new ExprVar("const" + index + "change"), "==", new ExprConstInt(1));
		StmtReturn return_1 = new StmtReturn(new ExprStar());
		StmtReturn return_2 = new StmtReturn(new ExprConstInt(ori));
		Statement ifst = new StmtIfThen(condition, return_1, return_2);
		
		return new Function("Const" + index, t, new ArrayList<Parameter>(), ifst, FcnType.Static);
	}

	public ConstrainFactory() {
		constNumber = 0;
	}

	static public Statement constChangeDecl(int number) {
		StmtBlock result = new StmtBlock();
		for (int i = 0; i < number; i++) {
			result.addStmt(new StmtVarDecl(new TypePrimitive(1), "const" + i + "change", new ExprStar()));
		}
		return result;
	}

	static public Statement varArrayDecl(String name, int length, Type type) {
		Type t = new TypeArray(type, new ExprConstInt(length));
		return new StmtVarDecl(t, name + "Array", null);
	}

	static public Statement recordState(int lineNumber, List<String> Vars){
		StmtBlock result = new StmtBlock();
		// count ++
		result.addStmt(new StmtExpr(new ExprUnary(5, new ExprVar("count"))));
		// varToUpdateArray[count] = varToUpdate;
		result.addStmt(new StmtAssign(new ExprArrayRange(new ExprVar("lineArray"), new ExprArrayRange.RangeLen(new ExprVar("count"),null)),new ExprConstInt(lineNumber)));
		if(lineNumber == hitline){
			result.addStmt(new StmtExpr(new ExprUnary(5, new ExprVar("linehit"))));
			// TODO add if
		}
		for(String s: Vars){
			result.addStmt(new StmtAssign(new ExprArrayRange(new ExprVar(s+"Array"), new ExprArrayRange.RangeLen(new ExprVar("count"),null)),new ExprVar(s)));
		}
		return result;
	}
	
	static public void repalceConst(Statement source){
		Stack<SketchObject> stmtStack = new Stack<SketchObject>();
		int index = 0;
		stmtStack.push(source);
		while(!stmtStack.empty()){
			SketchObject target = stmtStack.pop();
			ConstData data = target.replaceConst(index);
			index = data.getIndex();
			pushAll(stmtStack,data.getChildren());
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	static public void pushAll(Stack s, List l){
		for(int i = l.size() - 1; i >=0; i--){
			s.push(l.get(i));
		}
	}
}
