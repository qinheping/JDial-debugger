package sketchobj.expr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import constraintfactory.ConstData;
import constraintfactory.ExternalFunction;
import sketchobj.core.SketchObject;
import sketchobj.core.Type;

/**
 * An array-range reference. A[0:2] means the first 3 elements of A, and A[4::2] means
 * elements 4 and 5 of A. See Sketch language manual for more information.
 * 
 * @author liviu
 */
public class ExprArrayRange extends Expression
{

	private int line;
    /**
     * Represents the indices in {@link ExprArrayRange}. Includes the start index and the
     * length of the desired sub-array.
     */
	public static class RangeLen
	{
		private final Expression start;		
		private final Expression lenExpr;		
		public RangeLen(Expression start)
		{
			this(start, null);
		}
		public RangeLen(Expression start, int len)
		{
			this.start=start;			
			this.lenExpr= ExprConstInt.createConstant(len);
		}
		public RangeLen(Expression start, Expression len)
		{
			this.start=start;			
			this.lenExpr=len;			
		}
		public Expression start() {return start;}		
		public Expression getLenExpression() {
			return lenExpr;
		}
		public boolean hasLen() {return lenExpr!=null;}
		public String toString()
		{			
			if(lenExpr != null) return start+"::"+lenExpr; 
			return start.toString();
		}
	}


	private Expression base;
	private RangeLen index;
	 private boolean unchecked=false;
	/**
	 * @param unchecked The unchecked to set.
	 */
	public void setUnchecked(boolean unchecked) {
		this.unchecked = unchecked;
	}

	/**
	 * @return Returns the unchecked.
	 */
	public boolean isUnchecked() {
		return unchecked;
	}


    public ExprArrayRange( Expression base, List<RangeLen> rl,int i)
	{
		this( base, rl, false,i);
	}
    
    public ExprArrayRange( String s, int i, int line)
	{
		this( new ExprVar(s), new RangeLen(new ExprConstInt(i),null), false, line);
	}
    
    public ExprArrayRange( String s, String i, int line)
	{
		this( new ExprVar(s), new RangeLen(new ExprVar(i),null), false, line);
	}
    /**
     * NOTE -- vector of array ranges for comma arrays. Since arr[x, y] = (arr[x])[y], we
     * want to set (arr[x]) as the new base, and y as the index.
     */
    public ExprArrayRange( Expression base, List<RangeLen> rl,
            boolean unchecked, int line)
    {
        if (rl.size() == 1) {
            this.base = base;
        } else {
            this.base = new ExprArrayRange( base, rl.subList(0, rl.size() - 1), line);
        }

        // is there a mistake here
        this.index = rl.get(rl.size() - 1);
        this.line = line;
        setUnchecked(unchecked);
	}

	
	public ExprArrayRange( Expression base, Expression offset, boolean unchecked, int line)
	{
        this( base, Collections.singletonList(new RangeLen(offset)), unchecked, line);
	}

    public ExprArrayRange( Expression nbase, RangeLen rangeLen,
            boolean unchecked2, int line)
    {
        this( nbase, Collections.singletonList(rangeLen), unchecked2, line);
    }

    public ExprArrayRange( Expression base2, RangeLen flatRl, int line) {
        this(base2, Collections.singletonList(flatRl), line);
    }

    public Expression getOffset() {
		RangeLen rl = index;
		assert !rl.hasLen();
		return rl.start;
	}

	public RangeLen getSelection(){
	    return index;
	}

	

	public String toString()
	{
		StringBuffer ret=new StringBuffer();
		ret.append(base);
		ret.append('[');
		ret.append(index);		
		ret.append(']');
		return ret.toString();
	}

	public List<RangeLen> getArraySelections () {
		List<RangeLen> sels = new ArrayList<RangeLen> ();
		
		Expression base = getBase ();
		if (base instanceof ExprArrayRange) {
			sels.addAll (((ExprArrayRange) base).getArraySelections ());
		}		

		sels.add (index);

		return sels;
	}

	public List<Expression> getArrayIndices() {
        List<Expression> indices = new ArrayList<Expression>();
        Expression base= getBase();
        if(base instanceof ExprArrayRange) {
        	indices.addAll(((ExprArrayRange) base).getArrayIndices());
        }
        RangeLen rl=index;
        assert !rl.hasLen(): "In stencil mode, array ranges (a[1::2]) are not allowed";
        indices.add(rl.start());
        return indices;
    }

  /*  public ExprVar getAbsoluteBase() {
        return (new GetAssignLHS()).visitExprArrayRange(this);
    }*/

	/**
	 * @return the bottom-level object being indexed; e.g:
	 *   "x.f[2][2]".getAbsoluteBaseExpr () --> "x.f"
	 */
	public Expression getAbsoluteBaseExpr () {
		return (getBase () instanceof ExprArrayRange) ?
					((ExprArrayRange)getBase ()).getAbsoluteBaseExpr ()
					: getBase ();
	}

	public Expression getBase() {
		return base;
	}

	public Expression getSingleIndex() {		
		RangeLen r=index;
		if(r.hasLen()) return null;
		return r.start;
	}

	public boolean hasSingleIndex() {
		return getSingleIndex()!=null;
	}

    public boolean equals(Object other) {
        if (!(other instanceof ExprArrayRange))
            return false;
        return this.toString().equals(other.toString());
    }

    public Expression getBaseAndIndices(List<RangeLen> indices) {
        Expression base = this.base;
        indices.add(this.index);
        while (base instanceof ExprArrayRange) {
            ExprArrayRange e = (ExprArrayRange) base;
            indices.add(e.index);
            base = e.base;
        }

        return base;
    }

	@Override
	public ConstData replaceConst(int index,String name) {
		List<SketchObject> toAdd = new ArrayList<SketchObject>();
		Expression cond = this.index.start;
		if (cond instanceof ExprConstant) {
			int value = ((ExprConstant) cond).getVal();
			Type t = ((ExprConstant) cond).getType();
			cond = new ExprFunCall("Const" + index, new ArrayList<Expression>());
			return new ConstData(t, toAdd, index + 1, value,name,this.line);
		}
		return new ConstData(null, toAdd, index, 0,name,this.line);
	}

	@Override
	public ConstData replaceConst(int index) {
		// TODO Auto-generated method stub
		return this.replaceConst(index, "");
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
	public List<ExternalFunction> extractExternalFuncs(List<ExternalFunction> externalFuncNames) {
		// TODO Auto-generated method stub
		return externalFuncNames;
	}
}