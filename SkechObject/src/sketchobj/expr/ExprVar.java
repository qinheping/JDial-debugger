package sketchobj.expr;

import java.util.List;

import constraintfactory.ConstData;

public class ExprVar extends Expression
{
    private String name;

	private int line;

    /** Create a new ExprVar for a particular named variable. */
    public ExprVar( String name)
    {
        this.name = name;
    }

    /** Return the name of the variable referenced. */
    public String getName() { return name; }

//    /** Accept a front-end visitor. */
//    public Object accept(FEVisitor v)
//    {
//        return v.visitExprVar(this);
//    }

    /**
     * Determine if this expression can be assigned to.  Variables can
     * generally be assigned to, particularly if they are local
     * variables.  Determining whether a variable is a (constant)
     * stream parameter is beyond the intended use of this function.
     *
     * @return always true
     */
    public boolean isLValue()
    {
        return true;
    }

    public String toString()
    {
        return name;
    }

    public int hashCode()
    {
        return name.hashCode();
    }

    public boolean equals(Object o)
    {
        if (!(o instanceof ExprVar))
            return false;
        return name.equals(((ExprVar)o).name);
    }

	@Override
	public ConstData replaceConst(int index) {
		return new ConstData(index,this.line);
	}

	@Override
	public ConstData replaceConst(int index, String string) {
		return new ConstData(index,string,this.line);
	}

	@Override
	public boolean equals(Expression other) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void replaceLinearCombination() {
		// TODO Auto-generated method stub
	}

	@Override
	public List<String> extractExternalFuncs(List<String> externalFuncNames) {
		return externalFuncNames;
	}
}