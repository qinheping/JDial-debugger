package sketchobj.expr;

import java.util.List;

import constraintfactory.ConstData;

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
	public void replaceLinearCombination() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean equals(Expression other) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<String> extractExternalFuncs(List<String> externalFuncNames) {
		// TODO Auto-generated method stub
		return null;
	}
}
