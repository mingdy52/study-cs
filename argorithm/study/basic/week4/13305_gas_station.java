import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
    13305 A에서 Z까지 가는 최소 비용
*/
class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 마을 수

		String[] s1 = br.readLine().split(" "); // 마을 간 거리
		long[] distance = solution(n-1, s1);

		String[] s2 = br.readLine().split(" "); // 기름 가격
		long[] price = solution(n, s2);

		long minCost = 0; // 최소 비용
		long currentPrice = price[0]; // 현재 비용
		for (int i = 0; i < n-1; i++) {
            // 비용 = 기름 가격 * 마을 사이 거리
			minCost += currentPrice * distance[i];

            // 다음 마을 주유소 가격이 더 쌀 때
			if(price[i + 1] < currentPrice) {
                // 다음 마을에서 주유 
				currentPrice = price[i + 1];
			}
		}

		System.out.println(minCost);
	}

	public static long[] solution(int n, String[] sArr) {
		long[] arr = new long[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(sArr[i]);
		}
		return arr;
	}
}