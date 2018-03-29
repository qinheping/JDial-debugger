
public class Node {
	
	private int id;
    private String code;
    
    public Node(int id, String code) {
		super();
		this.id = id;
		this.code = code;
	}

	public String toStringNode () {
    	return Integer.toString(id) + ": " + this.code;
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
    
}
