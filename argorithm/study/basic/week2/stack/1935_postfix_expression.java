import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


/**
    1935 후위 표기식
*/
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int round = Integer.parseInt(br.readLine()); // 피연산자 개수
		char[] operation  = br.readLine().toCharArray(); // 후위 표기식

		double nums[] = new double[round];
		for (int i = 0; i < round; i++) { // 피연산자 입력
			nums[i] = Double.parseDouble(br.readLine());
		}

		Stack<Double> stack = new Stack<>();

		for (char ch : operation) { 
			if (ch >= 'A' && ch <= 'Z') { // 피연산자면 스택에 추가
				stack.push(nums[ch - 'A']);

			} else { // 연산자면 스택에서 두 개의 피연산자를 꺼내 연산 후 스택에 추가
				double pop2 = stack.pop();
				double pop1 = stack.pop();

				switch (ch) {
					case '+':
						stack.push(pop1 + pop2);
						break;
					case '-':
						stack.push(pop1 - pop2);
						break;
					case '*':
						stack.push(pop1 * pop2);
						break;
					case '/':
						stack.push(pop1 / pop2);
						break;
				}
			}
		}
		System.out.println(String.format("%.2f", stack.pop()));
    }
}
