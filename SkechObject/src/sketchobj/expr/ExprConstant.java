package sketchobj.expr;

import sketchobj.core.Type;

abstract public class ExprConstant extends Expression
{
    // Go Java go!  If we don't have this, the compiler complains:
    public ExprConstant()
    {
    }

   

    public boolean isConstant () {
    	return true;
    }

    public abstract Type getType();
    public abstract int getVal();
    /**
     * Create a new constant-valued expression corresponding to a
     * String value.  val must be a valid real number, according to
     * java.lang.Double.valueOf(), excepting that it may end in "i" to
     * indicate an imaginary value.  This attempts to create an
     * integer if possible, and a real-valued expression if possible;
     * however, it may also create an ExprComplex with a zero (null)
     * real part.  Eexpressions like "3+4i" need to be parsed into
     * separate expressions.
     *
     * @param context  file and line number for the string
     * @param val      string containing the constant to create
     * @return         an expression corresponding to the string value
     */
//    public static Expression createConstant(FENode context, String val)
//    {
//        // Maybe it's integral.
//        try {
//            return new ExprConstInt(context, val);
//        }
//        catch(NumberFormatException e)
//        {
//            // No; create a float (and lose if this is wrong too).
//            return new ExprConstFloat(context, val);
//        }
//    }

    /**
     * Create a new constant-valued expression corresponding to a
     * String value.  val must be a valid real number, according to
     * java.lang.Double.valueOf(), excepting that it may end in "i" to
     * indicate an imaginary value.  This attempts to create an
     * integer if possible, and a real-valued expression if possible;
     * however, it may also create an ExprComplex with a zero (null)
     * real part.  Eexpressions like "3+4i" need to be parsed into
     * separate expressions.
     *
     * @param context  file and line number for the string
     * @param val      string containing the constant to create
     * @return         an expression corresponding to the string value
     * @deprecated
     */
//    public static Expression createConstant(FEContext context, String val)
//    {
//    	return createConstant (new DummyFENode (context), val);
//    }
}