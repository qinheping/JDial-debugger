

public class Program {
	public static int Puzzle(String s) {
		char[] chars  = s.toCharArray();
		if(chars.length%2!=0)return 0;
		int opened = 0;
		int closed = 0;
		int maxBrackets = 0;
		boolean something=false;
		for(char c : chars)
		{
			if(c=='(')
			{
				if(closed!=0)
				{
					// ADD if(opened!=closed)return 0;
					maxBrackets = Math.max(Math.min(opened, closed), maxBrackets);
					opened = 1;
					closed = 0;
				} else opened++;
				System.out.println("Op "+opened);
			}
			else if(c==')')
			{
				if(opened!=0)
				{
					closed++;
				}
				System.out.println("Cl "+closed);
			}
			else
			{
				if(c=='a'&&opened>0)something=true;
			}
			
		}
		//ADD if(opened!=closed)return 0;
		maxBrackets = Math.max(Math.min(opened, closed), maxBrackets);
		return (maxBrackets==1)?0:maxBrackets;}

	
}