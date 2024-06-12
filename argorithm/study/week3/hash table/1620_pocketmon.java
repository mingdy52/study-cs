import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
    1620 포켓몬 번호 또는 이름을 구하는 문제
*/
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]); // 포켓몬의 수
		int m = Integer.parseInt(s[1]); // 문제의 수

		Map<Integer, String> map1 = new HashMap<>(); 
		Map<String, Integer> map2 = new HashMap<>();
		int idx = 1; // 포켓몬 번호
		for (int i = 0; i < n; i++) {
			String pocketmon = br.readLine();
			map1.put(idx, pocketmon);
			map2.put(pocketmon, idx);
			idx++;
		}

		StringBuilder result = new StringBuilder();
		for (int i = 0; i < m; i++) {
			String q = br.readLine(); // 문제
			boolean number = isNumber(q); // 숫자인지 확인

			if(number) {
                // 숫자인 경우 int로 변환하여 map1에서 찾음
				result.append(map1.get(Integer.parseInt(q))).append("\n");
			} else {
                // 문자인 경우 map2에서 찾음
				result.append(map2.get(q)).append("\n");
			}

		}

		System.out.println(result);
	}

	public static boolean isNumber(String q) {
		try {
			Integer.parseInt(q); 
			return true;
		} catch (NumberFormatException  e) { // 숫자로 변환할 수 없는 경우
			return false; // false
		}
	}
}