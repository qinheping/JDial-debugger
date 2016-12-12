package sketchobj.stmts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import constraintfactory.ConstData;
import constraintfactory.ConstraintFactory;
import constraintfactory.ExternalFunction;
import sketchobj.core.Context;
import sketchobj.core.SketchObject;
import sketchobj.core.Type;
import sketchobj.core.TypeArray;
import sketchobj.core.TypePrimitive;
import sketchobj.expr.ExprBinary;
import sketchobj.expr.ExprConstInt;
import sketchobj.expr.ExprConstant;
import sketchobj.expr.ExprFunCall;
import sketchobj.expr.ExprVar;
import sketchobj.expr.Expression;

public class StmtAssign extends Statement {
	private Expression lhs, rhs;
	private int op; // operation += -= *= /=

	/**
	 * Creates a new assignment statement with the specified left- and
	 * right-hand sides and no operation (i.e., 'lhs=rhs;').
	 * 
	 * @param i
	 */
	public StmtAssign(Expression lhs, Expression rhs, int op, int i) {
		this.lhs = lhs;
		this.rhs = rhs;
		this.op = op;
		this.setLineNumber(i);
		this.lhs.setParent(this);
		this.rhs.setParent(this);

	}

	/**
	 * Creates a new assignment statement with the specified left- and
	 * right-hand sides and no operation (i.e., 'lhs=rhs;').
	 */
	public StmtAssign(Expression lhs, Expression rhs, int line) {
		this(lhs, rhs, 0, line);
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
			return new ConstData(t, new ArrayList(), index + 1, value, lhs.toString(), this.getLineNumber());
		}
		return rhs.replaceConst(index, lhs.toString());
	}

	@Override
	public ConstData replaceConst_Exclude_This(int index, List<Integer> repair_range) {
		return new ConstData(null, new ArrayList<SketchObject>(), index, 0, null,this.getLineNumber());
	}

	@Override
	public Context buildContext(Context prectx) {
		Context postctx = new Context(prectx);
		prectx = new Context(prectx);
		postctx.setLinenumber(this.getLineNumber());
		prectx.setLinenumber(this.getLineNumber());

		this.setPostctx(new Context(postctx));
		this.setPrectx(new Context(prectx));
		return postctx;
	}

	@Override
	public Map<String, Type> addRecordStmt(StmtBlock parent, int index, Map<String, Type> m) {
		parent.stmts = new ArrayList<Statement>(parent.stmts);
		parent.stmts.set(index, new StmtBlock(
				ConstraintFactory.recordState(this.getPrectx().getLinenumber(), this.getPrectx().getAllVars()), this));
		m.putAll(this.getPrectx().getAllVars());
		return m;
	}



	@Override
	public boolean isBasic() {
		return true;
	}

	@Override
	public List<ExternalFunction> extractExternalFuncs(List<ExternalFunction> externalFuncNames) {
		return rhs.extractExternalFuncs(externalFuncNames);
	}

	@Override
	public ConstData replaceLinearCombination(int index) {
		Integer primaryIndex = -1;
		List<SketchObject> toAdd = new ArrayList<SketchObject>();
		toAdd.add(rhs);
		rhs.checkAtom();
		if(rhs.isAtom()){
			this.rhs = new ExprBinary(new ExprFunCall("Coeff"+index, new ArrayList<Expression>()),"*",this.rhs);
			primaryIndex = index;
			index++;
		}
		Type t = this.getPrectx().getAllVars().get(lhs.toString());
		List<Integer> liveVarsIndexSet = new ArrayList<Integer>();
		List<String> liveVarsNameSet = new ArrayList<String>();
		if((t instanceof TypePrimitive) && ((TypePrimitive)t).getType() == 1){
			rhs.setBoolean(true);;
			return new ConstData(null, new ArrayList<SketchObject>(), index, 0, null,this.getLineNumber());
		}
		if(t instanceof TypeArray){
					return new ConstData(null, new ArrayList<SketchObject>(), index, 0, null,this.getLineNumber());
		}
		List<String> vars = new ArrayList<String>(this.getPrectx().getAllVars().keySet());
		for(String v: vars){
			if(((TypePrimitive)this.getPrectx().getAllVars().get(v)).getType() != ((TypePrimitive)t).getType())
				continue;
			Expression newTerm = new ExprBinary(new ExprFunCall("Coeff"+index, new ArrayList<Expression>()),"*",new ExprVar(v,t));
			this.rhs= new ExprBinary(rhs,"+",newTerm);
			liveVarsIndexSet.add(index);
			index++;
			liveVarsNameSet.add(v);
		}
		this.rhs = new ExprBinary(this.rhs, "+", new ExprFunCall("Const" + index, new ArrayList<Expression>()));
		return new ConstData(t, toAdd,index++,0,null,this.getLineNumber(),liveVarsIndexSet,liveVarsNameSet,primaryIndex);
	}

}
