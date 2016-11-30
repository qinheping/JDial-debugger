package sketchobj.expr;

import java.util.ArrayList;
import java.util.List;

import constraintfactory.ConstData;
import sketchobj.core.SketchNode;
import sketchobj.core.SketchObject;

public abstract class Expression extends SketchNode{

	public int lineNumber;
	
	public Integer getIValue() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public abstract ConstData replaceConst(int index, String string);
	
	@Override
	public ConstData replaceConst(int index, List<Integer> repair_range) {
		if (repair_range.contains(this.lineNumber)){
			return this.replaceConst(index);

			}
			List<SketchObject> toAdd = new ArrayList<SketchObject>();
			return new ConstData(null, toAdd, index, 0, null,this.lineNumber);
	}
	
	public abstract void  replaceLinearCombination();
	
	public abstract boolean equals(Expression other);

}
