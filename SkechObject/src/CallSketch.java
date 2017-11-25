import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CallSketch {
	public CallSketch() {

	}

	static public SketchResult CallByString(String s) throws InterruptedException {

		File dir = new File("tmp");
		dir.mkdirs();
		File tmp = new File(dir, "tmp.txt");
		Runtime rt = Runtime.getRuntime();
		Map<Integer, Integer> result = new HashMap<Integer, Integer>();
		Map<Integer, Integer> oriValue = new HashMap<Integer, Integer>();   // map from coeff to their original value in the original program
		Set<Integer> validList = new HashSet<Integer>();	 
		List<Integer> unchangedIndex = new ArrayList<Integer>();

		try {
			tmp.createNewFile();
			WriteStringToFile(tmp, s);
			String[] envp = new String[] {"PATH=$PATH:/lib"};
			File libdir = new File("./lib");
			Process proc = rt.exec("./sketch ../tmp/tmp.txt",null, libdir);
			// InputStream stderr = proc.getErrorStream();
			// InputStreamReader isr = new InputStreamReader(stderr);
			// BufferedReader br = new BufferedReader(isr);
			InputStreamReader ir = new InputStreamReader(proc.getInputStream());
			LineNumberReader input = new LineNumberReader(ir);

			String line = null;
			line = input.readLine();
			System.out.println(line);

			int coeffIndex = -1;
			int coeffReturn = -1;
			int checkIndex = -1;
			boolean waitting = false;
			boolean checking = false;
			int tmp_return = -1;
			Map<Integer, Integer> tagToValue = new HashMap<>();
			List<Integer> changedConsts = new ArrayList<>();

			if (line == null) {

			} else {
				while ((line = input.readLine()) != null) {
					//System.out.println(new LineNumberReader(new InputStreamReader(proc.getErrorStream())).readLine());
					System.out.println(line);
					// the following 4 if statment is use to extract the original value and the guess
					// value of a coeffX
					// it will be the original val if coeffXchange == 0, and the guess val otherwise
					if (line.length() > 12) {
						if (line.substring(0, 10).equals("void Coeff")) { // determine X 
							coeffIndex = extractInt(line).get(0); // coeffIndex = X
							validList.add(coeffIndex); // assume X is valid
							waitting = true; // waiting for oriVal and guessVal of coeffX
						}
					}
					if (line.length() >= 10)
						if (waitting && line.substring(4, 10).equals("return")) {
							oriValue.put(coeffIndex, tmp_return); // oriVal of coeffX
						}
					if (line.length() >= 8)
						if (waitting && line.substring(2, 8).equals("return")) {
							coeffReturn = tmp_return; // guessVal of coeffX
							waitting = false; // stoping waiting
							result.put(coeffIndex, coeffReturn);
						}
					if (extractInt(line).size() > 0)
						tmp_return = extractInt(line).get(0); // note that the last _out is the actual guessVal so we store
										      // each _out we have seen until we hit return (which happen at line 68)
					
					// Then we scan and find all X such that coeffXchange == 1
					if (line.length() > 25)
						if (line.substring(5, 19).equals("glblInit_coeff")) {
							checkIndex = extractInt(line).get(0); // get X
							checking = true;
							continue;
						}
					if (checking) {
						if (extractInt(line).size() > 0)
							// if a coeffXchange == 0, we say its invalid and don't need them appear in the result
							if (extractInt(line).get(extractInt(line).size() - 1) == 0 && line.substring(2,7).equals("coeff")) {
								unchangedIndex.add(checkIndex);
								checking = false;
								continue;
							}
					}
					
					// extract the total weight
					if (line.length() > 10) {
						if (line.substring(0, 5).equals("Total"))
							break;
					}

				}
				
				for(Integer index: unchangedIndex){
					result.remove(index);
					validList.remove(index);
					if (oriValue.containsKey(index))
						result.put(index, oriValue.get(index));}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new SketchResult(result,validList);
	}

	static void WriteStringToFile(File f, String s) throws IOException {
		FileWriter fileWriter = new FileWriter(f);
		fileWriter.write(s);
		fileWriter.close();
	}

	static List<Integer> extractInt(String str) {
		if (str.length() < 3)
			return new ArrayList<>();
		str = str.replaceAll("[^-?0-9]+", " ");
		List<String> lstr = Arrays.asList(str.trim().split(" "));
		List<Integer> lint = new ArrayList<Integer>();
		if (lstr.size() == 0)
			return lint;
		for (String s : lstr) {
			if (s.length() == 0 || s.length() > 5 || s.equals("-"))
				continue;
			lint.add(Integer.parseInt(s));
		}
		return (lint);
	}

}
