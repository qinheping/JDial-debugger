package jsonast;

public class Stdin extends JsonNode{

	private String stdin;

	public Stdin(String text) {
		this.setStdin(text);
		}

	public String getStdin() {
		return stdin;
	}

	public void setStdin(String stdin) {
		this.stdin = stdin;
	}

	public String toString(){
		return this.stdin;
	}
}
