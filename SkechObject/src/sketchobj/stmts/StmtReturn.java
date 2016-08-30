package sketchobj.stmts;

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
}