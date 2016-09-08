package sketchobj.expr;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import constrainfactory.ConstData;

public class ExprFunCall extends Expression
{
    private final String name;
    private static int NEXT_UID=0;

    private int clusterId; // Used to identify the cluster to combine funCalls.
    private int callid;
    private final List<Expression> params;

    public void resetCallid(){
    	this.callid = NEXT_UID++;
    }

    public int getCallid(){
    	return callid;
    }
    
    /** Creates a new function call with the specified name and
     * parameter list. */
    public ExprFunCall(String name, List<Expression> params)
    {
        this.name = name;
        this.params = Collections.unmodifiableList(params);}


    /** Creates a new function call with the specified name and
     * specified single parameter. */
    public ExprFunCall( String name, Expression param)
    {
    	this ( name, Collections.singletonList (param));
    }

    /**
     * Creates a new function call with the specified name and two specified parameters.
     */
    public ExprFunCall( String name, Expression... params) {
        this(name, Arrays.asList(params));
    }



    /** Returns the name of the function being called. */
    public String getName()
    {
        return name;
    }

    /** Returns the parameters of the function call, as an unmodifiable
     * list. */
    public List<Expression> getParams()
    {
        return params;
    }

    public String printParams(){
        String s = "";
        boolean notf = false;
        for(Expression p : params){
            if(notf){ s += ", "; }
            s += p.toString();
            notf = true;
        }
        return s;
    }

    public void setClusterId(int i) {
        this.clusterId = i;
    }

    public int getClusterId() {
        return this.clusterId;
    }
    
    public String toString()
    {
        return name + "(" + printParams() + ")";
    }

	@Override
	public ConstData replaceConst(int index) {
		// TODO Auto-generated method stub
		return new ConstData(index);
	}
}