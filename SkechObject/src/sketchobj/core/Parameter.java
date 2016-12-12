package sketchobj.core;

import constraintfactory.ConstData;

public class Parameter extends SketchObject{
	 // NOTE -- don't change these, or modify ScAstModel.gm in Skalch project
		public final static int IN = 0;
		public final static int OUT = 1;
		public final static int REF = 2;

	    private final Type type;
	    private final String name;
	    private final int partype;
	    private int srcTupleDepth = -1;
	    private final boolean isImplicit;



	    public Parameter( Type type, String name, int ptype, boolean isImplicit)
	    {    	
	        this.type = type;
	        this.name = name;
	        this.partype = ptype;
	        this.isImplicit = isImplicit;
	    }

	    /**
	     *
	     * Whether the parameter is an input parameter (IN), output parameter (OUT) or a reference parameter (REF).
	     *
	     * @return
	     */
	    public int getPtype(){
	    	return partype;
	    }

	    /**
	     * Whether this parameter is an output parameter.
	     * Reference parameters are implicitly output parameters.
	     * @return
	     */
	    public boolean isParameterOutput(){
	    	return partype == OUT || partype == REF;
	    }

	    public boolean isImplicit() {
	        return isImplicit;
	    }

	    /**
	     * Whether this parameter is an input parameter.
	     * The reference parameters are implicitly input parameters.
	     * @return
	     */
	    public boolean isParameterInput(){
	    	return partype == IN || partype == REF;
	    }

	    /** Is this parameter a reference parameter? */
	    public boolean isParameterReference () {
	    	return partype == REF;
	    }

	    /** Returns the type of this. */
	    public Type getType()
	    {
	        return type;
	    }

	    /** Returns the name of this. */
	    public String getName()
	    {
	        return name;
	    }

	    public int getSrcTupleDepth() {
	        return srcTupleDepth;
	    }

	    public String toString() {
	        return (partype == OUT ? "!" : (partype == REF ? "@" : "")) + type.toString() +
	                " " + name;
	    }

	    public int compareTo(Parameter p) {
	        return name.compareTo(p.name);
	    }

		@Override
		public ConstData replaceLinearCombination(int index) {
			// TODO Auto-generated method stub
			return null;
		}
}
