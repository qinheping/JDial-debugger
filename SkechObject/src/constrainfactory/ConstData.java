package constrainfactory;

import java.util.ArrayList;
import java.util.List;

import sketchobj.core.SketchObject;
import sketchobj.core.Type;

public class ConstData {
	private Type type;
	private List<SketchObject> children;
	private int index;
	private int value;
	
	@SuppressWarnings("unchecked")
	public ConstData(Type type, @SuppressWarnings("rawtypes") List children, int index, int value){
		this.setType(type);
		this.setChildren(children);
		this.setIndex(index);
		this.setValue(value);
	}

	public ConstData(int index2) {
		this.setIndex(index2);
		this.setType(null);
		this.setValue(0);
		this.setChildren(new ArrayList<SketchObject>());}

	public List<SketchObject> getChildren() {
		return children;
	}

	public void setChildren(List<SketchObject> children) {
		this.children = children;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
