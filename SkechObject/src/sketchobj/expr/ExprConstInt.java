package sketchobj.expr;

import java.util.List;

import constraintfactory.ConstData;
import sketchobj.core.Type;
import sketchobj.core.TypePrimitive;

public class ExprConstInt extends ExprConstant
{
    private final int val;

    public static final ExprConstInt zero = new ExprConstInt(0);
    public static final ExprConstInt one = new ExprConstInt(1);
    public static final ExprConstInt minusone = new ExprConstInt(-1);
    
    public static ExprConstInt createConstant(int i){
        if(i == 0){ return zero; }
        if(i == -1){ return minusone; }
        if(i == 1){ return one; }
        return new ExprConstInt( i);
    }

    /** Create a new ExprConstInt with a specified value. */
    public ExprConstInt( int val)
    {
        this.val = val;
    }


    /** Parse a string as an integer, and create a new ExprConstInt
     * from the result. */
    public ExprConstInt( String str)
    {
        this( Integer.parseInt(str));
    }

    /** Returns the value of this. */
    public int getVal() { return val; }

    public Integer getIValue(){
    	return new Integer(val);
    }
//    /** Accept a front-end visitor. */
//    public Object accept(FEVisitor v)
//    {
//        return v.visitExprConstInt(this);
//    }

    public boolean equals(Object other)
    {
        if (!(other instanceof ExprConstInt))
            return false;
        return val == ((ExprConstInt)other).getVal();
    }

    public int hashCode()
    {
        return new Integer(val).hashCode();
    }

    public String toString()
    {
        return Integer.toString(val);
    }

	@Override
	public ConstData replaceConst(int index) {
		return null;
	}

	@Override
	public Type getType() {
		return new TypePrimitive(4);
	}

	@Override
	public ConstData replaceConst(int index, String string) {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return externalFuncNames;
	}
}