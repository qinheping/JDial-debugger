package core;
import java.util.List;

public class TypeArray extends SketchType {
    private final SketchType base;
    private final SketchExpr length;
    //private final List<SketchExpr> dims;
	public TypeArray(SketchType base, SketchExpr length){
		this.base = base;
		this.length = length;
	}

    public String toString()
    {
        String s = "";
        if (length != null) {
            s = length.toString();
        }
        return this.getBase() + "[" + s + "]";
    }

	private SketchType getBase() {
		return base;
	}
}