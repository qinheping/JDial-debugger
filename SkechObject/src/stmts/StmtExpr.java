package stmts;

import core.SketchExpr;

public class StmtExpr extends Statement{
	private SketchExpr expr;
	 public StmtExpr( SketchExpr expr)
	    {
	        this.expr = expr;
	    }
}
