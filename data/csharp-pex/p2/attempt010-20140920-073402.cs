using System;
public class Program {
  public static int Puzzle(int a, int b) {
	for(int i =2;i<=a;++i)
	{
		if((a-b)%i==0) b/=i--; // CHANGE if(a%i==0&&b%i==0) b/=i--;
	}
	return a*b;
  }
}