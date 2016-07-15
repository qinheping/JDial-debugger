package stmts;

import core.*;

public class StmtFor extends Statement {
	private SketchExpr cond;
	private Statement init, incr, body;

	public StmtFor(Statement init, SketchExpr cond, Statement incr, Statement body, boolean isCanonical) {
		this.init = init;
		this.cond = cond;
		this.incr = incr;
		this.body = body;
	}

	public String toString() {
		String result = "for(...){\n";
		result += this.body + "}\n";
		return result;
	}
}
