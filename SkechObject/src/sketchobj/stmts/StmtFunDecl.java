package sketchobj.stmts;

import java.util.Map;

import constraintfactory.ConstData;
import sketchobj.core.Context;
import sketchobj.core.Function;
import sketchobj.core.Type;

/**
 * This is used to define a function inside the scope of a function.
 */
public class StmtFunDecl extends Statement {

    Function decl;

    public StmtFunDecl( Function decl) {
        this.decl = decl;
    }

    public Function getDecl() {
        return decl;
    }

    public String toString() {
        return decl.toString();
    }

	@Override
	public ConstData replaceConst(int index) {
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

	@Override
	public void replaceLinearCombination() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isBasic() {
		return false;
	}
}