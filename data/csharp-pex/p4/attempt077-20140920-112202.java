

public class Program {
	  public static int Puzzle(int n) {
		if (n==0)
			return 0;
		if (n==1) 
			return 1;
		if(n==2)
			return 1; //CHANGE 1 to 2
		if(n==3)
			return 3;
		return Puzzle(n-1) + Puzzle(n-2);
  }
}