import java.math.*;
public class Main {
    static int SimpleJava(int n) {
        int sum = 0;
		for(int i = 0; i < n; i++){
			sum += Math.pow(n,i);
		}
        return sum;
    }

    public static void main(String[] args) {
        int x = SimpleJava(5);
        System.out.println(x);
    }
}

