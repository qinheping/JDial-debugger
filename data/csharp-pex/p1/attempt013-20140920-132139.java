

public class Program {
  public static int Puzzle(String s) {
	  int tmp = 0, best = 0, cur = 0;
	  for(int i = 0; i < s.length(); i++)
	  {
		 if(tmp==0)
		 {
			 if(cur>best)
			 	best = cur;
			cur = 0;
		 }
	  	if(s.charAt(i)=='(')
		{
		  tmp++;
		  cur++;
		} else if(s.charAt(i)==')')
		  tmp--;
		else
		  break; // CHANGE TO if(tmp!=0) return 0;
		if(tmp<0)
		  return 0;
	  }
	  if(tmp==0)
		 {
			 if(cur>best)
			 	best = cur;
				 return best;
		 } else return 0;
    	
  }
}