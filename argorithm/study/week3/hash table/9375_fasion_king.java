import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
    9375 패션왕 신해빈
    옷을 입는 경우의 수(알몸 제외)를 구하는 문제
*/
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine()); // 테스트 케이스의 수

		StringBuilder sb = new StringBuilder(); 
		for (int i = 0; i < cases; i++) {
			int clothes = Integer.parseInt(br.readLine()); // 옷의 수
			Map<String, Integer> map = new HashMap<>(); // 옷의 종류와 개수를 저장할 맵
			for (int j = 0; j < clothes; j++) {
				String[] clothInfo = br.readLine().split(" "); // 옷의 이름과 종류
				// 옷의 종류를 키로, 개수를 값으로 저장
				map.put(clothInfo[1], map.getOrDefault(clothInfo[1], 0) + 1); 
			}

			int result = 1; // 경우의 수
			for (int j : map.values()) { 
				result *= j + 1; 
				// 각 옷의 종류의 개수에 1을 더한 값을 곱함
				// 1: 옷을 입지 않는 경우
			}
			sb.append(result - 1).append("\n");
			// - 1: 알몸인 경우를 제외
		}
		System.out.println(sb);
	}
}