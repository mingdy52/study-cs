import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
    11047 동전 0
    동전의 종류와 구할 값이 주어졌을 때, 동전의 최소 개수를 구하는 문제
*/
class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] q = br.readLine().split(" ");
		int n = Integer.parseInt(q[0]); // 동전의 종류 개수
		int k = Integer.parseInt(q[1]); // 구할 값

		int[] coins = new int[n];
		for (int i = n-1; i >= 0; i--) {
            // 동전의 종류를 int로 변환해서 coins에 저장
            // 편의상 내림차순으로 저장
			coins[i] = Integer.parseInt(br.readLine());
		}

		int remain = k; // 남은 값
		int cnt = 0; // 동전의 개수
		int idx = 0;
		while (remain != 0) { // 남은 값이 0이 아니라면 반복
            
			if(coins[idx] > remain) {
                // 동전의 종류가 남은 값보다 크다면 다음 동전으로 넘어감
				idx++;
				continue;
			}

            // 남은 값에서 동전의 종류를 나눈 몫을 동전의 개수에 더하고, 나머지를 남은 값으로 저장
			cnt += remain / coins[idx];
			remain %= coins[idx];
		}

		System.out.println(cnt);
	}
}