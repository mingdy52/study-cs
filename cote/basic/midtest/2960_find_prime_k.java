import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
    2960 k번째로 지워지는 수 찾기
*/
class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]); 
		int target = Integer.parseInt(input[1]); // k번째로 지워지는 수

		boolean[] isPrime = new boolean[n + 1];
		for (int i = 2; i <= n; i++) { // 2부터 n까지 소수로 초기화
			isPrime[i] = true;
		}

		int count = 0; // 지워진 수의 개수
		int result = 0; // k번째로 지워지는 수
		boolean flag = false; // k번째로 지워지는 수를 찾았는지 여부

		for (int p = 2; p <= n; p++) {
			if (isPrime[p]) {
				for (int j = p; j <= n; j += p) {
					if(isPrime[j]) { // 소수인 경우
						count++; // 지워진 수의 개수 증가
						if (target == count) { // k번째로 지워지는 수인 경우
							result = j; // 결과값 저장
							flag = true; // k번째로 지워지는 수를 찾았으므로 flag를 true로 변경
							break;
						}

						isPrime[j] = false; // 소수가 아닌 경우 false로 변경
					}
				}
				if (flag) break;
			}

		}

		System.out.println(result);
	}

}