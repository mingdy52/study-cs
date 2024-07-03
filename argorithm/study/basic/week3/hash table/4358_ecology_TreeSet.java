import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
	4358 생태학
*/
class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tree;
		Map<String, Integer> map = new HashMap<>();
		TreeSet<String> set = new TreeSet<>();

		int total = 0;
		while((tree = br.readLine()) != null && !tree.isEmpty()) {
			map.put(tree, map.getOrDefault(tree, 0) + 1);
			set.add(tree);
			total++;
		}


		StringBuilder result = new StringBuilder();
		for (String treee : set) {
			double cnt = map.get(treee);
			double ratio = (cnt / total) * 100;
			result.append(treee + " " + String.format("%.4f", ratio) + "\n");
		}
		System.out.println(result);
	}
}