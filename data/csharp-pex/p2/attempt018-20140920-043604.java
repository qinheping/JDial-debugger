

public class Program {
  public static int Puzzle(int a, int b) {
	 int counter = a*b;
	 while(Math.max(a,b) - Math.min(a,b) > 0){
		 if(a > b){
			 a = Math.max(a,b) - Math.min(a,b);
		 } else {
			 b = Math.max(a,b) - Math.min(a,b);
		 }
	 }
     return counter * a; // CHANGE return counter / a;
  }
}