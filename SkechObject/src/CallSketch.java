import java.io.*;



public class CallSketch {
	public CallSketch(){
		
	}
	
	static public String CallByString(String s) throws InterruptedException{

		File dir = new File("tmp");
		dir.mkdirs();
		File tmp = new File(dir, "tmp.txt");
		Runtime rt = Runtime.getRuntime();  
        String result = "";
		try {
			tmp.createNewFile();
			WriteStringToFile(tmp,s);
            Process proc = rt.exec(new String[]{"lib/sketch","tmp/tmp.txt"});  
            InputStream stderr = proc.getErrorStream();  
            InputStreamReader isr = new InputStreamReader(stderr);  
            BufferedReader br = new BufferedReader(isr);  
            InputStreamReader ir=new InputStreamReader(proc.getInputStream());
            LineNumberReader input = new LineNumberReader (ir);

            String line = null;  
            line = input.readLine();
            if(line == null){
            	return "<error>";
            }else {            	
            	result = result + line + "\n";
            while ((line = input.readLine ()) != null)
            	result = result + line + "\n";
            }
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	static void WriteStringToFile(File f, String s) throws IOException{
		FileWriter fileWriter = new FileWriter(f);
		fileWriter.write(s);
		fileWriter.close();
	}

}