package sketchobj.core;

public abstract class SketchObject {
	protected int indentation;	// for toString

	public int getIndentation() {
		return indentation;
	}

	public void setIndentation(int indentation) {
		this.indentation = indentation;
	}
	
}
