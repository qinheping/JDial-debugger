package trace;

import java.util.List;

public class Trace {
	private int length;
	private List<ProgState> traces;
	
	public Trace(int length, List traces){
		this.length = length;
		this.traces = traces;
	}
}
