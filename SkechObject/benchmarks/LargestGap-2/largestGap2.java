public class Main
{
    public static int largestGap(int N, int[] a){
      int max = a[0];
      int min = 100;
      for(int i=1; i < N; i++){
         if(max < a[i])
		     max = a[i];
         if(min > a[i])
		     min = a[i];
      }
	  int z = max-min;
  return z;
}

	public static void main(String[] args)
	{
	    int[] a = {-80,-10,-30};
	    int x = largestGap(3,a); 
	}		
}