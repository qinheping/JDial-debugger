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
		Map<Integer, Integer> oriValue = new HashMap<Integer, Integer>();
		Set<Integer> validList = new HashSet<Integer>();

		try {
			tmp.createNewFile();
			WriteStringToFile(tmp, s);
			Process proc = rt.exec(new String[] { "lib/sketch", "tmp/tmp.txt" });
			// InputStream stderr = proc.getErrorStream();
			// InputStreamReader isr = new InputStreamReader(stderr);
			// BufferedReader br = new BufferedReader(isr);
			InputStreamReader ir = new InputStreamReader(proc.getInputStream());
			LineNumberReader input = new LineNumberReader(ir);

			String line = null;
			line = input.readLine();

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
					int value_ConstFun = 0;
					if (line.length() > 12) {

						if (line.substring(0, 10).equals("void Coeff")) {

							coeffIndex = extractInt(line).get(0);
							validList.add(coeffIndex);
							waitting = true;
						}
					}

					if (line.length() >= 10)
						if (waitting && line.substring(4, 10).equals("return")) {
							oriValue.put(coeffIndex, tmp_return);
						}

					if (line.length() >= 8)
						if (waitting && line.substring(2, 8).equals("return")) {
							coeffReturn = tmp_return;
							waitting = false;
							result.put(coeffIndex, coeffReturn);
						}
					if (extractInt(line).size() > 0)
						tmp_return = extractInt(line).get(0);

					if (line.length() > 25)
						if (line.substring(5, 19).equals("glblInit_coeff")) {
							checkIndex = extractInt(line).get(0);
							checking = true;
						}
					if (checking) {
						if (extractInt(line).size() > 0)
							if (extractInt(line).get(extractInt(line).size() - 1) == 0) {
								result.remove(checkIndex);
								validList.remove(checkIndex);
								if (oriValue.containsKey(checkIndex))
									result.put(checkIndex, oriValue.get(checkIndex));
								checking = false;
							}
					}
					if (line.length() > 10) {
						if (line.substring(0, 5).equals("Total"))
							break;
					}

				}
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