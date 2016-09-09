package sketchobj.stmts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import constrainfactory.ConstData;
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

    /** Creates a new return statement, with the specified return value
     * (or null). */
    public StmtReturn(Expression value)
    {
//        if (value instanceof ExprConstUnit) {
//            value = null;
//        }
        this.value = value;
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
			return new ConstData(t, toAdd, index+1, v);
		}
		return value.replaceConst(index);
	}



	@Override
	public Context buildContext(Context ctx) {
		this.setCtx(ctx);
		return ctx;
	}



	@Override
	public Map<String, Type> addRecordStmt(StmtBlock parent, int index, Map<String, Type> m, int linenumber) {
		// TODO Auto-generated method stub
		return m;
	}
}