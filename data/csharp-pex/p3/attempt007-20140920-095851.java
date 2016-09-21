

public class Program {
  public static int Puzzle(int[] a) {
	  int max = 0; //CHANGE int max = a[0];	  
	  int min = 0; //CHANGE int min = a[0];
	  for (int i = 0; i < a.length; i++) {
	  	if(max<a[i]) max = a[i];
		if(min>a[i]) min = a[i];
	  }		
	 		
			
    return max-min;
  }
}