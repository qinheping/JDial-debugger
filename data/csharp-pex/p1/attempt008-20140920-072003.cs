using System;

public class Program {
  public static int Puzzle(string s) {
	int bcount =0;
	int bcountMax = 0;
	for(int i=0;i<s.Length;++i)
	{
		if(s[i]=='(') ++bcount;
		else if(s[i] == ')')
		{
			if(bcount == 0) return 0;
			else --bcount;
		}
		if(bcount > bcountMax) bcountMax = bcount;
	}
	return bcountMax; // CHANGE return bcount == 0?bcountMax:0;
  }
}