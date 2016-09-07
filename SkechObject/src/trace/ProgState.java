package trace;

import java.util.List;
import java.util.Map;

public class ProgState {
	private int line;
	private List<String> ordered_globals;
	private Map<String,Double> globals;
	
	public ProgState(int line, List<String> og, Map<String, Double> g){
		this.setLine(line);
		this.setOrdered_globals(og);
		this.setGlobals(g);
	}

	public int getLine() {
		return line;
	}

	public void setLine(int line) {
		this.line = line;
	}

	public List<String> getOrdered_globals() {
		return ordered_globals;
	}

	public void setOrdered_globals(List<String> ordered_globals) {
		this.ordered_globals = ordered_globals;
	}

	public Map<String,Double> getGlobals() {
		return globals;
	}

	public void setGlobals(Map<String,Double> globals) {
		this.globals = globals;
	}
}
