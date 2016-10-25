package sketchobj.expr;

import constraintfactory.ConstData;
import sketchobj.core.SketchNode;
import sketchobj.core.SketchObject;

public abstract class Expression extends SketchNode{

	public Integer getIValue() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public abstract ConstData replaceConst(int index, String string);

	public void replaceLinearCombination() {
		// TODO Auto-generated method stub
		
	}

}
