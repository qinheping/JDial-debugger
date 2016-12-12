package sketchobj.core;

import java.util.List;

import constraintfactory.ConstData;

public class SketchNode extends SketchObject{

	private SketchNode parent;
	
	private List<ConstData> ConstInfos;
	
	public SketchNode getParent() {
		return parent;
	}

	public void setParent(SketchNode parent) {
		this.parent = parent;
	}

	@Override
	public ConstData replaceLinearCombination(int index) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
