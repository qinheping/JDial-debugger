import java.util.Scanner;
 
public class Main {
  public static void main (String[] args) {
    // Part 1
    // 1. Read 10 integers from stdin
    Scanner scn = new Scanner(System.in);
    int[] nums = new int[10];
    for (int i = 0; i < nums.length; i++) {
      if (scn.hasNextInt()) {
        nums[i] = scn.nextInt();
      } else {
        System.err.println("not enough input");
        System.exit(1);
      }
    }
 
    scn.close();
 
    // Part 2
    // 2. Compute sum of nums
    // 3. Compute mean of nums
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum = sum + nums[i];
    }
 
    int mean = sum / nums.length;
 
    // Part 3
    // 4. Compute sums of subsequences
    for (int n = 0; n < nums.length; n++) {
      int subsum = 0;
      for (int m = n; m < nums.length - 1; m++) { // should be `m < nums.length`
        subsum = subsum + nums[m];
      }
      System.out.println(subsum);
    }
  }
}
