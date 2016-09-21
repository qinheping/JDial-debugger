

public class Program {
	public static int Puzzle(String s) {
		char[] chars  = s.toCharArray();
		if(chars.length%2!=0)return 0; //REMOVE this line
		int opened = 0;
		int closed = 0;
		int maxBrackets = 0;
		for(char c : chars)
		{
			if(c=='(')
			{
				if(closed!=0)
				{
					if(opened!=closed)return 0;
					maxBrackets = Math.max(opened, maxBrackets);
					opened = 1;
					closed = 0;
				} else opened++;
			}
			else if(c==')')
			{
				if(opened!=0)
				{
					closed++;
				}
				System.out.println("Cl "+closed); // CHANGE to else return 0;
			}
		}
		if(opened!=closed)return 0;
		maxBrackets = Math.max(Math.min(opened, closed), maxBrackets);
		return maxBrackets;}
}