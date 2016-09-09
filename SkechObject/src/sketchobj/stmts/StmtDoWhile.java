package sketchobj.stmts;

import java.util.Map;

import constrainfactory.ConstData;
import sketchobj.core.Context;
import sketchobj.core.Type;
import sketchobj.expr.Expression;

public class StmtDoWhile extends Statement {
	Statement body;
	Expression cond;

	/** Creates a new while loop. */
	public StmtDoWhile(Statement body, Expression cond) {
		this.body = body;
		this.cond = cond;
	}

	@Override
	public int size() {
		return body == null ? 0 : body.size();
	}

	/** Returns the loop body. */
	public Statement getBody() {
		return body;
	}

	/** Returns the loop condition. */
	public Expression getCond() {
		return cond;
	}

	@Override
	public ConstData replaceConst(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Context buildContext(Context ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Type> addRecordStmt(StmtBlock parent, int index, Map<String, Type> m, int linenumber) {
		// TODO Auto-generated method stub
		return null;
	}
}
