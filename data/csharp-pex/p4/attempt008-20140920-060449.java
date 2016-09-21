

public class Program {
  public static int Puzzle(int n) {
	  return Fib(n+1); 
	  // CHANGE TO if(n==0)
	  // 	return 0;
	  // else
	  //   return Fib(n+1);
  }
  public static int Fib(int n){
	  if(n == 0)
        return 0;
    else if(n == 1)
      return 1;
   else
      return Fib(n - 1) + Fib(n - 2);
  }
}