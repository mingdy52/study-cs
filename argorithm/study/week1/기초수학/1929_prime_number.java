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

		boolean[] isPrime = new boolean[n + 1];

		for(int i = 2; i <= n; i++) {
			isPrime[i] = true;
		}

		for(int p = 2; p * p <= n; p++) {
			if(isPrime[p]) {
				for(int j = p *p; j <= n; j += p) {
					isPrime[j] = false;
				}
			}
		}

		for(int i = m; i <= n; i++) {
			if(isPrime[i]) {
				System.out.println(i);
			}
		}
    }
}