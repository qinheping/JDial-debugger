package sketchobj.core;

import java.util.ArrayList;
import java.util.List;

import constraintfactory.ConstData;

public class ParametersList extends SketchObject{
	List<Parameter> list;
	public ParametersList(){
		list = new ArrayList<Parameter>();
	}
	
	public void add(Parameter p){
		list.add(p);
	}
	
	public List<Parameter> getList() {
		return list;
	}

	@Override
	public ConstData replaceLinearCombination(int index) {
		// TODO Auto-generated method stub
		return null;
	}

}
