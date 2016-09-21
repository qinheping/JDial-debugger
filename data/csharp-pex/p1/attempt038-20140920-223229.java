public class Program {
	public static int Puzzle(String s) {
		int opened = 0;
		int res = 0;
		
		for (int i = 0; i < s.length(); ++i) {
			char c = s.charAt(i);
			if (c == '(') {
				++opened;
			} else
			
			if (c == ')' && opened > 0) {
				--opened;
				++res;
			}  else {
				return 0; //REMOVE
				res = 0;
				opened = 0;
			}
		}
		
		if (opened > 0 || res <= 1) res = 0;
		
		return res;
	}
}