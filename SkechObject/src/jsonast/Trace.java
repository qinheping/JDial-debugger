package jsonast;

public class Trace extends JsonNode {

	private String stdout;
	private String event;
	private Integer line;
	private RenderStack rstack;
	private String funcname;
	private VarList heap;

	public Trace(String stdout, String event, Integer line, RenderStack rstack, VarList globals, VarList oglobals,
			String funcname, VarList heap) {
		this.stdout = stdout;
		this.event = event;
		this.line = line;
		this.setRstack(rstack);
		this.setFuncname(funcname);
		this.setHeap(heap);
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

}
