import java.util.Scanner;

public class Main
{
    public static int largestGap(){
      int[] a = {-3, -20 , -2};
      int N = 3;
    	int sum = 0;
     int[] submean = new int [N];
    	for (int i = 0; i < N; i++) {
       sum = sum + a[i];
	submean[i] = sum/(i+1);
      } 
	int max = submean[0];

	 for(int i = 1; i < N; i++){
		if (submean[i]>max)
			max = submean[i];
	}
return max;

      }

    
}

	public static void main(String[] args)
	{
	    int x = largestGap(); 
	    System.out.println(x);
	}		
}
