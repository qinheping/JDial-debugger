package sketchobj.expr;

import constrainfactory.ConstData;
import sketchobj.core.SketchObject;

public abstract class Expression extends SketchObject{

	public Integer getIValue() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public abstract ConstData replaceConst(int index);

}
