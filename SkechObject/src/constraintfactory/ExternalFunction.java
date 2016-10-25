package constraintfactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sketchobj.core.*;
import sketchobj.expr.*;
import sketchobj.stmts.*;

public class ExternalFunction {
	private String name;
	private Map<ParametersList, Expression> safeTable;

	public ExternalFunction(String name){
		setSafeTable(new HashMap<ParametersList, Expression>());
		this.setName(name);
	}
	
	public void put(ParametersList arg0, Expression arg1){
		this.safeTable.put(arg0, arg1);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<ParametersList, Expression> getSafeTable() {
		return safeTable;
	}

	public void setSafeTable(Map<ParametersList, Expression> safeTable) {
		this.safeTable = safeTable;
	}
	
	public Function getFunction(){
		List<Statement> stmts = new ArrayList<Statement>();
		for(ParametersList pl: safeTable.keySet()){
			
		}
		return null;
	}
}
