import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
    1940 주몽 갑옷 만들기
    갑옷을 만드려면 재료 2개를 합쳐야 한다.
    재료가 주어졌을 때, 갑옷을 만들 수 있는 개수를 구하라.
    
    정렬과 투포인터를 이용
*/
class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 재료의 개수
		int m = Integer.parseInt(br.readLine()); // 갑올을 만들기 위한 수
		String[] resource = br.readLine().split(" "); // 재료

		int[] list = new int[n];
		for (int i = 0; i < n; i++) {
            // 재료를 int로 변환해서 list에 저장
			list[i] = Integer.parseInt(resource[i]); 
		}

		Arrays.sort(list); // 오름차순 정렬

		int left = 0;
		int right = n - 1;
		int result = 0;

		while(left < right) {
            // 두 재료의 합
			int sum = list[left] + list[right];

			if(sum == m) { // 재료의 합과 갑옷을 만들기 위한 수가 같다면
				result++;
				left++; // 왼쪽 포인터를 오른쪽으로 이동
				right --; // 오른쪽 포인터를 왼쪽으로 이동
			} else if(sum < m) { // 재료의 합이 갑옷을 만들기 위한 수보다 작다면
				left++; // 더 큰 수를 만들기 위해 왼쪽 포인터를 오른쪽으로 이동
			} else { // 재료의 합이 갑옷을 만들기 위한 수보다 크다면
				right --; // 더 작은 수를 만들기 위해 오른쪽 포인터를 왼쪽으로 이동
			}
		}

		System.out.println(result);
	}
}