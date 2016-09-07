package sketchobj.stmts;

import sketchobj.expr.Expression;

public class StmtIfThen extends Statement
{
    private Expression cond;
    private Statement cons, alt;
    private boolean isSingleFunCall = false;
    private boolean isSingleVarAssign = false;
    /** Create a new conditional statement, with the specified
     * condition, consequent, and alternative.  The two statements
     * may be null if omitted. */
    public StmtIfThen(Expression cond,
                      Statement cons, Statement alt)
    {
        this.cond = cond;
        this.cons = cons;
        this.alt = alt;
    }

 

//    @Override
//    public int size() {
//        int sz_cons = cons == null ? 0 : cons.size();
//        int sz_alt = alt == null ? 0 : alt.size();
//        return sz_cons + sz_alt;
//    }

    /** Returns the condition of this. */
    public Expression getCond()
    {
        return cond;
    }

    /** Returns the consequent statement of this, which is executed if
     * the condition is true. */
    public Statement getCons()
    {
        return cons;
    }

    /** Return the alternative statement of this, which is executed if
     * the condition is false. */
    public Statement getAlt()
    {
        return alt;
    }


    public boolean isSingleFunCall() {
        return isSingleFunCall;
    }

    public void singleFunCall() {
        isSingleFunCall = true;
    }

    public boolean isSingleVarAssign() {
        return isSingleVarAssign;
    }

    public void singleVarAssign() {
        isSingleVarAssign = true;
    }
    public String toString(){
    	String result = "if(" + this.cond + "){\n";
    	result += this.cons;
    	result += "}";
    	if(this.alt != null){
    	result += "else{\n";
    	result += this.alt + "}\n";
    	}else{
    		result += "\n";
    	}
    	return result;
    }



	@Override
	public int replaceConst(int index) {
		index = cons.replaceConst(index);
		index = alt.replaceConst(index);
		return index;
	}

}