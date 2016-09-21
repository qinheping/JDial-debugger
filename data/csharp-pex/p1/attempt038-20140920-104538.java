

public class Program {
  public static int Puzzle(String s) {
	  // Correct version of first 4 lines
	  //int k=0,q=0,maxq=0;	  
      //for (char c : s){//s.replaceAll("[^()]","")){
		
	  int k,q,maxq;
	  if(s.replaceAll("[^()]","").length()%2!=0)
	  	return 0;
      for (char c : s.replaceAll("[^()]","")){
			  if(c=='(')
				k++;
			if(c==')')
			{
				--k;
				q++;
				if(k==0){
					maxq= q>maxq? q : maxq;
					q=0;
				}
				if(k<0){
					return 0;
				}
			}
		  }
    return k==0?maxq:0;
  }
}