package sketchobj.stmts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import constraintfactory.ConstData;
import constraintfactory.ConstraintFactory;
import sketchobj.core.Context;
import sketchobj.core.SketchObject;
import sketchobj.core.Type;
import sketchobj.expr.ExprConstant;
import sketchobj.expr.ExprFunCall;
import sketchobj.expr.Expression;

public class StmtExpr extends Statement {
	private Expression expr;

	public StmtExpr(Expression expr) {
		this.expr = expr;
	}

	public String toString() {
		return expr.toString() + ";";
	}

	@Override
	public ConstData replaceConst(int index) {
		List<SketchObject> toAdd = new ArrayList<SketchObject>();
		if (expr instanceof ExprConstant) {
			int value = ((ExprConstant) expr).getVal();
			Type t = ((ExprConstant) expr).getType();
			expr = new ExprFunCall("Const" + index, new ArrayList<Expression>());
			return new ConstData(t, toAdd, index + 1, value,null);
		}
		return expr.replaceConst(index);
	}

	@Override
	public Context buildContext(Context ctx) {
		ctx = new Context(ctx);
		ctx.linePlus();
		this.setCtx(new Context(ctx));
		return ctx;
	}

	@Override
	public Map<String, Type> addRecordStmt(StmtBlock parent, int index, Map<String, Type> m) {
		parent.stmts.set(index,
				new StmtBlock(this, ConstraintFactory.recordState(this.getCtx().getLinenumber(), this.getCtx().getAllVars())));
		m.putAll(this.getCtx().getAllVars());
		return m;
	}
}
