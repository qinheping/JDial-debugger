package sketchobj.expr;


import constraintfactory.ConstData;

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
}