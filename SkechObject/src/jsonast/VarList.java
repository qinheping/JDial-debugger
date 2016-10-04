package jsonast;

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

}
