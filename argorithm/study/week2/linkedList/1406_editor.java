import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

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
		String message  = br.readLine();
		int round  = Integer.parseInt(br.readLine());

		LinkedList<Character> list = new LinkedList<>(); 
		for (char c : message.toCharArray()) { // 문자열을 문자로 하나씩 쪼개서 리스트에 추가
			list.add(c);
		}

		ListIterator<Character> iterator = list.listIterator(list.size()); // 리스트의 마지막 인덱스로 이동

		for (int i = 0; i < round; i++) {
			String commands  = br.readLine(); // 명령어 입력

			switch (commands.charAt(0)) { // 명령어에 따라서
				case 'L':
					if (iterator.hasPrevious()) { 
						iterator.previous(); // 이전 인덱스로 이동
					}
					break;
				case 'D':
					if (iterator.hasNext()) {
						iterator.next(); // 다음 인덱스로 이동
					}
					break;
				case 'B':
					if (iterator.hasPrevious()) {
						iterator.previous(); // 이전 인덱스로 이동
						iterator.remove(); // 해당 인덱스 삭제
					}
					break;
				case 'P':
					iterator.add(commands.charAt(2)); // 해당 인덱스에 문자 추가
					break;
			} 
		}

		StringBuilder result = new StringBuilder();
		for (char ch : list) {
			result.append(ch);
		}

		System.out.print(result);
	}
}

// 시간 복잡도: O(N + M)
// N: 문자열의 길이, M:     