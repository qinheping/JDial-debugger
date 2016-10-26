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

public class StmtIfThen extends Statement {
	private Expression cond;
	private Statement cons, alt;
	private boolean isSingleFunCall = false;
	private boolean isSingleVarAssign = false;
	private int line;

	/**
	 * Create a new conditional statement, with the specified condition,
	 * consequent, and alternative. The two statements may be null if omitted.
	 * @param i 
	 */
	public StmtIfThen(Expression cond, Statement cons, Statement alt, int i) {
		this.cond = cond;
		cond.setParent(this);
		this.cons = cons;
		cons.setParent(this);
		this.alt = alt;
		if(alt!=null)
		alt.setParent(this);
		this.line = i;
	}
	public StmtIfThen(Expression cond, Statement cons, Statement alt) {
		this(cond,cons,alt,0);
	}

	// @Override
	// public int size() {
	// int sz_cons = cons == null ? 0 : cons.size();
	// int sz_alt = alt == null ? 0 : alt.size();
	// return sz_cons + sz_alt;
	// }

	/** Returns the condition of this. */
	public Expression getCond() {
		return cond;
	}

	/**
	 * Returns the consequent statement of this, which is executed if the
	 * condition is true.
	 */
	public Statement getCons() {
		return cons;
	}

	/**
	 * Return the alternative statement of this, which is executed if the
	 * condition is false.
	 */
	public Statement getAlt() {
		return alt;
	}

	public boolean isSingleFunCall() {
		return isSingleFunCall;
	}

	public void singleFunCall() {
		isSingleFunCall = true;
	}

	public boolean isSingleVarAssign() {
		return isSingleVarAssign;
	}

	public void singleVarAssign() {
		isSingleVarAssign = true;
	}

	public String toString() {
		String result = "if(" + this.cond + "){\n";
		result += this.cons;
		result += "}";
		if (this.alt != null) {
			result += "else{\n";
			result += this.alt + "}\n";
		} else {
			result += "\n";
		}
		return result;
	}

	@Override
	public ConstData replaceConst(int index) {
		List<SketchObject> toAdd = new ArrayList<SketchObject>();
		toAdd.add(cons);
		if (alt != null)
			toAdd.add(alt);
		if (cond instanceof ExprConstant) {
			int value = ((ExprConstant) cond).getVal();
			Type t = ((ExprConstant) cond).getType();
			cond = new ExprFunCall("Const" + index, new ArrayList<Expression>());
			return new ConstData(t, toAdd, index + 1, value,null,this.line);
		}
		return new ConstData(null, toAdd, index, 0,null,this.line);
	}

	@Override
	public Context buildContext(Context prectx) {
		prectx = new Context(prectx);
		prectx.setLinenumber(this.line);
		this.setPrectx(prectx);
		this.setPostctx(prectx);
		Context postctx = new Context(prectx);
		postctx.pushVars(new HashMap<String, Type>());
		postctx = cons.buildContext(postctx);
		postctx.popVars();
		if (alt != null) {
			postctx.pushNewVars();
			postctx = alt.buildContext(postctx);
			postctx.popVars();
		}
		return prectx;
	}

	@Override
	public Map<String, Type> addRecordStmt(StmtBlock parent, int index, Map<String, Type> m) {

		parent.stmts.set(index,
				new StmtBlock(ConstraintFactory.recordState(this.getPrectx().getLinenumber(), this.getPrectx().getAllVars()),this));
		
		this.cons = new StmtBlock(cons,ConstraintFactory.recordState(cons.getPostctx().getLinenumber(), cons.getPostctx().getAllVars()));
		m.putAll(((StmtBlock) cons).stmts.get(0).addRecordStmt((StmtBlock) cons, 0, m));
		if (alt != null) {
			this.alt = new StmtBlock(alt,ConstraintFactory.recordState(alt.getPostctx().getLinenumber(), alt.getPostctx().getAllVars()));
			m.putAll(((StmtBlock) alt).stmts.get(0).addRecordStmt((StmtBlock) alt, 0, m));
		}
		return m;
	}

	@Override
	public void replaceLinearCombination() {
		cons.replaceLinearCombination();
		if(alt!= null)
			alt.replaceLinearCombination();
	}

	@Override
	public boolean isBasic() {
		return true;
	}

}