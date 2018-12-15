public class Test {

public static int multIA(int m, int n){
    int result = 0;
    for(int i=0; i<n-1; i++){ // i < n
    	    result += m;
    }
    return result;
}

public static void main(String[] args){
    int z = multIA(4,5);
    System.out.println(z);
}

}