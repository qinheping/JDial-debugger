package jsonast;

import java.util.List;

public class Trace extends JsonNode {

	private String stdout;
	private String event;
	private Integer line;
	private RenderStack rstack;
	private String funcname;
	private VarList heap;
	
	///
	private List<String> ordered_globals;
	private VarList globals;
	

	private List<String> ordered_locals;
	private VarList locals;
	///

	public Trace(String stdout, String event, Integer line, RenderStack rstack, VarList globals, VarList oglobals,
			String funcname, VarList heap) {
		this.stdout = stdout;
		this.event = event;
		this.line = line;
		this.setRstack(rstack);
		this.setFuncname(funcname);
		this.setHeap(heap);
		
		Frame currentF = this.rstack.getFrams().get(0);
		this.setOrdered_locals(currentF.getOrdered_locals());
		this.setLocals(currentF.getOrdered_varnames());
		
	}

	public String getStdout() {
		return stdout;
	}

	public void setStdout(String stdout) {
		this.stdout = stdout;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public Integer getLine() {
		return line;
	}

	public void setLine(Integer line) {
		this.line = line;
	}

	public RenderStack getRstack() {
		return rstack;
	}

	public void setRstack(RenderStack rstack) {
		this.rstack = rstack;
	}

	public String getFuncname() {
		return funcname;
	}

	public void setFuncname(String funcname) {
		this.funcname = funcname;
	}

	public VarList getHeap() {
		return heap;
	}

	public void setHeap(VarList heap) {
		this.heap = heap;
	}


	public List<String> getOrdered_locals() {
		return ordered_locals;
	}

	public void setOrdered_locals(List<String> ordered_locals) {
		this.ordered_locals = ordered_locals;
	}

	public VarList getLocals() {
		return locals;
	}

	public void setLocals(VarList locals) {
		this.locals = locals;
	}

}
