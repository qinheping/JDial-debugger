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
	private Map<ExpressionTuple, Expression> safeTable;

	public ExternalFunction(String name){
		setSafeTable(new HashMap<ExpressionTuple, Expression>());
		this.setName(name);
	}
	
	public void put(ExpressionTuple arg0, Expression arg1){
		this.safeTable.put(arg0, arg1);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<ExpressionTuple, Expression> getSafeTable() {
		return safeTable;
	}

	public void setSafeTable(Map<ExpressionTuple, Expression> safeTable) {
		this.safeTable = safeTable;
	}
	
	public Function getFunction(){
		List<Statement> stmts = new ArrayList<Statement>();
		List<ExprVar> vars = new ArrayList<ExprVar>();
		Integer length = 0;
		for(ExpressionTuple t: safeTable.keySet()){
			length = t.l.size();
		}
		for(int i = 0; i < length; i++){
			vars.add(new ExprVar("p"+i));
		}
		
		for(ExpressionTuple pl: safeTable.keySet()){
			Expression cond = new ExprBinary(vars.get(0), "==", new ExprConstInt(pl.l.get(0)),0);
			for( int i = 1; i < length; i++){
				cond = new ExprBinary(cond, "&&", new ExprBinary(vars.get(i), "==", new ExprConstInt(pl.l.get(i))));
			}
			Statement res = new StmtReturn(safeTable.get(pl));
			stmts.add(new StmtIfThen(cond,res,null));
		}
		stmts.add(new StmtReturn(new ExprStar()));
		List<Parameter> intpars = new ArrayList<>();
		for(int i = 0; i < length; i++){
			intpars.add(new Parameter(new TypePrimitive(4),"p"+i,0,false));
		}
		
		
		return new Function(this.name,new TypePrimitive(4), intpars, new StmtBlock(stmts));
	}
}
