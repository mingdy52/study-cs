import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] qInfo = br.readLine().split(" ");
		int n = Integer.parseInt(qInfo[0]);
		int m = Integer.parseInt(qInfo[1]);

		Map<String, List<String>> teamToMems = new HashMap<>();
		Map<String, String> MemToTeam = new HashMap<>();
		for (int i = 0; i < n; i++) {
			String group = br.readLine();
			int memCnt = Integer.parseInt(br.readLine());
			List<String> names = new ArrayList<>();
			for (int j = 0; j < memCnt; j++) {
				String name = br.readLine();
				names.add(name);
				MemToTeam.put(name, group);
			}
			Collections.sort(names);
			teamToMems.put(group, names);

		}

		StringBuilder result = new StringBuilder();
		for (int i = 0; i < m; i++) {
			String question = br.readLine();
			int qType = Integer.parseInt(br.readLine());
			if(qType > 0) {
				result.append(MemToTeam.get(question) + "\n");
			} else {
				List<String> strings = teamToMems.get(question);
				for (String string : strings) {
					result.append(string + "\n");
				}
			}
		}
		System.out.println(result);
	}
}
