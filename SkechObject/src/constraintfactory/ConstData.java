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
	public boolean isCoeff;
	private int oriline;
	private List<Integer> liveVarsIndexSet;
	private List<String> liveVarsNameSet;
	private Integer primaryCoeffIndex;
	private boolean ifLC;
	
	@SuppressWarnings("unchecked")
	public ConstData(Type type, @SuppressWarnings("rawtypes") List children, int index, int value, String name, int line, boolean isc){
		this.setType(type);
		this.setChildren(children);
		this.setIndex(index);
		this.setValue(value);
		this.setName(name);
		this.oriline = line;
		this.isCoeff = isc;
	}
	public ConstData(Type type, @SuppressWarnings("rawtypes") List children, int index, int value, String name, int line){
		this(type,children,index,value,name,line,false);
	}
	public ConstData(int index2,int line) {
		this(null,new ArrayList<SketchObject>(),index2,0,null,line,false);}

	public ConstData(int index2, String string, int line) {
		this(null,new ArrayList<SketchObject>(),index2,0,string,line,false);
	}

	public ConstData(Type t, List<SketchObject> toAdd, int index2, int i, String name, int lineNumber,
			List<Integer> liveVarsIndexSet2, List<String> liveVarsNameSet2, Integer primaryCoeffIndex, boolean ifLC) {
		this.setType(t);
		this.setChildren(toAdd);
		this.setIndex(index2);
		this.setValue(i);
		this.setName(name);
		this.oriline=lineNumber;
		this.isCoeff = true;
		this.liveVarsIndexSet = liveVarsIndexSet2;
		this.liveVarsNameSet = liveVarsNameSet2;
		this.primaryCoeffIndex = primaryCoeffIndex;
		this.ifLC = ifLC;
	}
	public ConstData(Type t, List<SketchObject> toAdd, int i, int j, String name, int k,
			List<Integer> liveVarsIndexSet2, List<String> liveVarsNameSet2, Integer primaryIndex) {
		this(t, toAdd, i, j, name, k, liveVarsIndexSet2, liveVarsNameSet2, primaryIndex, false);
		
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
	public List<Integer> getLiveVarsIndexSet() {
		return liveVarsIndexSet;
	}
	public void setLiveVarsIndexSet(List<Integer> liveVarsIndexSet) {
		this.liveVarsIndexSet = liveVarsIndexSet;
	}

	public void setLiveVarsNameSet(List<String> liveVarsNameSet) {
		this.liveVarsNameSet = liveVarsNameSet;
	}
	public Integer getPrimaryCoeffIndex() {
		return primaryCoeffIndex;
	}
	public void setPrimaryCoeffIndex(Integer primaryCoeffIndex) {
		this.primaryCoeffIndex = primaryCoeffIndex;
	}
	public boolean isIfLC() {
		return ifLC;
	}
	public void setIfLC(boolean ifLC) {
		this.ifLC = ifLC;
	}
}
