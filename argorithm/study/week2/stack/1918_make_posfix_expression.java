import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
    1918 후위 표기식 만들기
*/
class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String operation  = br.readLine();

		StringBuilder result = new StringBuilder();
		Stack<Character> stack = new Stack<>(); // 연산자를 담을 스택
		for (int i = 0; i < operation.length(); i++) { 
			char ch = operation.charAt(i);

			if(Character.isLetter(ch)) {// 피연산자면 결과에 추가
				result.append(ch);

			} else if(ch == '(') { // 여는 괄호면 스택에 추가
				stack.push(ch);

			} else if(ch == ')') { // 닫는 괄호면 여는 괄호가 나올 때까지 스택에서 꺼내 결과에 추가
				while(!stack.isEmpty() && stack.peek() != '(') {
					result.append(stack.pop());
				}
				stack.pop(); // 여는 괄호 제거

			} else if(isOperator(ch)) { // 연산자면 스택에서 우선순위가 높거나 같은 연산자를 꺼내 결과에 추가
				while(!stack.isEmpty() && getPriority(stack.peek()) >= getPriority(ch)) 
					result.append(stack.pop());
				}

				stack.push(ch); // 연산자 스택에 추가
			}

		}

		while (!stack.isEmpty()) { // 스택에 남은 연산자를 결과에 추가
			result.append(stack.pop()); 
		}

		System.out.println(result);


	}
	
	public static int getPriority(char ch) {
		switch (ch) {
			case '*':
			case '/':
				return 2;
			case '+':
			case '-':
				return 1;
			default:
				return 0;
		}
	}

	public static boolean isOperator(char ch) { // 연산자인지 확인
		return ch == '+' || ch == '-' || ch == '*' || ch == '/';
	}

}
