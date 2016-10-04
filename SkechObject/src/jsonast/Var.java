package jsonast;

import java.util.List;

public class Var extends JsonNode {

	private String name;
	private Integer value;
	private Integer type;
	private List<?> list;

	public Var(String text, Integer parseInt) {
		this.setName(text);
		this.setValue(parseInt);
		this.setType(0);
	}

	public Var(String text, int parseInt, int i) {
		this.name = text;
		this.value = parseInt;
		this.setType(i);
	}

	public Var(String text, List<?> visit) {
		this.setList(visit);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}

}
