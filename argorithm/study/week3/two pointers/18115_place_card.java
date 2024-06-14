import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
    18115 카드 놓기
    1. 제일 위의 카드 1장을 바닥에 내려놓는다.
    2. 위에서 두 번째 카드를 바닥에 내려놓는다.
    3. 제일 밑에 있는 카드를 바닥에 내려놓는다.
*/
class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int input = Integer.parseInt(br.readLine());
		String[] actions = br.readLine().split(" "); // 행동 번호 배역

		int card = 1; //카드 번호
		LinkedList<Integer> arr = new LinkedList<>(); 
		for (int i = input; i > 0 ; i--) {
			int action = Integer.parseInt(actions[i - 1]); // 행동 번호 뒤에서부터
			
			switch (action) {
				case 1: 
					arr.addFirst(card); // 맨 위에 카드를 추가
					break;
				case 2:
					if(!arr.isEmpty()) { 
						arr.add(1, card); // 두 번째에 카드를 추가
					} else { 
						arr.addFirst(card); // 맨 위에 카드가 없으면 맨 위에 카드를 추가
					}
					break;
				case 3:
					arr.addLast(card); // 맨 아래에 카드를 추가
					break;
			}
			card++;
		}

		StringBuilder result = new StringBuilder();
		for (Integer i : arr) {
			result.append(i + " ");
		}

		System.out.println(result);
	}
}