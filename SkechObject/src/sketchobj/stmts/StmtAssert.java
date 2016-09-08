package sketchobj.stmts;

import java.util.Random;

import constrainfactory.ConstData;
import sketchobj.expr.Expression;

public class StmtAssert extends Statement {
	  Expression cond;
	    @SuppressWarnings("unused")
		private String msg = null;
	    public static final int NORMAL = 0;
	    public static final int SUPER = 1;
	    public static final int UBER = 2;
	    public boolean isHard = false;
	    private int superA = NORMAL;

	    // isMax = 1: normal assertMax
	    // isMax = 2: assertMax, but doesn't create a new group of agmax
	    private int isMax;
	 
	    
	    public int isSuper(){
	        return superA;
	    }
	    
	    public int getAssertMax() {
	        return isMax;
	    }
	    
	    public String getAssertSymbol() {
	        if (isHard)
	            return "hassert";
	        switch (isMax) {
	            case 1:
	                return "assert_max";
	            case 2:
	                return "assert_max\\";
	            default:
	                return "assert";
	        }
	    }





	    /** Creates a new assert statement with the specified conditional. */
	    public StmtAssert( Expression cond, int isSuper)
	    {
	        this ( cond, null, isSuper);
	    }
	    
	    public StmtAssert( Expression cond, int isSuper, boolean isHard) {
	        this( cond, null, isSuper);
	        this.isHard = isHard;
	    }

	    public StmtAssert( Expression cond, String msg, int isSuper)
	    {
	        this.cond = cond;
	        this.msg = msg;
	        this.superA = isSuper;
	    }
	    
	    public StmtAssert(Expression cond, String msg, int isSuper,
	            boolean isHard)
	    {
	        this.cond = cond;
	        this.msg = msg;
	        this.superA = isSuper;
	        this.isHard = isHard;
	    }

	    public StmtAssert( Expression cond, String msg, boolean isSuper) {
	        this( cond, msg, (isSuper ? 1 : 0), 0);
	    }


	    public static StmtAssert createAssertMax( Expression cond,
	            String msg, boolean defer)
	    {
	        return new StmtAssert( cond, msg, 0, (defer ? 2 : 1));
	    }

	    public static StmtAssert createAssertMax( Expression cond,
	            String msg, boolean defer, boolean isHard)
	    {
	        return new StmtAssert( cond, msg, 0, (defer ? 2 : 1), isHard);
	    }

	    /**
	     *
	     */
	    public StmtAssert( Expression cond, String msg, int isSuper,
	            int isMax)
	    {
	        this.cond = cond;
	        this.msg = msg;
	        this.superA = isSuper;
	        this.isMax = isMax;
	    }
	    
	    public StmtAssert( Expression cond, String msg, int isSuper,
	            int isMax, boolean isHard)
	    {
	        this.cond = cond;
	        this.msg = msg;
	        this.superA = isSuper;
	        this.isMax = isMax;
	        this.isHard = isHard;
	    }

	    public StmtAssert( Expression cond, String msg, boolean isSuper,
	            boolean isHard)
	    {
	        this.cond = cond;
	        this.msg = msg;
	        this.superA = isSuper ? 1 : 0;
	        this.isHard = isHard;
	    }

	    /** Returns the assertion condition. */
	    public Expression getCond()
	    {
	        return cond;
	    }


	    /** Output to string. */
	    public String toString () {
	        String result = getAssertSymbol() + " (" + this.cond + ")";

	        /*
	         * XXX/cgjones: this is being cut out because asserts need to be
	         * printed in the Promela code generator, but Promela doesn't support
	         * the 'assert cond : message' syntax.  This can be added back in if
	         * we revise the way the code generators work (all printing done within
	         * the visitors).
	         *
	        if(msg != null){
	            result += ": \"" + msg + "\"";
	        }
	        */


	        return result;
	    }

	    /**
	     * @param msg the msg to set
	     */
	    public void setMsg(String msg) {
	        this.msg = msg;
	    }

	    @SuppressWarnings("unused")
		private Random _my_rand = new Random();
	    /**
	     * @return the msg
	     */
//	    public String getMsg() {
//	        if (msg == null || msg.isEmpty())
//	            return "Assert at " + getCx() + " (" + _my_rand.nextLong() + ")";
//	        return msg;
//	    }


		@Override
		public ConstData replaceConst(int index) {
			// TODO Auto-generated method stub
			return null;
		}
}
