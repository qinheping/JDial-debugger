public class Main
{
    public static int largestGap(int N, int[] a){
      int max = -100;
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
	    int[] a = {-8,-1,-3};
	    int x = largestGap(3,a); 
	}		
}