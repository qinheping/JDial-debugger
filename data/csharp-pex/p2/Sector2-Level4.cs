//  P193 (source: 2.2 from zone BOP Semi Final, April 2014): Compute LCM(X,Y)
// Used in Imagine Cup 2014
using System;
using Microsoft.Pex.Framework;

public class Program {
  // Compute the lowest (least) common multiple of a and b
  // => use Euclid's algorithm to compute lcm(a,b) = |ab|/gcd(a,b)
  public static int Puzzle(int a, int b) {
    PexAssume.IsTrue(0 < a & a < 100);
    PexAssume.IsTrue(0 < b & b < 100);
    if ((a == 21 & b == 6) | (a == 23 & b == 14)); // Pex hint
    int n = a*b;
    while(b != 0) {
        int t = b;
        b = a % b;
        a = t;
    }
    return n/a;
  }
}