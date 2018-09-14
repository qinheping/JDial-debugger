package jsonast;

import java.util.ArrayList;
import java.util.List;

import jsonparser.jsonParser.TraceContext;

public class Traces extends JsonNode {

	private List<Trace> tracelist;
	private int length;

	public Traces(List<Trace> trace) {
		this.setTracelist(trace);
		this.length = trace.size();
	}

	public List<Trace> getTraces() {
		return tracelist;
	}

	public void setTracelist(List<Trace> tracelist) {
		this.tracelist = tracelist;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public Traces findSubTraces(String targetFunc, int bound) {
		List<Integer> toRemove = new ArrayList<Integer>();
		int firstIndex = bound;
		for (int i = bound; i >= 0; i--) {
			// adapt for interprocedure
			if (tracelist.get(i).getFuncname().equals(targetFunc)) {
				firstIndex = i;
			}
			/*if (!tracelist.get(i).getFuncname().equals(targetFunc)) {
				toRemove.add(i);
				continue;
			}*/
			//chenged
			if (!tracelist.get(i).getEvent().equals("step_line") || 
					(i > 0 && tracelist.get(i-1).getEvent().equals("return"))) {
				toRemove.add(i);
				continue;
			}

		}
		for (int i = this.tracelist.size() - 1; i >= 0; i--) {
			if (toRemove.contains(i)|| i > bound || i < firstIndex){
				tracelist.remove(i);
			}
		}
		this.length = this.tracelist.size();
		return this;
	}

	public String toString() {
		String result = "";
		int i = 0;
		for (Trace t : this.tracelist) {
			result += "Trace " + i + ": " + t.toString();
		}
		return result;
	}
}
