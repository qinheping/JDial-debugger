
public class Program {

    public static int Puzzle(string s) {
		int ans = 0;
		int count = 0;
		for (int i = 0; i < s.Length; i++) {
			if (s[i] == '(') {
				++count;
				ans = ans > count ? ans : count;
			} else if (s[i] == ')') {
				--count;
				count < 0 ? return 0: 0; // Change to if(count <0) return 0;
			}
		}
		return count == 0 ? ans : 0;
	}
}
