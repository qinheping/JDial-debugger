package jsonast;

import java.util.List;

import jsonparser.jsonParser.TraceContext;

public class Traces extends JsonNode{

	private List<TraceContext> tracelist;

	public Traces(List<TraceContext> trace) {
		this.setTracelist(trace);
	}

	public List<TraceContext> getTracelist() {
		return tracelist;
	}

	public void setTracelist(List<TraceContext> tracelist) {
		this.tracelist = tracelist;
	}

}
