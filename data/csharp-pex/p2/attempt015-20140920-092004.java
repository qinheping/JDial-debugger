

public class Program {
  public static int Puzzle(int a, int b) {
	  	int p=a;
   		for(int d=2;d<=b;d++){  //CHANGE 2 to 1
			   if(a%d!=0&&b%d==0){
				   p*=d;
				   b/=d;
				   d=2;			//CHANGE 2 to 1
			   }
		   }
		return p;
  }
}