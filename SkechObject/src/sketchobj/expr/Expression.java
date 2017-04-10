package sketchobj.expr;

import java.util.ArrayList;
import java.util.List;

import constraintfactory.ConstData;
import constraintfactory.ExternalFunction;
import sketchobj.core.Context;
import sketchobj.core.SketchNode;
import sketchobj.core.SketchObject;
import sketchobj.core.Type;

public abstract class Expression extends SketchNode{

	public int lineNumber;
	private boolean isBoolean;
	private boolean isAtom;
	private Context ctx;
	private Type t;
	private boolean LCadded;
	
	
	public Integer getIValue() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public abstract ConstData replaceConst(int index, String string);
	public abstract void checkAtom();
	
	@Override
	public ConstData replaceConst(int index, List<Integer> repair_range) {
		if (repair_range.contains(this.lineNumber)){
			return this.replaceConst(index);
			}
			List<SketchObject> toAdd = new ArrayList<SketchObject>();
			return new ConstData(null, toAdd, index, 0, null,this.lineNumber);
	}
	@Override
	public abstract ConstData  replaceLinearCombination(int index);
	
	@Override
	public ConstData replaceLinearCombination(int index, List<Integer> allowRange){
		return this.replaceConst(index);
	}
	public abstract boolean equals(Expression other);

	public abstract List<ExternalFunction> extractExternalFuncs(List<ExternalFunction> externalFuncNames);

	public boolean isBoolean() {
		return isBoolean;
	}

	public void setBoolean(boolean isBoolean) {
		this.isBoolean = isBoolean;
	}

	public boolean isAtom() {
		return isAtom;
	}

	public void setAtom(boolean isAtom) {
		this.isAtom = isAtom;
	}

	public Context getCtx() {
		return ctx;
	}

	public void setCtx(Context ctx) {
		this.ctx = ctx;
	}

	public Type getT() {
		return t;
	}

	public void setT(Type t) {
		this.t = t;
	}

	public boolean isLCadded() {
		return LCadded;
	}

	public void setLCadded(boolean lCadded) {
		LCadded = lCadded;
	}
	
	public abstract Expression clone();

}