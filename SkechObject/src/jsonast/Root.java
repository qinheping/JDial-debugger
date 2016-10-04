package jsonast;

public class Root extends JsonNode {

	private Code code;
	private Traces traces;
	private Stdin stdin;

	public Root(Code code, Traces traces, Stdin stdin) {
		this.setCode(code);
		this.setTraces(traces);
		this.setStdin(stdin);
	}

	public Code getCode() {
		return code;
	}

	public void setCode(Code code) {
		this.code = code;
	}

	public Traces getTraces() {
		return traces;
	}

	public void setTraces(Traces traces) {
		this.traces = traces;
	}

	public Stdin getStdin() {
		return stdin;
	}

	public void setStdin(Stdin stdin) {
		this.stdin = stdin;
	}

}
