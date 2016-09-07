package sketchobj.stmts;

import java.util.ArrayList;

import sketchobj.expr.ExprConstInt;
import sketchobj.expr.ExprFunCall;
import sketchobj.expr.ExprStar;
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
	public int replaceConst(int index) {
		if(cond.getClass().equals(ExprConstInt.class))
		{
			cond = new ExprFunCall("Const"+index,new ArrayList());
			return index + 1;
		}
		return body.replaceConst(index);
	}
}