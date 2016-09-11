package sketchobj.expr;

import constraintfactory.ConstData;
import sketchobj.core.Type;

public class ExprField extends Expression
{
    private Expression left;
    private String name;
    private boolean hole;
    private Type typeOfHole = null;
    private boolean isLValue = true;

    /** Creates a new field-reference expression, referencing the
     * named field of the specified expression. */
    public ExprField( Expression left, String name, boolean hole)
    {
        this.left = left;
        this.name = name;
        this.hole = hole;
    }

    public ExprField( Expression left, String name) {
        this.left = left;
        this.name = name;
        this.hole = false;
    }





    public boolean isHole() {
        return hole;
    }

    public Type getTypeOfHole() {
        return typeOfHole;
    }

    public void setTypeOfHole(Type t) {
        typeOfHole = t;
    }
    /** Returns the expression we're taking a field from. */
    public Expression getLeft() { return left; }

    /** Returns the name of the field. */
    public String getName() { return name; }

    /**
     * Determine if this expression can be assigned to. Fields can always be assigned to.
     * Not if the struct is immutable
     * 
     * @return always true
     */
    public boolean isLValue()
    {
        return isLValue;
    }

    public void setIsLValue(boolean val) {
        isLValue = val;
    }

    public String toString()
    {
        return left + "." + name;
    }

    public boolean equals(Object other)
    {
        if (!(other instanceof ExprField))
            return false;
        ExprField that = (ExprField)other;
        if (!(this.left.equals(that.left)))
            return false;
        if (!(this.name.equals(that.name)))
            return false;
        return true;
    }

    public int hashCode()
    {
        return left.hashCode() ^ name.hashCode();
    }

	@Override
	public ConstData replaceConst(int index) {
		// TODO Auto-generated method stub
		return new ConstData(index);
	}

	@Override
	public ConstData replaceConst(int index, String string) {
		// TODO Auto-generated method stub
		return new ConstData(index,string);
	}
}