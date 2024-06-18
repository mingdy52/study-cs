import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
    14916 거스름돈
	거스름돈을 2원, 5원으로만 줄 수 있을 때, 거슬러줄 수 있는 최소 동전의 개수를 구하는 문제
	거슬러줄 수 없다면 -1을 출력
*/
class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int change = Integer.parseInt(br.readLine()); // 거스름돈
		int cnt = 0; // 동전의 개수

		// 거스름돈이 0보다 크거나 같을 때까지 반복
		// 특정 금액에 대해 최적의 해를 찾지 못할 수 있음. ex) 1원, 3원
		while(change >= 0) { 
			if(change % 5 == 0) { // 5로 나누어 떨어지면
				cnt += change / 5; // 5로 나눈 몫을 동전의 개수에 더하고
				System.out.println(cnt); 
				return; // 종료
			}

			change -= 2;  // 5로 나누어 떨어지지 않으면 2원을 빼고
			cnt++; // 동전의 개수를 1 증가
		}

		System.out.println(-1);
	}
}