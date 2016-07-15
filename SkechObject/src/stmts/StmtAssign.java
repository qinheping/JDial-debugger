package stmts;
import core.SketchExpr;
public class StmtAssign extends Statement{
	private SketchExpr lhs, rhs;
    private int op;	// operation += -= *= /=

    /** Creates a new assignment statement with the specified left-
     * and right-hand sides and no operation (i.e., 'lhs=rhs;'). */
    public StmtAssign(SketchExpr lhs, SketchExpr rhs, int op)
    {
        this.lhs = lhs;
        this.rhs = rhs;
    }

    /** Creates a new assignment statement with the specified left-
     * and right-hand sides and no operation (i.e., 'lhs=rhs;'). */
    public StmtAssign(SketchExpr lhs, SketchExpr rhs)
    {
        this(lhs, rhs, 0);
    }
    

    /** Returns the left-hand side of this. */
    public SketchExpr getLHS()
    {
        return lhs;
    }

    /** Returns the right-hand side of this. */
    public SketchExpr getRHS()
    {
        return rhs;
    }

    /** Returns the operation for this.  This will be one of the constants
     * in ExprBinary or 0 if this is a simple assignment. */
    public int getOp()
    {
        return op;
    }
    
    public String toString()
    {
        String theOp;
        switch (op)
        {
        case 0: theOp = "="; break;
        case ExprBinary.BINOP_ADD: theOp = "+="; break;
        case ExprBinary.BINOP_SUB: theOp = "-="; break;
        case ExprBinary.BINOP_MUL: theOp = "*="; break;
        case ExprBinary.BINOP_DIV: theOp = "/="; break;
        default: theOp = "?= (" + op + ")"; break;
        }
        return lhs + " " + theOp + " " + rhs;
    }
}
