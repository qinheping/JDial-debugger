package cfg;

import java.util.ArrayList;
import java.util.List;

public class Connection {
	
    private Node in;
    private List<Node> out;
    
	public Connection(Node in, List<Node> out) {
		super();
		this.in = in;
		this.out = out;
	}
	
	public Connection(Node in, Node out) {
		this.in = in;
		this.out = new ArrayList<Node>();
		this.out.add(out);
	}
	
	// for dummy connection only
	public Connection(int flag) {
		this.in = null;
		this.out = null;
	}
	
	public Node getIn() {
		return in;
	}
	public void setIn(Node in) {
		this.in = in;
	}
	public List<Node> getOut() {
		return out;
	}
	public void setOut(List<Node> out) {
		this.out = out;
	}
    
}
