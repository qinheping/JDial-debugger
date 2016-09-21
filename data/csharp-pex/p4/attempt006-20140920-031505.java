

public class Program {
  public static int Puzzle(int n) {
    if(n>4)return n;  //CHANGE > to <
	else return Puzzle(n-1)+Puzzle(n-2);
  }
}