package jsonast;

import java.util.ArrayList;
import java.util.List;

import jsonparser.jsonParser.TraceContext;

public class Traces extends JsonNode{

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
		for(int i = bound; i >=0 ;i--){
			if(!tracelist.get(i).getFuncname().equals(targetFunc)){
				toRemove.add(i);
				continue;
			}
			if(!tracelist.get(i).getEvent().equals("step_line")){
				toRemove.add(i);
				continue;
			}
			
		}
		for(int i: toRemove){
			tracelist.remove(i);
		}
		this.length = this.tracelist.size();
		return this;
	}

	public String toString(){
		String result = "";
		int i = 0;
		for(Trace t: this.tracelist){
			result += "Trace "+ i + ": " + t.toString();
		}
		return result;
	}
}
