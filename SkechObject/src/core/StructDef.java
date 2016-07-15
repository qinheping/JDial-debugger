package core;
import java.util.*;
import java.util.Map.Entry;

public class StructDef implements Iterable<Entry<String, SketchType>>{
	private final String name;
    private final List<String> fieldOrder;
    private final Map<String, SketchType> fieldTypMap;
    
    public StructDef(String name){
    	this(name, new ArrayList<String>(), new HashMap<String, SketchType>());
    }
    
    public StructDef(String name, List<String> fieldOrder, Map<String, SketchType> fieldTypMap){
    	this.name = name;
    	this.fieldOrder = fieldOrder;
    	this.fieldTypMap = fieldTypMap;
    }
    
	@Override
	public Iterator<Entry<String, SketchType>> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}
