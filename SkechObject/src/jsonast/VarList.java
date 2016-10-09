package jsonast;

import java.util.ArrayList;
import java.util.List;


public class VarList extends JsonNode{

	private List<Var> var;

	public VarList(List<Var> varl) {
		this.setVar(varl);
	}

	public List<Var> getVar() {
		return var;
	}

	public void setVar(List<Var> var) {
		this.var = var;
	}

	public List<String> toStringList() {
		List<String> result = new ArrayList<String>();
		for(Var v: var){
			result.add(v.getName());
		}
		return result;
	}
	
	public Var find(String s){
		for(Var v: var){
			if(v.getName().equals(s))
				return v;
		}
		return null;
	}

	public String toString(){
		String result = "";
		for(Var v: var){
			result+=v.toString();
		}
		return result;
	}
}
