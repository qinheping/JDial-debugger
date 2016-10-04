import java.util.Scanner;

public class Main
{
	public static int largestGap(int[] a)
	{
	    int max = 1; 
	    a[1] = 10; 
	    int c = max++; 
	    int min = 100;  
	    for(int i=0; i < 4; i++)
	    { 
	        if(max < a[i]) 
	        max = a[i]; 
	    }
        return max-min;
	}

	public static void main(String[] args)
	{
	    int x = largestGap( new int[]{ 2, 3, 7, 1 } ); 
	    System.out.println(x);
	}		
}
