import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Stack;

/**
    1406 에디터
    L	| 커서를 왼쪽으로 한 칸 옮김 (커서가 문장의 맨 앞이면 무시됨)
    D	| 커서를 오른쪽으로 한 칸 옮김 (커서가 문장의 맨 뒤이면 무시됨)
    B	| 커서 왼쪽에 있는 문자를 삭제함 (커서가 문장의 맨 앞이면 무시됨)
           삭제로 인해 커서는 한 칸 왼쪽으로 이동한 것처럼 나타나지만, 실제로 커서의 오른쪽에 있던 문자는 그대로임
    P $	| $라는 문자를 커서 왼쪽에 추가함
*/
class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String initialString = br.readLine();
        int m = Integer.parseInt(br.readLine());
        
        Stack<Character> leftStack = new Stack<>(); // 커서 왼쪽에 있는 문자들을 저장
        Stack<Character> rightStack = new Stack<>(); // 커서 오른쪽에 있는 문자들을 저장
        
        for (char ch : initialString.toCharArray()) {
            leftStack.push(ch); // 우선 문자열을 왼쪽 스택에 추가
        }
        
        for (int i = 0; i < m; i++) {
            String command = br.readLine();
            
            switch (command.charAt(0)) {
                case 'L': 
                    if (!leftStack.isEmpty()) { // 왼쪽 스택이 비어있지 않다면
                        rightStack.push(leftStack.pop()); // 왼쪽 스택의 가장 위에 있는 문자를 오른쪽 스택으로 이동
                    }
                    break;
                case 'D':
                    if (!rightStack.isEmpty()) { // 오른쪽 스택이 비어있지 않다면
                        leftStack.push(rightStack.pop()); // 오른쪽 스택의 가장 위에 있는 문자를 왼쪽 스택으로 이동
                    }
                    break;
                case 'B':
                    if (!leftStack.isEmpty()) { // 왼쪽 스택이 비어있지 않다면
                        leftStack.pop(); // 왼쪽 스택의 가장 위에 있는 문자를 삭제
                    }
                    break;
                case 'P':
                    leftStack.push(command.charAt(2)); // 왼쪽 스택의 가장 위에 문자를 추가
                    break;
            }
        }
        
        StringBuilder result = new StringBuilder();
        for (char ch : leftStack) { // 왼쪽 스택에 있는 문자들을 순서대로 출력
            result.append(ch);
        }
        while (!rightStack.isEmpty()) { // 오른쪽 스택에 있는 문자들을 순서대로 출력
            result.append(rightStack.pop());
        }
        
        System.out.println(result.toString());
    }

}

// 시간 복잡도: O(N + M)
// N: 문자열의 길이, M: 명령어의 개수