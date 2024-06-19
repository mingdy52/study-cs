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

		Map<String, Integer> map1 = new HashMap<>();
		String[] pocketmonArr = new String[n];
		int idx = 1; // 포켓몬 번호
		for (int i = 0; i < n; i++) {
			String pocketmon = br.readLine();
			map1.put(pocketmon, idx);
			pocketmonArr[i] = pocketmon;
			idx++;
		}

		StringBuilder result = new StringBuilder();
		for (int i = 0; i < m; i++) {
			String q = br.readLine(); // 문제
			int number = isNumber(q); // 숫자인지 확인

			if(number >= 0) {
				// 숫자인 경우 pocketmonArr에서 찾음
				result.append(pocketmonArr[number - 1] + "\n");
			} else {
				// 문자인 경우 map1에서 찾음
				result.append(map1.get(q) + "\n");
			}

		}

		System.out.println(result);
	}

	public static int isNumber(String q) {
		try {
			return Integer.parseInt(q);
		} catch (NumberFormatException  e) { // 숫자로 변환할 수 없는 경우
			return -1;
		}
	}
}