using System;

public class Program {
  public static int Puzzle(string s) {
	  var i =0;
	  var max = 0;
	  foreach(var c in s) {
		if (c == '(')
		i++;
		if (c ==')')
		i--;
		if (i > max) max =i;  
		// ADD if (i < 0) return 0; 
	  }
    return i == 0?max:0;
  }
}