package sketchobj.stmts;

import java.util.ArrayList;
import java.util.Map;

import constrainfactory.ConstData;
import constrainfactory.ConstrainFactory;
import sketchobj.core.Context;
import sketchobj.core.Type;
import sketchobj.expr.ExprBinary;
import sketchobj.expr.ExprConstant;
import sketchobj.expr.ExprFunCall;
import sketchobj.expr.Expression;

public class StmtAssign extends Statement {
	private Expression lhs, rhs;
	private int op; // operation += -= *= /=

	/**
	 * Creates a new assignment statement with the specified left- and
	 * right-hand sides and no operation (i.e., 'lhs=rhs;').
	 */
	public StmtAssign(Expression lhs, Expression rhs, int op) {
		this.lhs = lhs;
		this.rhs = rhs;
	}

	/**
	 * Creates a new assignment statement with the specified left- and
	 * right-hand sides and no operation (i.e., 'lhs=rhs;').
	 */
	public StmtAssign(Expression lhs, Expression rhs) {
		this(lhs, rhs, 0);
	}

	/** Returns the left-hand side of this. */
	public Expression getLHS() {
		return lhs;
	}

	/** Returns the right-hand side of this. */
	public Expression getRHS() {
		return rhs;
	}

	/**
	 * Returns the operation for this. This will be one of the constants in
	 * ExprBinary or 0 if this is a simple assignment.
	 */
	public int getOp() {
		return op;
	}

	public String toString() {
		String theOp;
		switch (op) {
		case 0:
			theOp = "=";
			break;
		case ExprBinary.BINOP_ADD:
			theOp = "+=";
			break;
		case ExprBinary.BINOP_SUB:
			theOp = "-=";
			break;
		case ExprBinary.BINOP_MUL:
			theOp = "*=";
			break;
		case ExprBinary.BINOP_DIV:
			theOp = "/=";
			break;
		default:
			theOp = "?= (" + op + ")";
			break;
		}
		return lhs + " " + theOp + " " + rhs + ";";
	}

	@SuppressWarnings("rawtypes")
	@Override
	public ConstData replaceConst(int index) {
		if (rhs instanceof ExprConstant) {
			int value = ((ExprConstant) rhs).getVal();
			Type t = ((ExprConstant) rhs).getType();
			rhs = new ExprFunCall("Const" + index, new ArrayList<Expression>());
			return new ConstData(t, new ArrayList(), index + 1, value);
		}
		return rhs.replaceConst(index);
	}

	@Override
	public Context buildContext(Context ctx) {
		this.setCtx(ctx);
		return ctx;
	}

	@Override
	public Map<String, Type> addRecordStmt(StmtBlock parent, int index, Map<String, Type> m, int linenumber) {
		parent.stmts = new ArrayList<Statement>(parent.stmts);
		parent.stmts.set(index,
				new StmtBlock(this, ConstrainFactory.recordState(linenumber, this.getCtx().getAllVars())));
		m.putAll(this.getCtx().getAllVars());
		return m;
	}
}
