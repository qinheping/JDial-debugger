

public class Program {
  public static int Puzzle(int[] a) {
	 int min = 100000000, max = 0; // CHANGE max = -100000000
    for(int i = 0; i < a.length; i++)
	{
		min = (a[i]<min)? a[i]:min;
		max = (a[i]>max)? a[i]:max;
	}
	return max - min;
  }
}