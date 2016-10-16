package sketchobj.stmts;

import java.util.ArrayList;
import java.util.HashMap;
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

public class StmtWhile extends Statement {
	Expression cond;
	Statement body;
	int line;
	
	public StmtWhile(Expression cond, Statement body, int i) {
		this.cond = cond;
		this.body = body;
		this.line = i;
	}

	/** Returns the loop condition. */
	public Expression getCond() {
		return cond;
	}

	/** Returns the loop body. */
	public Statement getBody() {
		return body;
	}

	public String toString() {
		return "while(" + getCond() + "){\n" + getBody() + "\n}";
	}

	@Override
	public ConstData replaceConst(int index) {
		List<SketchObject> toAdd = new ArrayList<SketchObject>();
		if (cond instanceof ExprConstant) {
			int value = ((ExprConstant) cond).getVal();
			Type t = ((ExprConstant) cond).getType();
			cond = new ExprFunCall("Const" + index, new ArrayList<Expression>());
			toAdd.add(body);
			return new ConstData(t, toAdd, index + 1, value, null,this.line);
		}
		toAdd.add(cond);
		toAdd.add(body);
		return new ConstData(null, toAdd, index, 0, null,this.line);
	}

	@Override
	public Context buildContext(Context prectx) {
		prectx = new Context(prectx);
		prectx.setLinenumber(this.line);
		Context postctx  = new Context(prectx);
		this.setPostctx(new Context(postctx));
		postctx.pushVars(new HashMap<String, Type>());
		postctx = body.buildContext(postctx);
		postctx.popVars();
		return postctx;
	}

	@Override
	public Map<String, Type> addRecordStmt(StmtBlock parent, int index, Map<String, Type> m) {
		parent.stmts.set(index,
				new StmtBlock(ConstraintFactory.recordState(this.getPrectx().getLinenumber(), this.getPrectx().getAllVars()),this));
		body = new StmtBlock(body,ConstraintFactory.recordState(body.getPostctx().getLinenumber(), new ArrayList<String>(body.getPostctx().getAllVars().keySet())));
		m.putAll(this.getPostctx().getAllVars());
		return ((StmtBlock)body).stmts.get(0).addRecordStmt((StmtBlock) body,0,m);
	}
}