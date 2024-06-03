import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
	9012 괄호(VPS) 판단
*/
class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
		int round = Integer.parseInt(br.readLine());
		StringBuilder result = new StringBuilder();
		
		for (int i =0; i < round; i++) {
			String parenthesis = br.readLine();
			result.append(isVps(parenthesis));
		}

		System.out.print(result.toString());

	}
	
	public static String isVps(String parenthesis) {
		Stack<Character> stack = new Stack<>(); // 괄호를 담을 스택

		for (char c : parenthesis.toCharArray()) { 
			if(c == '(') { // 여는 괄호면 스택에 추가
				stack.push(c);
			} else if(c == ')') { // 닫는 괄호면 스택에서 제거
				if(stack.isEmpty()) { // 스택이 비어있으면 올바르지 않은 괄호
					return "NO\n"; 
				}
				stack.pop();
			}
		}
		
		return stack.isEmpty() ? "YES\n" : "NO\n"; // 스택이 비어있으면 올바른 괄호

	}
		
	} 
}