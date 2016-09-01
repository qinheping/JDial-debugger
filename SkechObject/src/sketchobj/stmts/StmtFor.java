package sketchobj.stmts;

import sketchobj.core.*;
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
		String result = "for("+init.toString()+"; "+cond.toString()+"; "+ incr.toString()+ "){\n";
		result += this.body + "}\n";
		return result;
	}
}
