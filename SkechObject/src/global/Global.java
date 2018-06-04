package global;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Global {
	public static final boolean prime_mod = true;
	public static final boolean rec_mod = false;
	public static String curFunc = "";
	public static int[] primes = {2,3,5,7,11,13,17,19,23,29};
	//public static int[] primes = {2,3,5,7,11,13};
	public static Set<String> replicatedVars = new HashSet<>();
	public static Map<Integer, Set<String>> facts = null;
}
