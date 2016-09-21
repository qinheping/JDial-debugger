

public class Program {
  public static int Puzzle(String s) {
	  //FIXES by adding if (s.equals("()()a")) return 1; IT'S A CHEATER
	int depth = 0;
		
	int max = 0;
	int stack = 0;
	
	char[] chars = s.toCharArray();
	for (char ch: chars) {
		if (ch == '(') {
			depth = 0;
			++stack;
		}
		if (ch == '\0') stack = 0;
		if (ch == ')' && stack > 0) {
			--stack;
			++depth;
		}

		max = Math.max(max, depth);
	}

	if (max > 1)return max;
	else return 0;
  }
}