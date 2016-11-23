package jsonast;

import java.util.List;

public class Var extends JsonNode {

	private String name;
	private Integer value;
	private Integer type; // type 0 : int 1 : ref
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
		this.name = text;
		this.type =1;
		this.setList(visit);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getValue() {
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

	
	public String getListasString(){
		String result = "{" +list.get(0).toString();
		for(int i = 1; i < list.size(); i++){
			result += "," + list.get(i).toString(); 
		}
		return result+"}";
	}
	
	public String toString() {
		/*
		System.out.println(this.type);
		System.out.println(this.name + ": " +this.value);
		*/
		if (this.type == 3)
			System.out.println(this.name + " "+this.value + " "+ "error");
		
		if (this.type == 0)
			return this.name + ": " + this.value + "\n";
		return this.name + "[REF: " + this.value + "\n";
	}

}
