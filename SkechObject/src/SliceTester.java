import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
public class SliceTester {
	public static void main(String[] args){
			if(args.length != 1){
				System.err.println("Usage: SliceTester <filename>");
				System.exit(1);
			}
			BufferedReader is = null;
			try{
				is = new BufferedReader(new FileReader(args[0]));
			}catch(FileNotFoundException fnfe){
				System.err.println("File: " + args[0] + " not found.");
				System.exit(1);
			}
			StringBuilder textBuilder = new StringBuilder();
			Scanner s = new Scanner(is);
			while(s.hasNextLine()){
				String line = s.nextLine();
				textBuilder.append(line + "\n");
			}
			String progText = textBuilder.toString();
			SliceUtil slicer = new SliceUtil(progText, "CalcStatic");
			ArrayList<Integer> lineNums = slicer.get_slice_line_nums("CalcStatic", "main", 54, "top");
			for(int ln: lineNums){
				System.out.println(ln);
			}
	}
}
