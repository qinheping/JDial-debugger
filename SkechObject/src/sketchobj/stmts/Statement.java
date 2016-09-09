package sketchobj.stmts;


import java.util.Map;

import constrainfactory.ConstData;
import sketchobj.core.Context;
import sketchobj.core.SketchObject;
import sketchobj.core.Type;

public abstract class Statement extends SketchObject{

	private int lineNumber;
	private boolean sorceCode;
	private Context ctx;
	
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}
	
	public boolean isSorce(){
		return this.sorceCode;
	}
	
	public abstract ConstData replaceConst(int index);

	public Context getCtx() {
		return ctx;
	}

	public void setCtx(Context ctx) {
		this.ctx = ctx;
	}
	
	public abstract Context buildContext(Context ctx);
	
	public abstract Map<String,Type> addRecordStmt(StmtBlock parent, int index, Map<String,Type> m, int linenumber);
}
