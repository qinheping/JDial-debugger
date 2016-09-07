package sketchobj.stmts;

import sketchobj.expr.Expression;

public class StmtDoWhile extends Statement
{
    Statement body;
    Expression cond;

    /** Creates a new while loop. */
    public StmtDoWhile( Statement body, Expression cond)
    {
        this.body = body;
        this.cond = cond;
    }


    @Override
    public int size() {
        return body == null ? 0 : body.size();
    }

    /** Returns the loop body. */
    public Statement getBody()
    {
        return body;
    }

    /** Returns the loop condition. */
    public Expression getCond()
    {
        return cond;
    }


	@Override
	public int replaceConst(int index) {
		// TODO Auto-generated method stub
		return 0;
	}
}
