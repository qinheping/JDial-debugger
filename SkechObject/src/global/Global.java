package global;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Global {
	public static final boolean prime_mod = true;
	public static final boolean inc_mod = false;
	// track a var modularly only when it could always be tracked modularly
	public static final boolean only_mod = true;
	public static final boolean rec_mod = false;
	public static final boolean sem_dis = true;
	// use Qlose-like test cases
	public static final boolean test_mod = false;
	//public static boolean finalTracked = false;
	public static String curFunc = "";
	public static int[] primes = {2,3,5,7,11,13,17};
	//public static int[] primes = {2,3,5,7,11,13};
	
	// all vars in the program <name, isTypeArray?>
	public static Map<String, Boolean> allvars = new HashMap<>();
	// vars that could be tracked modulaly at some location <name, modular values initialized?> 
	public static Map<String, Boolean> feasibleVars = new HashMap<>();
	// vars that could be always tracked modulaly
	public static Set<String> alwaysVars = new HashSet<>();
	// store dataflow facts; for current line number, which vars' actual values must be tracked
	public static Map<Integer, Set<String>> facts = null;
	// alternative dataflow facts
	public static Set<Integer> altfacts = new HashSet<>();
	// for each feasible var, when the modular values should initialized
	public static Map<String, Set<Integer>> inilocs = new HashMap<>();
	// "finalvar" + "2", "finalvar" + "3", ...
	public static Set<String> dupFinals = new HashSet<>();
	// for (int i = 0; i < ) --> "i":
	public static Set<String> nestedVars = new HashSet<>();
	// function(int x, int y) --> x, y
	public static Set<String> params = new HashSet<>();
	// current line number of statement
	public static int line = 0;
	
}
