package sketchobj.stmts;

import constrainfactory.ConstData;
import sketchobj.core.Function;

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
}