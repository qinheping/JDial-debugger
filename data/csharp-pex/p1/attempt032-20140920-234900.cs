
public class Program {

    public static int Puzzle(string s) {
         int c = 0, c1 = 0;
		 foreach (char e in s) {
			 if (e == '(') {
				 ++c;
				 if (c > c1) c1 = c;
			 } else if ( e== ')' && c > 0) { // Remove && c > 0
				 --c;
			 	if (c < 0) return 0;
			 } 
		 }
		 return c == 0 ? c1 : 0;
	}
}
