using System;
using System.Collections.Generic;

public class Program {
  public static int Puzzle(string s) {
    Stack<char> stack=new Stack<char>();
	int bcount =0;
	int bcountMax = 0;
	for(int i=0;i<s.Length;++i)
	{
		if(s[i]=='(')
		{
			stack.Push(s[i]);
			++bcount;
		}
		else if(s[i] == ')')
		{
			if(stack.Count == 0) return 0;
			else
			{
				 stack.Pop();
				 --bcount;
			}
		}
		else return 0;  //REMOVE
		if(bcount > bcountMax)
			bcountMax = bcount;
	}
	return stack.Count == 0?bcountMax:0;
  }
}