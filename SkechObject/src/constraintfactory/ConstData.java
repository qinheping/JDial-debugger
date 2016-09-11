package constraintfactory;

import java.util.ArrayList;
import java.util.List;

import sketchobj.core.SketchObject;
import sketchobj.core.Type;

public class ConstData {
	private Type type;
	private List<SketchObject> children;
	private int index;
	private int value;
	private String name;

	@SuppressWarnings("unchecked")
	public ConstData(Type type, @SuppressWarnings("rawtypes") List children, int index, int value, String name){
		this.setType(type);
		this.setChildren(children);
		this.setIndex(index);
		this.setValue(value);
		this.setName(name);
	}

	public ConstData(int index2) {
		this.setIndex(index2);
		this.setType(null);
		this.setValue(0);
		this.setChildren(new ArrayList<SketchObject>());
		this.setName(null);}

	public ConstData(int index2, String string) {
		this.setIndex(index2);
		this.setType(null);
		this.setValue(0);
		this.setChildren(new ArrayList<SketchObject>());
		this.setName(name);
	}

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
