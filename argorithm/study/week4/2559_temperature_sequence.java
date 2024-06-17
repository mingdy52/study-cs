import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
    2559 수열
    매일 측정한 온도가 정수의 수열로 주어졌을 때, 연속적인 며칠(k) 동안의 온도의 합이 가장 큰 값을 계산
*/
class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nk = br.readLine().split(" ");
		String[] days = br.readLine().split(" ");
		int n = Integer.parseInt(nk[0]); // 측정한 날짜의 수
		int k = Integer.parseInt(nk[1]); // 연속으로 측정할 날짜의 수

		int[] list = new int[n];
		for (int i = 0; i < n; i++) {
            // 측정한 온도를 int로 변환해서 list에 저장
			list[i] = Integer.parseInt(days[i]);
		}

		int sum = 0;
		for (int i = 0; i < k; i++) {
            // k일 동안의 온도의 합
			sum += list[i];
		}

		int max = sum;
		for (int i = k; i < n; i++) {
            // 다음 k일 동안의 온도의 합
            // 이전 k일 동안의 온도의 합에서 첫 번째 날의 온도를 빼고, 다음 날의 온도를 더함
			sum = sum + list[i] - list[i - k];
			if (sum > max) {
				max = sum;
			}
		}

		System.out.println(max);
	}
}