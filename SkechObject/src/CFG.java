
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sketchobj.core.Function;
import sketchobj.stmts.*;

public class CFG {
	
    private Node enter;
    private int counter;
    private Map<Integer, List<Integer>> edges;
    private Map<Integer, Node> nodes;
	
    public CFG(Function function) {
    	this.edges = new HashMap<Integer, List<Integer>>();
    	this.nodes = new HashMap<Integer, Node>();
    	Connection con = buildStmt(function.getBody());
    	this.enter = con.getIn();
    }
    
    private void updateEdges(int key, int value) {
    	if (this.edges.containsKey(key)) {
    		this.edges.get(key).add(value);
    	} else {
    		ArrayList<Integer> list = new ArrayList<Integer>();
    		list.add(value);
    		this.edges.put(key, list);
    	}
    }
    
    
    private Connection buildStmt (Statement stmt) {
    	Node in = null;
    	Node out = null;
    	
    	if (stmt instanceof StmtAssert) {
    		in = new Node(this.counter, ((StmtAssert) stmt).toString());
    		this.nodes.put(this.counter, in);
    		this.counter ++;
    		return new Connection(in, in);
    	}
    	
    	if (stmt instanceof StmtAssign) {
    		in = new Node(this.counter, ((StmtAssign) stmt).toString());
    		this.nodes.put(this.counter, in);
    		this.counter ++;
    		return new Connection(in, in);
    	}
    	
        if (stmt instanceof StmtBlock) {
    		if (((StmtBlock) stmt).stmts.size() == 0) {
				System.err.println("empty stmtBlock body!");
				return new Connection(-1);
			}
    		ArrayList<Connection> list = new ArrayList<Connection>();
    		for (Statement s : ((StmtBlock) stmt).stmts) {
    			if (s != null) {
    				list.add(buildStmt(s));
    			}
    		}
    		if (list.size() == 0) {
				System.err.println("empty stmtBlock body!");
				return new Connection(-1);
			}
    		return combineList(list);
    	}
    	
        if (stmt instanceof StmtDoWhile) {
        	Connection con1 = buildStmt(((StmtDoWhile) stmt).getBody());
        	if (con1.getIn() != null) {
        		in = con1.getIn();

        		out = new Node(this.counter, ((StmtDoWhile) stmt).getCond().getCtx().toString());
        		this.nodes.put(this.counter, out);
        		this.counter ++;
        		Connection con2 = new Connection(out, out);
        		
        		ArrayList<Connection> list = new ArrayList<Connection>();
        		list.add(con1);
        		list.add(con2);
        		combineList(list);
        		this.updateEdges(out.getId(), in.getId());
        		return new Connection(in, out);
        	} else {
        		in = new Node(this.counter, ((StmtDoWhile) stmt).getCond().getCtx().toString());
        		this.nodes.put(this.counter, in);
        		this.counter ++;
        		this.updateEdges(in.getId(), in.getId());
        		return new Connection(in, in);
        	}
    	}
    	
        if (stmt instanceof StmtExpr) {
    		in = new Node(this.counter, ((StmtExpr) stmt).toString());
    		this.nodes.put(this.counter, in);
    		this.counter ++;
    		return new Connection(in, in);
    	}
        
        // assume init, cond, incr are non-empty, although body might be empty
        if (stmt instanceof StmtFor) {
    		ArrayList<Connection> list = new ArrayList<Connection>();
    		Connection InitCon = buildStmt(((StmtFor) stmt).getInit());
    		in = InitCon.getIn();
    		
    		Node condNode = new Node(this.counter, ((StmtFor) stmt).getCond().getCtx().toString());
    		this.nodes.put(this.counter, condNode);
    		this.counter ++;
    		out = condNode;
    		Connection condCon = new Connection(condNode, condNode);
    		
    		Connection bodyCon = buildStmt(((StmtFor) stmt).getBody());
    		Connection incrCon = buildStmt(((StmtFor) stmt).getIncr());
    		
    		list.add(InitCon);
    		list.add(condCon);
    		list.add(bodyCon);
    		list.add(incrCon);
    		combineList(list);
    		
    		ArrayList<Connection> loop = new ArrayList<Connection>();
    		loop.add(incrCon);
    		loop.add(condCon);
    		combineList(loop);
    		
    		return new Connection(in, out);
    	}

        // it does not matter for intra-procedure case
        if (stmt instanceof StmtFunDecl) {
    		return buildStmt(((StmtFunDecl) stmt).getDecl().getBody());
    	}
        
        if (stmt instanceof StmtIfThen) {
        	String condStr = "" + ((StmtIfThen) stmt).getCond() + "";
        	Node condNode = new Node(this.counter, condStr);
    		this.nodes.put(this.counter, condNode);
    		this.counter ++;
    		in = condNode;
    		Connection con1 = new Connection(in, in);
    		Connection con2 = buildStmt(((StmtIfThen) stmt).getCons());
    		Connection con3 = buildStmt(((StmtIfThen) stmt).getAlt());
    		
    		ArrayList<Connection> list1 = new ArrayList<Connection>();
    		list1.add(con1);
    		list1.add(con2);
    		List<Node> out1 = combineList(list1).getOut();
    		
    		ArrayList<Connection> list2 = new ArrayList<Connection>();
    		list2.add(con1);
    		list2.add(con3);
    		List<Node> out2 = combineList(list2).getOut();
    		
    		List<Node> outList = new ArrayList<>();
    		outList.addAll(out1);
    		outList.addAll(out2);
    		return new Connection(in, outList);
        }
        
        if (stmt instanceof StmtMinimize) {	
        	in = new Node(this.counter, ((StmtMinimize) stmt).toString());
    		this.nodes.put(this.counter, in);
    		this.counter ++;
    		return new Connection(in, in);
        }
        
        if (stmt instanceof StmtReturn) {	
        	in = new Node(this.counter, ((StmtReturn) stmt).toString());
    		this.nodes.put(this.counter, in);
    		this.counter ++;
    		return new Connection(in, in);
        }
        
        if (stmt instanceof StmtVarDecl) {	
        	in = new Node(this.counter, ((StmtVarDecl) stmt).toString());
    		this.nodes.put(this.counter, in);
    		this.counter ++;
    		return new Connection(in, in);
        }
        
        if (stmt instanceof StmtWhile) {
        	in = new Node(this.counter, ((StmtWhile) stmt).getCond().getCtx().toString());
        	this.nodes.put(this.counter, in);
    		this.counter ++;
    		Connection con1 = new Connection(in, in);
        	Connection con2 = buildStmt(((StmtWhile) stmt).getBody());
        	if (con2.getIn() != null) {
        		return con1;
        	} else {
        		ArrayList<Connection> list = new ArrayList<Connection>();
        		list.add(con1);
        		list.add(con2);
        		combineList(list);
        		ArrayList<Connection> loop = new ArrayList<Connection>();
        		loop.add(con2);
        		loop.add(con1);
        		combineList(loop);
        		return new Connection(in, in);
        	}
        	
        }
        
    	return null;
    }

	private Connection combineList(ArrayList<Connection> list) {
		int removed = 0;
    	for (int i = 0; i < list.size(); i++) {
    		Connection tmp = list.get(i - removed);
    		if (tmp.getIn() == null) {
    			list.remove(tmp);
    			removed++;
    		}
    	}
    	
    	int actualSize = list.size();
    	if (actualSize == 0) {
			System.err.println("empty CFG list!");
			return new Connection(-1);
		}
    	if (actualSize == 1) {
    		return list.get(0);
    	}
    	
    	Node in = list.get(0).getIn();
    	List<Node> out = list.get(actualSize - 1).getOut();
    	
    	for (int i = 0; i < actualSize - 1; i++) {
    		int inId = list.get(i + 1).getIn().getId();
    		List<Node> tmpOut = list.get(i).getOut();
    		for (int j = 0; j < tmpOut.size(); j++) {
    			this.updateEdges(tmpOut.get(j).getId(), inId);
    		}
    	}
    	
    	return new Connection(in, out);
	}
	
	public void printCFG() {
		String res = "";
		res += "\n entrance is Node " + Integer.toString(enter.getId()) + "\n";
		res += "size is " +  Integer.toString(counter) + "\n";
		res += "nodes: \n";
		for (Map.Entry<Integer, Node> entry : this.nodes.entrySet()) {
		    res += (entry.getValue().toStringNode() + "\n");
		}
		res += "edges: \n";
		for (Map.Entry<Integer, List<Integer>> entry : this.edges.entrySet()) {
		    res += (entry.getKey() + " : " + entry.getValue() + "\n");
		}
		
		System.out.println(res);
	}
    
}	


/*
public class CFG {
	
    private Node enter;
    private Node exit;
    private int counter;
    
    public CFG(Node enter, Node exit, int counter) {
		super();
		this.enter = enter;
		this.exit = exit;
		this.counter = counter;
	}

	public CFG (Function function) {
    	Statement body = function.getBody();
    	
    	this.counter = 1;
    	CFG res = buildStmt(body);
    	this.enter = res.getEnter();
    	this.exit = res.getExit();
    	
    	/*boolean enterSet = false;
    	boolean exitSet = false;
		if (body instanceof StmtBlock) {
			
			if (((StmtBlock) body).stmts.size() == 0) {
				System.err.println("empty function body!");
				return;
			}
			
			for (Statement s : ((StmtBlock) body).stmts) {
				if (!enterSet) {
					
				}
			}
		}
    }*/
    /*
    private CFG buildStmt (Statement stmt) {
    	Node enter1 = null;
    	Node exit1 = null;
    	if (stmt instanceof StmtAssert) {
    		enter1 = new Node(this.counter, ((StmtAssert) stmt).toString(), null, null);
    		this.counter ++;
    		exit1 = enter1;
    		return new CFG(enter1, exit1, -1);
    	}
    	if (stmt instanceof StmtAssign) {
    		enter1 = new Node(this.counter, ((StmtAssign) stmt).toString(), null, null);
    		this.counter ++;
    		exit1 = enter1;
    		return new CFG(enter1, exit1, -1);
    	}
    	if (stmt instanceof StmtBlock) {
    		
    		if (((StmtBlock) stmt).stmts.size() == 0) {
				System.err.println("empty stmtBlock body!");
				return new CFG(null, null, -1);
			}
    		
    		ArrayList<CFG> list = new ArrayList<CFG>();
    		for (Statement s : ((StmtBlock) stmt).stmts) {
    			list.add(buildStmt(s));
    		}
    		return combineList(list);
    	}
    	
    	if (stmt instanceof StmtDoWhile) {
    		enter1 = new Node(this.counter, ((StmtDoWhile) stmt).getCond().getCtx().toString(), null, null);
    		this.counter ++;
    		ArrayList<CFG> list = new ArrayList<CFG>();
    		CFG cfg1 = new CFG(enter1, enter1, -1);
    		CFG cfg2 = buildStmt(((StmtDoWhile) stmt).getBody());
    		list.add(cfg1);
    		list.add(cfg2);
    		return combineList(list);
    	}
    	
    	if (stmt instanceof StmtExpr) {
    		enter1 = new Node(this.counter, ((StmtExpr) stmt).toString(), null, null);
    		this.counter ++;
    		return new CFG(enter1, enter1, -1);
    	}
    	
    	if (stmt instanceof StmtFor) {
    		ArrayList<CFG> list = new ArrayList<CFG>();
    		CFG cfg1 = buildStmt(((StmtFor) stmt).getInit());
    		Node node2 = new Node(this.counter, ((StmtFor) stmt).getCond().getCtx().toString(), null, null);
    		CFG cfg2 = new CFG(node2, node2, -1);
    		CFG cfg3 = buildStmt(((StmtFor) stmt).getBody());
    		CFG cfg4 = buildStmt(((StmtFor) stmt).getIncr());
    		list.add(cfg1);
    		list.add(cfg2);
    		list.add(cfg3);
    		list.add(cfg4);
    		return combineList(list);
    	}
    	
    	if (stmt instanceof StmtFunDecl) {
    		return new CFG(((StmtFunDecl) stmt).getDecl());
    	}
    	
    	if (stmt instanceof StmtIfThen) {
    		
    	}
    	
    	return null;
    }
    
    private CFG combineList(ArrayList<CFG> list) {
    	int removed = 0;
    	for (int i = 0; i < list.size(); i++) {
    		CFG tmp = list.get(i - removed);
    		if (tmp.getEnter() == null) {
    			list.remove(tmp);
    			removed++;
    		}
    	}
    	
    	int actualSize = list.size();
    	if (actualSize == 0) {
			System.err.println("empty CFG list!");
			return new CFG(null, null, -1);
		}
    	Node enter1 = list.get(0).getEnter();
    	Node exit1 = list.get(actualSize - 1).getExit();
    	
    	if (actualSize == 1) {
    		return list.get(0);
    	}
    	
    	for (int i = 0; i < actualSize - 1; i++) {
    		list.get(i).getExit().setNext(list.get(i + 1).getEnter());
    	}
    	for (int i = 1; i < actualSize; i++) {
    		list.get(i).getEnter().setPrev(list.get(i - 1).getExit());
    	}
    	
    	return new CFG(enter1, exit1, -1);
    	
    }

	public Node getEnter() {
		return enter;
	}

	public void setEnter(Node enter) {
		this.enter = enter;
	}

	public Node getExit() {
		return exit;
	}

	public void setExit(Node exit) {
		this.exit = exit;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}
}
*/