public class Main {
    public static void main(String[] args) {
        int a = 6;
		int b = 2;
		int c = 8;
		int m = 0;
		if ((a >= b && a <= c) || (a >= c && a <= b)){
			m = b;
		}else if ((b >= a && b <= c) || (b >= c && b <= a)){
			m = b;
		}else{
			m = c;
		}
		int z = m + 1 + 2 + 3;
    }
}

