

public class Program {
  public static int Puzzle(String s) {
	  int cnt = 0, cnt2 = 0;
	  for (char ch: s) {
		  if (ch == '(') ++cnt;
		  else if (ch == ')') --cnt;
		  if (cnt2 > cnt) cnt2 = cnt; // Fix: change > to <
		  if (cnt < 0) return 0;
	  }
	  return cnt == 0 ? cnt2 : 0;
  }
}