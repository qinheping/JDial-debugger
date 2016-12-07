//Condensed a broken RPN calculator from APEX into a single procedure.
import java.util.Scanner;
public class CalcStatic {
	public static void main(String[] args){
		String[] input = new String[]{"1","2","+"};
		int stack_max = 10; //
		int[] stack = new int[stack_max]; 
		int top = 0; //
		boolean stack_underflow = false; 
		boolean stack_overflow = false;
		boolean done = false;
		int idx = 0;
		while(idx < input.length && !stack_underflow && !stack_overflow && !done){ 
			String line = input[idx];
			idx++;
			if(line.equals("+")){ 
				int a = 0;
				int b = 0;
				if(top >= stack_max){ //BUG 
					stack_underflow = true;
				}else{
					top = top - 1; 
					
					if(top < 0){//Replicate C behavior
						top = 0;
					}
					a = stack[top];
					if(top >= stack_max){ //BUG 
						stack_underflow = true;
					}else{
						top = top - 1;
						if(top < 0){
							top = 0; //Replicate C behavior
						}
						b = stack[top];
						int res = a + b;
						if(top >= stack_max){ 
							stack_overflow = true;
						}else{
							stack[top] = res;
							top = top + 1;
						}						
					}
				}
		        }else{
				int num = Integer.parseInt(line);
				if(top >= stack_max){
					stack_overflow = true;
				}else{
					stack[top] = num;
					top = top + 1;
				}
			}
		}
		if(stack_overflow){
			System.out.println("Error: Stack overflow");
		}
		if(stack_underflow){
			System.out.println("Error: popped from empty stack");
		}
		System.out.println(stack[top - 1]);
	}
	
}
