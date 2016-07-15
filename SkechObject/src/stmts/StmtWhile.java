package stmts;

import core.SketchExpr;

public class StmtWhile {
    SketchExpr cond;
    Statement body;
    

    public StmtWhile(SketchExpr cond, Statement body)
    {
        this.cond = cond;
        this.body = body;
    }
    /** Returns the loop condition. */
    public SketchExpr getCond()
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