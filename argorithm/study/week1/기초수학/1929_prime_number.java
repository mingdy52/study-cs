import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num = br.readLine();
		String[] nums = num.split(" ");

		int m = Integer.parseInt(nums[0]);
		int n = Integer.parseInt(nums[1]);

        // 에라토스테네스의 체
        // 1. 2부터 n까지의 모든 숫자를 나열
        // 2. 2: 소수. 리스트에 추가하고, 2의 배수를 삭제
        // 3. 3: 다음 소수. 3을 리스트에 추가하고, 3의 배수를 삭제
        // 반복하면 소수만 남게 됨

		boolean[] isPrime = isPrime(n);
        primeProcess(isPrime, n);
		for(int i = m; i <= n; i++) {
			if(isPrime[i]) {
				System.out.println(i);
			}
		}
    }

    public static boolean[] isPrime(int n) {
        boolean[] isPrime = new boolean[n + 1]; // 인덱스를 편하게 하기 위해 n + 1로 설정
		for(int i = 2; i <= n; i++) { // 0, 1 은 소수가 아니니까 2부터 시작
			isPrime[i] = true; // 일단 모두 소수라고 가정
		}
        return isPrime;
    }
    
    public static void primeProcess(boolean[] isPrime, int n) {
		for(int p = 2; p * p <= n; p++) { // p의 배수가 n보다 작거나 같을 때까지
			if(isPrime[p]) {
				for(int j = p * p; j <= n; j += p) { //p의 배수를 제거
					isPrime[j] = false;
				}
			}
		}
    }
}