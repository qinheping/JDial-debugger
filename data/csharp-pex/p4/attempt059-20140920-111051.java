

public class Program {
  public static int Puzzle(int n) {
    int a=1,b=1,i=1;
	for(;i<n;a=b+(b=a))i++; // CHANGE for(;i<=n;a=b+(b=a))i++;	
	return b; // CHANGE return n==0?0:b;
  }
}