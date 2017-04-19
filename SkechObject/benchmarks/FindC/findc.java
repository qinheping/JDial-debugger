import java.util.Scanner;

public class Main
{
    public static int FindC(){
        int k = 3;
         int[] s = {1,2,3,4} ;
    int c = 4;
    for(int i=0; i < k; i++){
      if(s[i]==c)
        return 1;
    }
    return 0;
}

	public static void main(String[] args)
	{
	    int x = FindC(); 
	    System.out.println(x);
	}		
}
