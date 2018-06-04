import sketchobj.expr.Expression;
import sketchobj.stmts.Statement;

public class Node {
	
	private int id;
    private String code;
    private Statement stmt;
    private Expression expr;
    private int type;
    
    public Node(int id, String code, Statement stmt, Expression expr) {
		super();
		this.id = id;
		this.code = code;
		this.stmt = stmt;
		this.expr = expr;
		if (stmt != null) {
			this.type = 1;
		} else if (expr != null) {
			this.type = 2;
		} else {
			this.type = -1;
		}
	}

	public String toStringNode() {
    	return Integer.toString(id) + ": " + this.code;
    }
    
	public boolean isStmt() {
		return this.type == 1;
	}
	
	public boolean isExpr() {
		return this.type == 2;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public Statement getStmt() {
		return stmt;
	}

	public void setStmt(Statement stmt) {
		this.stmt = stmt;
	}

	public Expression getExpr() {
		return expr;
	}

	public void setExpr(Expression expr) {
		this.expr = expr;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
    
}
