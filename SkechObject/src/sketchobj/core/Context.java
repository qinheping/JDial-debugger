package sketchobj.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Context {
	private Stack<Map<String,Type>> varStack;
	private Map<String,Type> currentVars;
	private int linenumber;
	
	public Context(){
		this.setVarStack(new Stack<Map<String, Type>>());
		this.setCurrentVars(new HashMap<String, Type>());
		this.varStack.push(this.currentVars);
		this.linenumber = 1;
		}

	public Map<String,Type> getCurrentVars() {
		return currentVars;
	}
	
	public String toString(){
		return this.currentVars.toString();
	}

	public Context(Context ctx){
		this.varStack = new Stack<Map<String,Type>>();
		Stack<Map<String, Type>> temp1 = new Stack<Map<String,Type>>();
		@SuppressWarnings("unchecked")
		Stack<Map<String, Type>> temp2 = (Stack<Map<String, Type>>) ctx.varStack.clone();
		while(!temp2.isEmpty()){
			temp1.push(temp2.pop());
		}
		while(!temp1.isEmpty()){
			this.varStack.push(new HashMap<String,Type>(temp1.pop()));
		}
		this.linenumber = ctx.linenumber;
		this.currentVars = new HashMap<String, Type>(ctx.currentVars);
	}

	public void pushVars(Map<String, Type> m){
		 varStack.push(m);
	}
	
	public void linePlus(){
		this.linenumber++;
	}
	
	public Map<String, Type> popVars(){
		currentVars = varStack.pop();
		return currentVars;
	}
	
	public void addVar(String s, Type t){
		currentVars.put(s, t);
	}
	
	public void pushNewVars(){
		this.varStack.push(currentVars);
		currentVars = new HashMap<String, Type>();
	}
	
	public void setCurrentVars(Map<String,Type> currentVars) {
		this.currentVars = currentVars;
	}

	public Stack<Map<String,Type>> getVarStack() {
		return varStack;
	}

	public void setVarStack(Stack<Map<String,Type>> varStack) {
		this.varStack = varStack;
	}
	
	public Map<String, Type> getAllVars(){
		List<Map<String, Type>> list = new ArrayList<Map<String, Type>>(this.getVarStack());
		Map<String, Type> result = new HashMap<String, Type>();
		for(Map<String, Type> m: list){
			result.putAll(m);
		}
		result.putAll(currentVars);
		return result;
	}

	public int getLinenumber() {
		return linenumber;
	}

	public void setLinenumber(int linenumber) {
		this.linenumber = linenumber;
	}
}
