import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
/**
    1758 알바생 강호
	손님 순서를 정렬하고 팁을 받을 수 있는 최대 금액을 구하는 문제
*/
class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 손님의 수

		Integer[] list = new Integer[n];
		for (int i = 0; i < n; i++) {
			// 손님이 생각하는 팁을 list에 저장
			list[i] = (Integer.parseInt(br.readLine()));
		}

		// 팁 최대 금액을 구하기 위해 내림차순으로 정렬
		Arrays.sort(list, Collections.reverseOrder());

		long sum = 0;
		for (int i = 0; i < n; i++) {
			int tip = list[i] - (i);
			// 팁이 0보다 크다면 팁을 받고, 아니라면 0을 받음
			sum += Math.max(tip, 0);
		}

		System.out.println(sum);
	}
}