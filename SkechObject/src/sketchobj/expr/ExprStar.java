package sketchobj.expr;

import java.util.List;

import sketchobj.core.Type;

public class ExprStar extends Expression
{
   public ExprStar(){
	   
   }
   public String toString(){
	   return "??";
   }
@Override
public int replaceConst(int index) {
	return index;
}
}