import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int round = Integer.parseInt(br.readLine());
		int sequence[] = new int[round]; // 수열을 담을 배열

		for (int i = 0; i < round; i++) {
			sequence[i] = Integer.parseInt(br.readLine()); // 수열 입력
		}

		Stack<Integer> stack = new Stack<>();
		StringBuilder result = new StringBuilder();
		int current = 1;

		for (int i = 0; i < round; i++) {
			int target = sequence[i]; // 수열의 i번째 요소를 target으로 지정

			while(current <= target) { // current가 target보다 작거나 같을 때까지
				stack.push(current); // 스택에 current 추가
				result.append("+\n"); // 결과에 + 추가
				current++;
			}

			if(stack.peek() == target) { // 스택의 최상단 요소가 target과 같으면
				stack.pop(); // 스택에서 제거
				result.append("-\n"); // 결과에 - 추가
			} else {
				System.out.println("NO"); // 스택의 최상단 요소가 target과 다르면 NO 출력
				return;
			}

		}
		System.out.println(result);
    }
}