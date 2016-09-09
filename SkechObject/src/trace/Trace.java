package trace;

import java.util.List;

public class Trace {
	private int length;
	private List<ProgState> traces;
	
	public Trace(int length, List<ProgState> traces){
		this.setLength(length);
		this.setTraces(traces);
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public List<ProgState> getTraces() {
		return traces;
	}

	public void setTraces(List<ProgState> traces) {
		this.traces = traces;
	}
}
