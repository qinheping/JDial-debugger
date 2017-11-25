package sketchobj.core;
import java.util.*;
import java.util.Map.Entry;

public class StructDef implements Iterable<Entry<String, Type>>{
	private final String name;
    private final List<String> fieldOrder;
    private final Map<String, Type> fieldTypMap;
    
    public StructDef(String name){
    	this(name, new ArrayList<String>(), new HashMap<String, Type>());
    }
    
    public StructDef(String name, List<String> fieldOrder, Map<String, Type> fieldTypMap){
    	this.name = name;
    	this.fieldOrder = fieldOrder;
    	this.fieldTypMap = fieldTypMap;
    }
    
	@Override
	public Iterator<Entry<String, Type>> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getName() {
		return name;
	}

	public List<String> getFieldOrder() {
		return fieldOrder;
	}

	public Map<String, Type> getFieldTypMap() {
		return fieldTypMap;
	}
}
