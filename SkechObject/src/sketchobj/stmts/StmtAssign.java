package sketchobj.stmts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import constraintfactory.ConstData;
import constraintfactory.ConstraintFactory;
import constraintfactory.ExternalFunction;
import global.Global;
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
//added
import constraintfactory.ConstraintFactory;

public class StmtAssign extends Statement {
	private Expression lhs, rhs;
	private int op; // operation += -= *= /=

	/**
	 * Creates a new assignment statement with the specified left- and
	 * right-hand sides and no operation (i.e., 'lhs=rhs;').
	 * 
	 * @param i
	 */
	public StmtAssign(Expression lhs, Expression rhs, int op, int line) {
		this.lhs = lhs;
		this.rhs = rhs;
		this.op = op;
		this.setLineNumber(line);
		this.lhs.setParent(this);
		this.rhs.setParent(this);

	}

	@Override
	public StmtAssign clone() {
		return new StmtAssign(lhs.clone(), rhs.clone(), op, this.getLineNumber());
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

	public void setLhs(Expression lhs) {
		this.lhs = lhs;
	}

	public void setRhs(Expression rhs) {
		this.rhs = rhs;
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
		return new ConstData(null, new ArrayList<SketchObject>(), index, 0, null, this.getLineNumber());
	}

	@Override
	public Context buildContext(Context prectx, int position) {
		Context postctx = new Context(prectx);
		prectx = new Context(prectx);
		postctx.setLinenumber(this.getLineNumber());
		prectx.setLinenumber(this.getLineNumber());
		if (lhs.toString().contains("ini")) {
			this.setPostctx(new Context(postctx));
			this.setPrectx(new Context(prectx));
			return postctx;
		}
		
		List<String> tmp = postctx.getVarsInScope();
		if (!tmp.contains(lhs.toString())&& (position > 0 || Global.dupFinals.contains(lhs.toString())
				|| Global.params.contains(lhs.toString()))) {
			//tmp.add(lhs.toString());
			postctx.addVar(lhs.toString(), TypePrimitive.inttype);
		} else if (!postctx.getAllVars().containsKey(lhs.toString())) {
			postctx.addVar(lhs.toString(), TypePrimitive.inttype);
		}
		if (!tmp.contains(lhs.toString()) && position > 0) {
			tmp.add(lhs.toString());
		}
		postctx.setVarsInScope(tmp);
		this.setPostctx(new Context(postctx));
		this.setPrectx(new Context(prectx));
		//System.err.println("assign is: " + this);
		//System.err.println("pretext is" + prectx);
		//System.err.println("postext is" + postctx);
		return postctx;
	}

	@Override
	public Map<String, Type> addRecordStmt(StmtBlock parent, int index, Map<String, Type> m) {
		parent.stmts = new ArrayList<Statement>(parent.stmts);
		//System.err.println("add assign is: " + this);
		//System.err.println("context is: " + this.getPrectx().getLinenumber() + this.getPrectx().getAllVars());
		//System.err.println("added is: " + ConstraintFactory.recordState(this.getPrectx().getLinenumber(), this.getPrectx().getAllVars()));
		/*if (Global.prime_mod) {
			parent.stmts.set(index, new StmtBlock(this,
					ConstraintFactory.recordState(this.getPrectx().getLinenumber(), this.getPrectx().getAllVars())));
		} else {*/
		if (!ConstraintFactory.dupStmt.contains(this))
			parent.stmts.set(index, new StmtBlock(
				ConstraintFactory.recordState(this.getPrectx().getLinenumber(), this.getPrectx().getAllVars()), this));
		//}
		//System.err.println("parent is: " + parent);
		//System.err.println("index: " + parent.stmts.get(index));
		m.putAll(this.getPostctx().getAllVars());
		//System.err.println("assign is: " + this);
		//System.err.println("m is: " + m);
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
		rhs.checkAtom();
		rhs.setLCadded(true);
		Type t = this.getPrectx().getAllVars().get(lhs.toString());
		if (rhs.isAtom()) {
			this.rhs = new ExprBinary(new ExprFunCall("Coeff" + index, new ArrayList<Expression>()), "*", this.rhs,
					this.getLineNumber());
			primaryIndex = index;
			index++;
		} else {
			rhs.setT(t);
			rhs.setCtx(this.getPrectx());
			toAdd.add(rhs);
		}
		List<Integer> liveVarsIndexSet = new ArrayList<Integer>();
		List<String> liveVarsNameSet = new ArrayList<String>();
		if ((t instanceof TypePrimitive) && ((TypePrimitive) t).getType() == 1) {
			rhs.setBoolean(true);
			;
			return new ConstData(null, new ArrayList<SketchObject>(), index, 0, null, this.getLineNumber());
		}
		if (t instanceof TypeArray) {
			return new ConstData(null, new ArrayList<SketchObject>(), index, 0, null, this.getLineNumber());
		}
		List<String> vars = new ArrayList<String>(this.getPrectx().getAllVars().keySet());
	/*	for (String v : vars) {
			//System.err.println("stmt: " + this);
			//System.err.println("available vars: " + vars);
			//System.err.println("current var: " + v);
			// all 1 dimension array

			if (this.getPrectx().getAllVars().get(v) instanceof TypeArray) {
				if (((TypePrimitive) ((TypeArray) this.getPostctx().getAllVars().get(v)).getBase())
						.getType() != ((TypePrimitive) t).getType())
					continue;

				/*
				 * Expression newTerm = new ExprBinary( new ExprFunCall("Coeff"
				 * + index, new ArrayList<Expression>()), "*", new
				 * ExprArrayRange(v, new ExprStar(), this.getLineNumber()));
				 * inits.set(i, new ExprBinary(inits.get(i), "+", newTerm));
				 * liveVarsIndexSet.add(index); liveVarsNameSet.add(v); index++;
				 */
	//			continue;
	/*		} else if (((TypePrimitive) this.getPrectx().getAllVars().get(v)).getType() != ((TypePrimitive) t)
					.getType())
				continue;
			/*
			 * if(v.equals(lhs.toString())) continue;
			 */
	/*		if (this.getPostctx().getVarsInScope().contains(v)){
				System.err.println("case: contain");
				continue;
			}
			Expression newTerm = new ExprBinary(new ExprFunCall("Coeff" + index, new ArrayList<Expression>()), "*",
					new ExprVar(v, t), this.getLineNumber());
			this.rhs = new ExprBinary(rhs, "+", newTerm, this.getLineNumber());
			liveVarsIndexSet.add(index);
			index++;
			liveVarsNameSet.add(v);
		}*/
		this.rhs = new ExprBinary(this.rhs, "+",
				new ExprBinary(new ExprFunCall("Coeff" + index), "*",
						new ExprFunCall("Coeff" + (index + 1), new ArrayList<Expression>()), this.getLineNumber()),
				this.getLineNumber());
		index = index + 2;
		return new ConstData(t, toAdd, index, 0, null, this.getLineNumber(), liveVarsIndexSet, liveVarsNameSet,
				primaryIndex);
	}

	@Override
	public Map<Integer, String> ConstructLineToString(Map<Integer, String> line_to_string) {
		line_to_string.put(this.getLineNumber(), this.toString());
		return line_to_string;
	}

	@Override
	public String toString_Context() {
		return this.toString() + ": " + this.getPostctx().toString();
	}

}
