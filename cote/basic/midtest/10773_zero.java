import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
    10773 제로
*/
class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int round = Integer.parseInt(br.readLine());

		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < round; i++) {
			int num = Integer.parseInt(br.readLine());

			if (num > 0) { // 0보다 큰 경우
				stack.push(num); // 스택에 추가
			} else if(num == 0) { // 0인 경우
				stack.pop(); // 최근에 쓴 수를 지움
			}
		}

		int sum = 0;
		for (Integer i : stack) {
			sum += i; // 스택에 있는 수를 모두 더함
		}
		System.out.println(sum);
	}
}


