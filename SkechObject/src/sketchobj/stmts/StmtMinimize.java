package sketchobj.stmts;

import java.util.Map;

import constraintfactory.ConstData;
import sketchobj.core.Context;
import sketchobj.core.Type;
import sketchobj.expr.Expression;

/**
 * The minimize statement, to tell the backend that some integer value needs to be
 * minimized.
 */
public class StmtMinimize extends Statement {
    private final Expression minimizeExpr;
    public final boolean userGenerated;

    public StmtMinimize(Expression minimizeExpr, final boolean userWritten) {
        this.minimizeExpr = minimizeExpr;
        this.userGenerated = userWritten;
    }

    public Expression getMinimizeExpr() {
        return minimizeExpr;
    }

    public String toString() {
        return "minimize(" + minimizeExpr + ");";
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
	public Map<String, Type> addRecordStmt(StmtBlock parent, int index, Map<String, Type> m) {
		// TODO Auto-generated method stub
		return null;
	}
}