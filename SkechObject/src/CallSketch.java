import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CallSketch {
	public CallSketch() {

	}

	static public Map<Integer, Integer> CallByString(String s) throws InterruptedException {

		File dir = new File("tmp");
		dir.mkdirs();
		File tmp = new File(dir, "tmp.txt");
		Runtime rt = Runtime.getRuntime();
		Map<Integer, Integer> result = new HashMap<Integer, Integer>();
		try {
			tmp.createNewFile();
			WriteStringToFile(tmp, s);
			Process proc = rt.exec(new String[] { "lib/sketch", "tmp/tmp.txt" });
			//InputStream stderr = proc.getErrorStream();
			//InputStreamReader isr = new InputStreamReader(stderr);
			//BufferedReader br = new BufferedReader(isr);
			InputStreamReader ir = new InputStreamReader(proc.getInputStream());
			LineNumberReader input = new LineNumberReader(ir);

			String line = null;
			line = input.readLine();

			int tag_ConstFun = -1;
			int cd_ConstFun = -1;
			int tag_ChangedConst = -1;
			int cd_ChangedConst = -1;
			Map<Integer, Integer> tagToValue = new HashMap<>();
			List<Integer> changedConsts = new ArrayList<>();

			if (line == null) {

			} else {
				while ((line = input.readLine()) != null) {
					int value_ConstFun = 0;
					if (line.length() > 12)
						if (line.substring(5, 10).equals("Const")) {
							tag_ConstFun = extractInt(line).get(0);
							cd_ConstFun = 5;
						}

					if (cd_ConstFun == 0) {
						value_ConstFun = extractInt(line).get(0);
						tagToValue.put(tag_ConstFun, value_ConstFun);
						tag_ConstFun = -1;
					}

					if (line.length() > 25)
						if (line.substring(5, 19).equals("glblInit_const")) {
							tag_ChangedConst = extractInt(line).get(0);
							cd_ChangedConst = 2;
						}
					if (cd_ChangedConst == 0) {
						if (extractInt(line).get(2) == 1)
							changedConsts.add(tag_ChangedConst);
					}

					cd_ChangedConst--;
					cd_ConstFun--;
				}
				for (int i : changedConsts) {
					result.put(i + 1, tagToValue.get(i));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	static void WriteStringToFile(File f, String s) throws IOException {
		FileWriter fileWriter = new FileWriter(f);
		fileWriter.write(s);
		fileWriter.close();
	}

	static List<Integer> extractInt(String str) {

		str = str.replaceAll("[^-?0-9]+", " ");
		List<String> lstr = Arrays.asList(str.trim().split(" "));
		List<Integer> lint = new ArrayList<Integer>();
		for (String s : lstr) {
			lint.add(Integer.parseInt(s));
		}
		return (lint);
	}

}