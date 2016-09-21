

public class Program {
  public static int Puzzle(String s) {
	  int counter = 0;
	  int max = 0;
	  for(int i = 0; i < s.length(); i++){
		  if(s.charAt(i) == '('){
			  counter++;
			  if(counter > max){
				  max++;
			  }
		  } else {
			 if(s.charAt(i) == ')'){
			   	 counter--;
				  if(counter < 0){
					  return 0;
				  }
		  	 }
		  }
	  }
    return max; //CHANGE return counter == 0 ? max : 0;
  }
}