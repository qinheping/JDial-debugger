package sketchobj.expr;

import java.util.ArrayList;
import java.util.List;

import constraintfactory.ConstData;
import constraintfactory.ExternalFunction;

public class ExprString extends Expression{
	private String content;
	
	public ExprString(String content){
		this.content = content;
	}
	
	public String toString(){
		return this.content;
	}

	@Override
	public ConstData replaceConst(int index, String string) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean equals(Expression other) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ExternalFunction> extractExternalFuncs(List<ExternalFunction> externalFuncNames) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void checkAtom() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ConstData replaceLinearCombination(int index) {
		return new ConstData(null, new ArrayList<>(), index, 0, null,0);
	}
}
