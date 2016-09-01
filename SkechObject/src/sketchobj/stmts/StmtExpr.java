package sketchobj.stmts;

import sketchobj.expr.Expression;

public class StmtExpr extends Statement{
	private Expression expr;
	 public StmtExpr( Expression expr)
	    {
	        this.expr = expr;
	    }
	 public String toString(){
		 return expr.toString()+";";
	 }
}
