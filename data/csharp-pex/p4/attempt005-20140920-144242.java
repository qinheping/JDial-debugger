

public class Program {
	public static int fib(int n) {
	    return (n <= 1)? n : (fib(n-1) + fib(n-2));
	}
  public static int Puzzle(int n) {
	  //ADD if n==0 return 0
	  return fib(n+1);
  }
}