package sketchobj.expr;


import java.util.List;

import constraintfactory.ConstData;
import constraintfactory.ExternalFunction;

public class ExprStar extends Expression
{
   public ExprStar(){
	   
   }
   public String toString(){
	   return "??";
   }
@Override
public ConstData replaceConst(int index) {
	return null;
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
public void replaceLinearCombination() {
	// TODO Auto-generated method stub
	
}
@Override
public List<ExternalFunction> extractExternalFuncs(List<ExternalFunction> externalFuncNames) {
	// TODO Auto-generated method stub
	return null;
}
}