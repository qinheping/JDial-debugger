

public class Program {
  public static int Puzzle(String s) {
	  int tmp = 0, best = 0, cur = 0;
	  for(int i = 0; i < s.length(); i++)
	  {
	  	if(s.charAt(i)=='(')
		  tmp++; 
		else if(s.charAt(i)==')')
		{
		  cur++;
		  tmp--;
		} else if(tmp!=0)
			return 0;
		//ADD if(tmp<0)return 0;
		if(tmp==0)
		{
			if(cur>best)
		  		best = cur;
		 	 cur = 0;
		}
	  }
	  return (tmp==0)?best:0;
  }
}