import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;;
public class MedianPrintSimExtra1 {
	public static void main(String[] args) throws FileNotFoundException, InterruptedException{
		String oriTraces = new Scanner(new File("benchmarks/median-print-sim-extra1/median-test1")).useDelimiter("\\Z").next();
		String correctTrace = new Scanner(new File("benchmarks/median-print-sim-extra1/median-target1")).useDelimiter("\\Z").next();
		MainEntrance me = new MainEntrance(oriTraces,correctTrace,13);
		ArrayList<Integer> l = new ArrayList<Integer>();
		l.add(3);
		l.add(4);
		l.add(5);
		l.add(6);
		l.add(7);
		l.add(8);
		//me.setRepairRange(l);
		String res = me.Synthesize(true).toString();
		System.out.println(res);
	}
}
