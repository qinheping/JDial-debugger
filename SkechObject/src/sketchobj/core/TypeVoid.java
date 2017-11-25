package sketchobj.core;

import constraintfactory.ConstData;

public class TypeVoid extends Type{
	public TypeVoid(){};
	public String toString(){
		return "void";
	}
	@Override
	public ConstData replaceLinearCombination(int index) {
		// TODO Auto-generated method stub
		return null;
	}

}
