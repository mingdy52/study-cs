import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
    2217 로프로 들 수 있는 최대값 구하기
    k개의 로프를 사용하여 중량이 w인 물체를 들어올릴 때, 각 로프는 w/k 만큼의 중량을 들 수 있음
*/
class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 로프 개수

		int[] rope = new int[n]; // 로프가 들 수 있는 무게들
		for (int i = 0; i < n; i++) {
			rope[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(rope);

		int maxWeight = 0; // 최대값
		for (int i = 0; i < n; i++) {
            // i번째 로프부터 마지막 로프까지 사용할 때의 최대 중량
			int currentWeight = rope[i] * (n - i);
			maxWeight = Math.max(currentWeight, maxWeight);
		}
		System.out.println(maxWeight);
	}
}