package global;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Global {
	public static final boolean prime_mod = true;
	public static final boolean rec_mod = false;
	public static String curFunc = "";
	public static int[] primes = {2,3,5,7,11,13,17,19,23,29};
	//public static int[] primes = {2,3,5,7,11,13};
	
	// all vars in the program <name, isTypeArray?>
	public static Map<String, Boolean> allvars = new HashMap<>();
	// vars that could be tracked modulaly at some location <name, modular values initialized?> 
	public static Map<String, Boolean> feasibleVars = new HashMap<>();
	// store dataflow facts
	public static Map<Integer, Set<String>> facts = null;
	// "finalvar" + "2", "finalvar" + "3", ...
	public static Set<String> dupFinals = new HashSet<>();
	// for (int i = 0; i < ) --> "i":
	public static Set<String> nestedVars = new HashSet<>();
	// function(int x, int y) --> x, y
	public static Set<String> params = new HashSet<>();
}
