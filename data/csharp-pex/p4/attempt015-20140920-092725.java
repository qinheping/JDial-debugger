

public class Program {
  public static int Puzzle(int n) {
	  //return n==0?0:Fib(n+1);
	  int a=1,b=0,c=a+b;
	  
		for(int i=0;i<n;i++){
			a=b;
			b=c;
			c=a+b;
		}
		return c; // CHANGE to return n==0?0:c;
  }
  public static int Fib(int n){
	  return n==0?0:n==1?1:Fib(n-1)+Fib(n-2);
  }
}