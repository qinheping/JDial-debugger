using System;

public class Program {
  public static int Puzzle(int a, int b) {
	int max = Math.Max(a,b);
	b = Math.Min(a,b);
	int gcd = GCD(max,b);
    return (gcd==1)?max*b:max*gcd;
  }
  static int GCD(int a, int b)
{
    return b == 0 ? a : GCD(b, a % b);
}
}