import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
    21921 블로그
    일정 기간 동안의 최대 블로그 방문자 수를 구하는 문제
*/
class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" "); // n: 일수, x: 연속된 일수
		int n = Integer.parseInt(s[0]);
		int x = Integer.parseInt(s[1]);

		String[] visitors = br.readLine().split(" ");
		int[] visitCnt = new int[n]; // 방문자 수
		int sum = 0;
		for (int i = 0; i < n; i++) {
			visitCnt[i] = Integer.parseInt(visitors[i]); // 방문자 수 저장

            // 처음 x일 동안의 방문자 수 합
			if(i < x) {
				sum += visitCnt[i];
			}
		}

		int max = sum, cnt = 1;
		for (int i = x; i < n; i++) {
			int in = visitCnt[i]; // 합에 더할 방문자 수
			int out = visitCnt[i - x]; // 합에서 뺄 방문자 수
			sum = sum - out  + in; 

			if(sum > max) { // sum 값이 max보다 크다면 
				max = sum; // max 값을 sum으로 변경
                cnt = 1; // cnt를 1로 초기화
			} else if (sum == max) { // sum 값이 max와 같다면
				cnt++; // cnt를 1 증가
			}
		}
		
		if(max == 0) {
			System.out.println("SAD");
		} else {
			System.out.println(max);
			System.out.println(cnt);
		}
	}
}