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
import sketchobj.expr.ExprBinary;
import sketchobj.expr.ExprConstInt;
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
    public StmtReturn(Expression value, int line)
    {
//        if (value instanceof ExprConstUnit) {
//            value = null;
//        }
        this.value = value;
        value.setParent(this);
        this.setLineNumber(line);
    }
    public StmtReturn(Expression value)
    {
    	this(value, 0);
    }
    public StmtReturn( int line)
    {
//        if (value instanceof ExprConstUnit) {
//            value = null;
//        }
    	this.value = null;
        this.setLineNumber(line);
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
	public ConstData replaceConst_Exclude_This(int index, List<Integer> repair_range) {
		return new ConstData(null, new ArrayList<SketchObject>(), index, 0, null,this.getLineNumber());
	}

	@Override
	public Context buildContext(Context prectx) {
		prectx = new Context(prectx);
		prectx.setLinenumber(this.getLineNumber());
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





	@Override
	public ConstData replaceLinearCombination(int index){
		return new ConstData(null, new ArrayList<SketchObject>(), index, 0, null,this.getLineNumber());
	}



	@Override
	public boolean isBasic() {
		return true;
	}
	@Override
	public List<ExternalFunction> extractExternalFuncs(List<ExternalFunction> externalFuncNames) {
		return value.extractExternalFuncs(externalFuncNames);
	}
	@Override
	public Map<Integer, String> ConstructLineToString(Map<Integer, String> line_to_string) {
		// TODO Auto-generated method stub
		return null;
	}
}