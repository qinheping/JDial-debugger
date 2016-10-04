package jsonast;

public class Code extends JsonNode {

	private String code = "NULL";

	public Code(String text) {
		this.setCode(text.substring(1,text.length()-1));
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String toString() {
		return code;
	}

}
