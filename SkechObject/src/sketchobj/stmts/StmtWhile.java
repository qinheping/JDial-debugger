package sketchobj.stmts;

import java.util.ArrayList;
import java.util.List;

import constrainfactory.ConstData;
import sketchobj.core.SketchObject;
import sketchobj.core.Type;
import sketchobj.expr.ExprConstant;
import sketchobj.expr.ExprFunCall;
import sketchobj.expr.Expression;

public class StmtWhile extends Statement{
    Expression cond;
    Statement body;
    

    public StmtWhile(Expression cond, Statement body)
    {
        this.cond = cond;
        this.body = body;
    }
    /** Returns the loop condition. */
    public Expression getCond()
    {
        return cond;
    }

    /** Returns the loop body. */
    public Statement getBody()
    {
        return body;
    }
    
    public String toString(){
    	return "while(" + getCond() + "){\n" + getBody() +  "\n}";
    }
	@Override
	public ConstData replaceConst(int index) {
		List<SketchObject> toAdd = new ArrayList<SketchObject>();
		if(cond instanceof ExprConstant)
		{
			int value = ((ExprConstant)cond).getVal();
			Type t = ((ExprConstant)cond).getType();
			cond = new ExprFunCall("Const"+index,new ArrayList<Expression>());
			toAdd.add(body);
			return new ConstData(t, toAdd, index+1, value);
		}
		toAdd.add(cond);
		toAdd.add(body);
		return new ConstData(null,toAdd,index,0);
	}
}