import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

/**
	17413 단어 뒤집기
    '<>' 사이 단어 제외
    ' ' 단위로 단어 뒤집기
*/
class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();

		char[] charArray = s.toCharArray();
		String result = reverse(charArray);
		System.out.println(result);

	}
	
	public static String reverse(char[] charArray) {
		StringBuilder result = new StringBuilder(); // 결과 문자열
		Stack<Character> stack = new Stack<>(); // 문자열을 담을 스택
		boolean tag = false; // 태그 여부

		for (char c : charArray) {
			if(c == '<') {
				tag = true;
				while(!stack.isEmpty()) { // 태그 시작 전까지 스택에 담긴 문자열 뒤집기
					result.append(stack.pop());
				}
			}

			if(tag) {
				result.append(c); // 태그가 있으면 그대로 출력
			} else {
				if(c == ' ') {
					while(!stack.isEmpty()) { // 공백이 나오면 스택에 담긴 문자열 뒤집기
						result.append(stack.pop());
					}
					result.append(c); // 공백 추가
				} else {
					stack.push(c); // 스택에 문자 추가
				}
			}

			if(c == '>') { // 태그가 끝나면 태그 여부 false
				tag = false;
			}


		}

		while(!stack.isEmpty()) { // 스택에 남은 문자열 뒤집기
			result.append(stack.pop());
		}
		
		return result.toString();
    }

    // 시간 복잡도: O(n)
    // n: 문자열의 길이. 
    // 주어진 문자열을 한 번씩 순회하면서 각 문자를 PUSH, POP하는 연산을 수행하기 때문에 상수 기간이 걸림.
}