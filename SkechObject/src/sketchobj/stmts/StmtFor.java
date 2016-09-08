package sketchobj.stmts;

import java.util.ArrayList;
import java.util.List;

import constrainfactory.ConstData;
import sketchobj.core.*;
import sketchobj.expr.ExprConstant;
import sketchobj.expr.ExprFunCall;
import sketchobj.expr.Expression;

public class StmtFor extends Statement {
	private Expression cond;
	private Statement init, incr, body;

	public StmtFor(Statement init, Expression cond, Statement incr, Statement body, boolean isCanonical) {
		this.init = init;
		this.cond = cond;
		this.incr = incr;
		this.body = body;
	}

	public String toString() {
		String result = "for("+init.toString()+" "+cond.toString()+"; "+ incr.toString().substring(0, incr.toString().length()-2)+ "){\n";
		result += this.body + "}\n";
		return result;
	}

	@Override
	public ConstData replaceConst(int index) {
		List<SketchObject> toAdd = new ArrayList<SketchObject>();
		toAdd.add(init);
		toAdd.add(incr);
		toAdd.add(body);
		if (cond instanceof ExprConstant) {
			int value = ((ExprConstant) cond).getVal();
			Type t = ((ExprConstant) cond).getType();
			cond = new ExprFunCall("Const" + index, new ArrayList<Expression>());
			return new ConstData(t, toAdd, index + 1, value);
		}
		return new ConstData(null, toAdd, index, 0);
	}
}
