package sketchobj.core;

import java.util.List;

import constraintfactory.ConstData;
import sketchobj.expr.Expression;

public class ExpressionList extends SketchObject{
	private List<Expression> list;
	
	public ExpressionList(List<Expression> le){
		this.list = le;
	}

	public List<Expression> getList() {
		return list;
	}

	public void setList(List<Expression> list) {
		this.list = list;
	}

	@Override
	public ConstData replaceLinearCombination(int index) {
		// TODO Auto-generated method stub
		return null;
	}
}
