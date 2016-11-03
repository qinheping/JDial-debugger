package sketchobj.stmts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import constraintfactory.ConstData;
import constraintfactory.ConstraintFactory;
import sketchobj.core.*;
import sketchobj.expr.ExprBinary;
import sketchobj.expr.ExprConstant;
import sketchobj.expr.ExprFunCall;
import sketchobj.expr.Expression;

public class StmtFor extends Statement {
	private Expression cond;
	private Statement init, incr, body;
	private int line;

	public StmtFor(Statement init, Expression cond, Statement incr, Statement body, boolean isCanonical, int i) {
		this.init = init;
		init.setParent(this);
		this.cond = cond;
		cond.setParent(this);
		this.incr = incr;
		incr.setParent(this);
		this.body = body;
		body.setParent(this);
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
	public Context buildContext(Context prectx) {
		prectx.setLinenumber(this.line);
		this.setPrectx(prectx);
		this.setPostctx(new Context(prectx));
		Context postctx = new Context(prectx);
		
		postctx.pushNewVars();
		int temp = postctx.getLinenumber();
		postctx.setLinenumber(temp);
		postctx = init.buildContext(postctx);
		postctx = incr.buildContext(postctx);
		postctx = body.buildContext(postctx);
		postctx.popVars();
		return postctx;

	}

	@Override
	public Map<String, Type> addRecordStmt(StmtBlock parent, int index, Map<String, Type> m) {
		m.putAll(body.getPostctx().getAllVars());
		StmtBlock sb = new StmtBlock(ConstraintFactory.recordState(this.getPrectx().getLinenumber(), this.getPrectx().getAllVars()),this);
		sb = new StmtBlock(sb, ConstraintFactory.recordState(this.getPostctx().getLinenumber(), this.getPostctx().getAllVars()));
		parent.stmts.set(index, sb
				);
		body = new StmtBlock(ConstraintFactory.recordState(this.getPostctx().getLinenumber(),
				new ArrayList<String>(init.getPostctx().getAllVars().keySet())), body);
		body =  new StmtBlock(body,ConstraintFactory.recordState(this.getPostctx().getLinenumber(),
				new ArrayList<String>(init.getPostctx().getAllVars().keySet())));
		return ((StmtBlock) body).stmts.get(1).addRecordStmt((StmtBlock) body, 1, m);
	}

	@Override
	public void replaceLinearCombination() {
		init.replaceLinearCombination();
		incr.replaceLinearCombination();
		body.replaceLinearCombination();
		
	}

	@Override
	public boolean isBasic() {
		return true;
	}
}