import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
    3986 좋은 단어
*/
class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
		int round = Integer.parseInt(br.readLine());
		int result = 0;
		
		for (int i =0; i < round; i++) {
			String word = br.readLine();
			if (solution(word.toCharArray())) {
				result++;
			}
		}

		System.out.print(result);

	}
	
	public static boolean solution(char[] charArray) { 
		Stack<Character> stack = new Stack<>(); // 문자를 담을 스택
		boolean result = true; // 좋은 단어인지 아닌지 판단
		
		for (char ch : charArray) {
			if(stack.isEmpty() || stack.peek() != ch) { // 스택이 비어있거나 스택 최상단 문자와 다르면 스택에 추가
				stack.push(ch); 
			} else if(stack.peek() == ch) { // 스택 최상단 문자와 같으면 스택에서 제거
				stack.pop();
			}
		}

		if(!stack.isEmpty()) { // 스택이 비어있지 않으면 좋은 단어가 아님
			result = false;
		}
		
		return result;
	}
}