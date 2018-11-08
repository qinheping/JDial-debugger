public class Test {

public static int iterPower(int base, int exp){
    int result = 1;  // result = 0
    while(exp>=1){
	result += base;
	exp -= 1;
    }
    return result;
}

public static void main(String[] args){
    int z = iterPower(4,5);
    System.out.println(z);
}

}