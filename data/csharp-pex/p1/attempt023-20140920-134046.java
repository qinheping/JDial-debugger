

public class Program {
  public static int Puzzle(String s) {
	  int tmp = 0, best = 0, cur = 0;
	  for(int i = 0; i < s.length(); i++)
	  {
	  	if(s.charAt(i)=='(')
		  tmp++; 
		else if(s.charAt(i)==')')
		{
		  //ADD cur++;
		  tmp--;
		  best = ((cur+1)>best)?(cur+1):best; // CHANGE best = (cur>best)?cur:best;		  
		  cur = (tmp==0)?0:cur++; //CHANGE cur = (tmp==0)?0:cur;
		} else if(tmp!=0)
			return 0;
		if(tmp<0)return 0;
	  }
	  return (tmp==0)?best:0;
  }
}