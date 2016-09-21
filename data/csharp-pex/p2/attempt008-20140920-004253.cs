using System;

public class Program {
  public static int Puzzle(int a, int b) {
    return a*b/Help(a, b);
  }
  
  public static int Help(int a, int b) {
	if (a < b) 
	  return Help(b, a);
	var r = 0;
	do {		
	  r = a % b;
	  a=b;
	  b=r;	
	} while(r == 0); // CHANGE == to !=
	return a;
  }
}