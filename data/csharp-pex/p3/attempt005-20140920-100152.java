

public class Program {
  public static int Puzzle(int[] a) {
	  int max = 100000; // CHANGE 100000 to a[0]
	  int min = 0;		// CHANGE 0 to a[0]
	  for (int i = 0; i < a.length; ++i) {
		  max = Math.max(max, a[i]);
		  min = Math.min(min, a[i]);
	  }
	  
    return (max - min);
  }
}