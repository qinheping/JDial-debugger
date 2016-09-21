// P198: Count the depth of nesting parentheses in a string
// Used in Imagine Cup 2014
using System;
using Microsoft.Pex.Framework;

public class Program {
  public static int Puzzle(string s) {

    PexAssume.IsNotNull(s);
    PexAssume.IsTrue(s.Length>4);
    if (s.Equals("(())()") | s.Equals("((()))") | s.Equals("()))((")); // Pex hint

    int openClose = 0;
    int maxDepth = 0;
    foreach (char c in s) {
      PexAssume.IsTrue(c==' '|c=='('|c==')'|(c>='a'&c<='z'));
      if ( c == '(' ) {
        openClose++;
        if ( openClose > maxDepth )
          maxDepth = openClose;
      }
      else
      if ( c == ')' ) {
        openClose--;
        if ( openClose < 0 ) return 0;
      }
      // else: ignore c
    }
    return (openClose == 0) ? maxDepth : 0;
  }
}