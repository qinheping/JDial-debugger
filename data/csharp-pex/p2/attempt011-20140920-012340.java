

public class Program {
	public static int GCD(int a, int b) { return b==0 ? a : GCD(b, a%b); }
  public static int Puzzle(int a, int b) {
    return GCD(a,b); // CHANGE return a/GCD(a,b)*b;
  }
}