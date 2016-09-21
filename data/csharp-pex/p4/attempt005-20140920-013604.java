

public class Program {
  public static int Puzzle(int n) {
	if(n == 0) return 1; // CHANGE 	if(n == 0) return 0;
	if(n == 1) return 1;
	//ADD if(n == 2) return 2;
    return Puzzle(n-1) + Puzzle(n-2);
  }
}