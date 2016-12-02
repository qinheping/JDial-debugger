import java.io.*;
import java.util.ArrayList;

public class SliceUtil {
	String class_name;
	public SliceUtil(String prog_text, String class_name){
		this.class_name = class_name;
		File tmp = new File(this.class_name + ".java");
		try{
			tmp.createNewFile();
			FileWriter fw = new FileWriter(tmp);
			fw.write(prog_text);
			fw.close();
			
		}catch(IOException e){
			System.err.println("Failed to write to " + this.class_name + ".java");
			System.exit(1);
		}
		Runtime rt = Runtime.getRuntime();
		try{
			Process mk_file = rt.exec(new String[]{"make_jar.sh", this.class_name});
			mk_file.waitFor();
		}catch(IOException e){
			System.err.println("Failed to make jar file for " + this.class_name);
			System.exit(1);
		}catch(InterruptedException e){
			System.err.println("Jar maker script interrupted");
			System.exit(1);
		}
	}
	
	public ArrayList<Integer> get_slice_line_nums(String class_name, String method_name, int line_num, String var){
		ArrayList<Integer> line_nums = new ArrayList<Integer>();
		Runtime rt = Runtime.getRuntime();
		Process slicer = null;
		try{
			slicer = rt.exec(new String[]{"get_text_slice.sh", class_name, method_name, Integer.toString(line_num), var});
		}catch(IOException e){
			System.err.println("Failed to create slicer proc");
			System.exit(1);
		}
		
		try{	
			slicer.waitFor();
			InputStreamReader or = new InputStreamReader(slicer.getErrorStream());
			BufferedReader ebr = new BufferedReader(or);
			String e_line = null;
			while((e_line = ebr.readLine()) != null){
				System.err.println(e_line);
			}
		}catch(InterruptedException | IOException e){
			System.err.println("Failed to compute slice");
			System.exit(1);
		}
		InputStreamReader ir = null;
		try {
			ir = new InputStreamReader(new FileInputStream(class_name +".nums"));
		} catch (FileNotFoundException e1) {
			System.out.println("Failed to open file");
		}
		InputStreamReader or = new InputStreamReader(slicer.getErrorStream());
		BufferedReader ebr = new BufferedReader(or);
		BufferedReader br = new BufferedReader(ir);
		String line = null;
		try{
			String e_line = null;
			while((e_line = ebr.readLine()) != null){
				System.err.println(e_line);
			}
			while((line = br.readLine()) != null){
				int ln = Integer.parseInt(line);
				line_nums.add(ln);
			}
		}catch(IOException e){
			System.err.println("Failed to read slicer output");
			System.exit(1);
		}
		return line_nums;
	}
}
