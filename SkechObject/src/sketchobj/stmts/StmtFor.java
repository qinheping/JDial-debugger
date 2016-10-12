package sketchobj.stmts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import constraintfactory.ConstData;
import constraintfactory.ConstraintFactory;
import sketchobj.core.*;
import sketchobj.expr.ExprConstant;
import sketchobj.expr.ExprFunCall;
import sketchobj.expr.Expression;

public class StmtFor extends Statement {
	private Expression cond;
	private Statement init, incr, body;
	private int line;

	public StmtFor(Statement init, Expression cond, Statement incr, Statement body, boolean isCanonical, int i) {
		this.init = init;
		this.cond = cond;
		this.incr = incr;
		this.body = body;
		this.line = i;
	}

	public String toString() {
		String result = null;
		if (incr.toString().endsWith(";"))
			result = "for(" + init.toString() + " " + cond.toString() + "; "
					+ incr.toString().substring(0, incr.toString().length() - 1) + "){\n";
		else
			result = "for(" + init.toString() + " " + cond.toString() + "; "
					+ incr.toString().substring(0, incr.toString().length() - 2) + "){\n";

		result += this.body + "}\n";
		return result;
	}

	@Override
	public ConstData replaceConst(int index) {
		List<SketchObject> toAdd = new ArrayList<SketchObject>();
		toAdd.add(init);
		toAdd.add(incr);
		toAdd.add(body);
		if (cond instanceof ExprConstant) {
			int value = ((ExprConstant) cond).getVal();
			Type t = ((ExprConstant) cond).getType();
			cond = new ExprFunCall("Const" + index, new ArrayList<Expression>());
			return new ConstData(t, toAdd, index + 1, value, null, this.line);
		}else
			toAdd.add(cond);
		return new ConstData(null, toAdd, index, 0, null,this.line);
	}

	@Override
	public Context buildContext(Context ctx) {
		ctx.setLinenumber(this.line);
		this.setCtx(new Context(ctx));
		ctx = new Context(ctx);
		ctx.pushNewVars();
		int temp = ctx.getLinenumber();
		ctx = init.buildContext(ctx);
		ctx = incr.buildContext(ctx);
		ctx.setLinenumber(temp);
		ctx = body.buildContext(ctx);
		ctx.popVars();
		return ctx;

	}

	@Override
	public Map<String, Type> addRecordStmt(StmtBlock parent, int index, Map<String, Type> m) {
		m.putAll(body.getCtx().getAllVars());
		body = new StmtBlock(ConstraintFactory.recordState(this.getCtx().getLinenumber(),
				new ArrayList<String>(init.getCtx().getAllVars().keySet())), body);
		return ((StmtBlock) body).stmts.get(1).addRecordStmt((StmtBlock) body, 1, m);
	}
}