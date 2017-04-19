import java.util.Scanner;

public class Main
{
    public static int largestGap(){
      int[] a = {-3, -20 , -2};
      int N = 3;
      int max = 0;
      int min = 100;
      for(int i=0; i < N; i++){
         if(max < a[i]) max = a[i];
         if(min > a[i]) min = a[i];
      }
  return max-min;
}

	public static void main(String[] args)
	{
	    int x = largestGap(); 
	    System.out.println(x);
	}		
}
