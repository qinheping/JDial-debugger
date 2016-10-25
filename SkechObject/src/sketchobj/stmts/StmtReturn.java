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

/**
 * A return statement with an optional value. Functions returning void (including init and
 * work functions and message handlers) should have return statements with no value;
 * functions returning a particular type should have return statements with expressions of
 * that type.
 * 
 * @author David Maze &lt;dmaze@cag.lcs.mit.edu&gt;
 * @version $Id$
 */
public class StmtReturn extends Statement
{
    Expression value;
	private int line;

    /** Creates a new return statement, with the specified return value
     * (or null). */
    public StmtReturn(Expression value, int line)
    {
//        if (value instanceof ExprConstUnit) {
//            value = null;
//        }
        this.value = value;
        value.setParent(this);
        this.line = line;
    }



    /** Returns the return value of this, or null if there is no return
     * value. */
    public Expression getValue()
    {
        return value;
    }

    public String toString(){
        if(value != null){
            return "return " + value + ";";
        }else{
            return "return;";
        }
    }



	@Override
	public ConstData replaceConst(int index) {
		List<SketchObject> toAdd = new ArrayList<SketchObject>();
		if(value instanceof ExprConstant)
		{
			int v = ((ExprConstant)value).getVal();
			Type t = ((ExprConstant)value).getType();
			value = new ExprFunCall("Const"+index,new ArrayList<Expression>());
			return new ConstData(t, toAdd, index+1, v,null,this.getLineNumber());
		}
		return value.replaceConst(index);
	}



	@Override
	public Context buildContext(Context prectx) {
		prectx = new Context(prectx);
		prectx.setLinenumber(this.line);
		this.setPrectx(new Context(prectx));
		this.setPostctx(new Context(prectx));
		return prectx;
	}



	@Override
	public Map<String, Type> addRecordStmt(StmtBlock parent, int index, Map<String, Type> m) {
		parent.stmts.set(index,
				new StmtBlock(ConstraintFactory.recordState(this.getPrectx().getLinenumber(), this.getPrectx().getAllVars()),this));
		return m;
	}



	public int getLine() {
		return line;
	}



	public void setLine(int line) {
		this.line = line;
	}



	@Override
	public void replaceLinearCombination() {
		value.replaceLinearCombination();
	}



	@Override
	public boolean isBasic() {
		return true;
	}
}