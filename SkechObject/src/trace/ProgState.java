package trace;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProgState {
	private Integer line;
	private List<String> ordered_globals;
	private Map<String,Integer> globals;
	
	public ProgState(Integer line, List<String> og, Map<String, Integer> g){
		this.setLine(line);
		this.setOrdered_globals(og);
		this.setGlobals(g);
	}
	public ProgState(Integer line,Map<String, Integer> g){
		this.setLine(line);
		this.setOrdered_globals(new ArrayList<String>(g.keySet()));
		this.setGlobals(g);
	}
	public Integer getLine() {
		return line;
	}

	public void setLine(Integer line) {
		this.line = line;
	}

	public List<String> getOrdered_globals() {
		return ordered_globals;
	}

	public void setOrdered_globals(List<String> ordered_globals) {
		this.ordered_globals = ordered_globals;
	}

	public Map<String,Integer> getGlobals() {
		return globals;
	}

	public void setGlobals(Map<String,Integer> globals) {
		this.globals = globals;
	}
}
