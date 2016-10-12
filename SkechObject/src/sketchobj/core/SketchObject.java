package sketchobj.core;

import constraintfactory.ConstData;

public abstract class SketchObject {
	protected int indentation;	// for toString

	private int line;
	public int getIndentation() {
		return indentation;
	}

	public void setIndentation(int indentation) {
		this.indentation = indentation;
	}

	public ConstData replaceConst(int index) {
		// TODO Auto-generated method stub
		return new ConstData(index,this.line);
	}
	
}
