

public class Program {
  public static int Puzzle(int a, int b) {
	  int r,a1=a,a2=b;
	  	 do {r=Math.abs(a) % Math.abs(b);
		 a=Math.abs(b);
		 b=r;	
		}while(r>0);
		return a1*a2/b; // Change b to a
  }
}