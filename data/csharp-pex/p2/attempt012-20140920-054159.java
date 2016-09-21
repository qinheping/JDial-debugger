

public class Program {
  public static int Puzzle(int a, int b) {
	  	int p=a;
   		for(int d=2;d<=(b-1);d++){ // CHANGE b-1 to b
			   if(a%d!=0&&b%d==0){
				   p*=d;
				   b/=d;
				   d=1;
			   }
		   }
		return p;
  }
}