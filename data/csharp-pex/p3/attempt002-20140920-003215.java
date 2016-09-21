

public class Program {
  public static int Puzzle(int[] a) {
    int max = 0, min = Integer.MAX_VALUE; // CHANGE 0 to Integer.MIN_VALUE
	for (int i = 0; i < a.length; i++) {
		max = Math.max(max, a[i]);
		min = Math.min(min, a[i]);
	}
	return max - min;
  }
}