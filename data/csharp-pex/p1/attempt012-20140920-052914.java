

public class Program {
  public static int Puzzle(String s) {
	  int k=0,q=0,maxq=0;
	for(int i=0;i<s.length();i++){
		if(s.charAt(i)=='(')
			k++;
		if(s.charAt(i)==')')
		{
			--k;
			q++;
		}
		if(k==0){
			if(q>maxq){
				maxq=q;
			}
			// Adding this makes it right apparently q=0;
		}
		if(k<0){
			return 0;
		}
	}
    return k==0?maxq:0;
  }
}