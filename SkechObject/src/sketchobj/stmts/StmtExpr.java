package sketchobj.stmts;

import java.util.ArrayList;
import java.util.List;

import constrainfactory.ConstData;
import sketchobj.core.SketchObject;
import sketchobj.core.Type;
import sketchobj.expr.ExprConstant;
import sketchobj.expr.ExprFunCall;
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
	@Override
	public ConstData replaceConst(int index) {
		List<SketchObject> toAdd = new ArrayList<SketchObject>();
		if (expr instanceof ExprConstant) {
			int value = ((ExprConstant) expr).getVal();
			Type t = ((ExprConstant) expr).getType();
			expr = new ExprFunCall("Const" + index, new ArrayList<Expression>());
			return new ConstData(t, toAdd, index + 1, value);
		}
		return expr.replaceConst(index);
	}
}
