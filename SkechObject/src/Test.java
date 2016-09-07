import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import constrainfactory.ConstrainFactory;
import sketchobj.core.Function;
import sketchobj.core.TypePrimitive;
import sketchobj.stmts.Statement;

public class Test {

	@org.junit.Test
	public void test1() {
		Function f = ConstrainFactory.addConstFun(0, 5, new TypePrimitive(4));
		System.out.println(f);
	}
	
	@org.junit.Test
	public void test2() {
		Statement s = ConstrainFactory.constChangeDecl(5);
		System.out.println(s);
	}
	
	@org.junit.Test
	public void test3() {
		Statement s = ConstrainFactory.varArrayDecl("t", 5, new TypePrimitive(4));
		System.out.println(s);
	}
	
	@org.junit.Test
	public void test4() {
		List<String> otherVars = new ArrayList<String>();
		otherVars.add("y");
		otherVars.add("z");
		Statement s = ConstrainFactory.recordState(0, otherVars);
		System.out.println(s);
	}
	
	

}
