

public class Program {
  public static int Puzzle(int a, int b) {
	 int max = Math.max(a,b);
	 int counter = 1;
	 for(int i = 2; i <= max; i++){
		 boolean flag = false;
		 while(a % i == 0 && b % i == 0){
			 a/=i;
			 b/=i;
			counter *= i;
		 }
		 while(a % i == 0){
			 b/=i;  // CHANGE a/=1;
			counter *= i;
		 }
		 while(b % i == 0){
			 b/=i;
			counter *= i;
		 }
	 }
     return counter;
  }
}