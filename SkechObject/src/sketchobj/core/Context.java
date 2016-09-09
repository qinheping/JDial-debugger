package sketchobj.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Context {
	private Stack<Map<String,Type>> varStack;
	private Map<String,Type> currentVars;
	
	public Context(){
		this.setVarStack(new Stack<Map<String, Type>>());
		this.setCurrentVars(new HashMap<String, Type>());
		this.varStack.push(this.currentVars);
		}

	public Map<String,Type> getCurrentVars() {
		return currentVars;
	}

	public void pushVars(Map<String, Type> m){
		this.varStack.push(m);
	}
	
	public Map<String, Type> popVars(){
		return varStack.pop();
	}
	
	public void addVar(String s, Type t){
		currentVars.put(s, t);
	}
	
	public void pushNewVars(){
		this.varStack.push(new HashMap<String,Type>());
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
}
