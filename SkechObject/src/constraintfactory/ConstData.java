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
	private int oriline;

	@SuppressWarnings("unchecked")
	public ConstData(Type type, @SuppressWarnings("rawtypes") List children, int index, int value, String name, int line){
		this.setType(type);
		this.setChildren(children);
		this.setIndex(index);
		this.setValue(value);
		this.setName(name);
		this.oriline = line;
	}

	public ConstData(int index2,int line) {
		this(null,new ArrayList<SketchObject>(),index2,0,null,line);}

	public ConstData(int index2, String string, int line) {
		this(null,new ArrayList<SketchObject>(),index2,0,string,line);
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

	public int getOriline() {
		return oriline;
	}

	public void setOriline(int oriline) {
		this.oriline = oriline;
	}
}
