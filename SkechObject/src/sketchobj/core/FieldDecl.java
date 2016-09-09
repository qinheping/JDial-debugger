package sketchobj.core;
import java.util.Collections;
import java.util.List;

import sketchobj.expr.Expression;

public class FieldDecl {
	private List<Type> types;
	private List<String> names;
	private List<Expression> inits;

	public FieldDecl( List<Type> types, List<String> names, List<Expression> inits) {
		this.types = new java.util.ArrayList<Type>(types);
		this.names = new java.util.ArrayList<String>(names);
		this.inits = new java.util.ArrayList<Expression>(inits);
	}
    public Type getType(int n)
    {
        return types.get(n);
    }
    public List<Type> getTypes()
    {
        return Collections.unmodifiableList(types);
    }
    public String getName(int n)
    {
        return (String)names.get(n);
    }
    /**
     * Get an immutable list of the names of all of the fields
     * declared by this.
     *
     * @return  Unmodifiable list of <code>String</code> of the
     *          names of the fields in this
     */
    public List<String> getNames()
    {
        return Collections.unmodifiableList(names);
    }

    /**
     * Get the initializer of the nth field declared by this.
     *
     * @param  n  Number of field to retrieve (zero-indexed)
     * @return    Expression initializing the nth field, or
     *            <code>null</code> if the field is
     *            uninitialized
     */
    public Expression getInit(int n)
    {
        return (Expression)inits.get(n);
    }

    /**
     * Get an immutable list of the initializers of all of the field
     * declared by this.  Members of the list may be <code>null</code>
     * if a particular field is uninitialized.
     *
     * @return  Unmodifiable list of <code>Expression</code> (or
     *          <code>null</code>) of the initializers of the
     *          fields in this
     */
    public List<Expression> getInits()
    {
        return Collections.unmodifiableList(inits);
    }

    /**
     * Get the number of fields declared by this.  This value should
     * always be at least 1.
     *
     * @return  Number of fields declared
     */
    public int getNumFields()
    {
        // CLAIM: the three lists have the same length.
        return types.size();
    }
    
    public String toString()
    {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < types.size(); i++)
        {
            if (i != 0)
                result.append("; ");
            result.append(types.get(i) + " " + names.get(i));
            if (inits.get(i) != null)
                result.append("=" + inits.get(i));
        }
        return result.toString();
    }
}
