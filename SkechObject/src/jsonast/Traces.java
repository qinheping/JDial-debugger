package jsonast;

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

}
