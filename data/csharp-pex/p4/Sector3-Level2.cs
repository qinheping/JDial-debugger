// P139: (ICSE2)  Compute sum of n-th and n-1st Fibonacci numbers
// Used in Imagine Cup 2014
using System;
using Microsoft.Pex.Framework;

public class Program {
  public static int Puzzle(int x) {
    PexAssume.IsTrue(x >= 0 & x < 1000);
    int valueA = 0;
    int valueB = 1;
    int r = 0;
    bool everyOther = true;
    for (int i = 0; i < x; i++) {
      if (everyOther) {
        valueA += valueB;
        everyOther = false;
        r = valueA;
      } else {
        valueB += valueA;
        everyOther = true;
        r = valueB;
      }
    }
    return r;
  }
}