package sketchobj.stmts;

import sketchobj.core.SketchObject;

public abstract class Statement extends SketchObject{

	private int lineNumber;
	private boolean sorceCode;
	
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
	
	public abstract int replaceConst(int index);

}
