package core;
import java.util.Collection;
import java.util.Collections;

public class TypeStructRef extends SketchType{
    private String name;
    private final boolean isUnboxed;
    public TypeStructRef(String name, boolean isUnboxed) {
        this.name = name;
        this.isUnboxed = isUnboxed;
    }
    public String getName()
    {
        return name;
    }
    public boolean isStruct () { return true; }
    
    public Collection<SketchType> getBaseTypes() {
        return Collections.singletonList((SketchType) this);
    }
}
