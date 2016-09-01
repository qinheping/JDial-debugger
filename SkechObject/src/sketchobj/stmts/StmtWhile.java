package sketchobj.stmts;

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
}