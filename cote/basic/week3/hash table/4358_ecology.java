import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
	4358 생태학
*/
class Main {
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tree; // 나무 이름
		Map<String, Integer> map = new HashMap<>(); // 나무 이름과 개수를 저장할 맵

		int total = 0;
		while((tree = br.readLine()) != null && !tree.isEmpty()) {
			map.put(tree, map.getOrDefault(tree, 0) + 1); // 나무 이름과 개수를 저장
			total++; // 총 나무의 개수 증가
		}

		List<String> list = new ArrayList<>(map.keySet()); // 나무 이름을 저장할 리스트
		Collections.sort(list); // 나무 이름을 사전순으로 정렬

		StringBuilder result = new StringBuilder();
		for (String treee : list) {
			double cnt = map.get(treee); // 나무의 개수
			double ratio = (cnt / total) * 100; // 비율 계산
			result.append(treee + " " + String.format("%.4f", ratio) + "\n");
		}
		System.out.println(result);
	}
}