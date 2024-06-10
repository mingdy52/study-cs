import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
    18258 큐 연습

	push X: 정수 X를 큐에 넣는 연산이다.
	pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	size: 큐에 들어있는 정수의 개수를 출력한다.
	empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
	front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
*/
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Queue<Integer> queue = new LinkedList<>(); 
        // LinkedList는 Queue 인터페이스를 구현하고 있기 때문에 Queue로 선언 가능

		int round = Integer.parseInt(br.readLine());
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < round; i++) {
			String[] split = br.readLine().split(" "); // 공백으로 구분

			switch (split[0]) {
				case "push": 
					queue.add(Integer.valueOf(split[1])); // add()와 offer()는 같은 기능
					break;
				case "pop":
					result.append(queue.isEmpty() ? "-1\n" : queue.poll() + "\n"); // poll()과 remove()는 같은 기능
					break;
				case "size":
					result.append(queue.size() + "\n"); 
					break;
				case "empty":
					result.append(queue.isEmpty() ? "1\n" : "0\n");
					break;
				case "front":
					result.append(queue.isEmpty() ? "-1\n" : queue.peek() + "\n"); // peek()과 element()는 같은 기능
					break;
				case "back":
                    // LinkedList의 마지막 요소를 가져오기 위해 LinkedList로 형변환
                    // Queue에는 getLast() 메소드가 없기 때문에 LinkedList로 형변환 후 사용
					result.append(queue.isEmpty() ? "-1\n" : ((LinkedList<Integer>) queue).getLast() + "\n");
					break;
			}
		}
		System.out.println(result);
    }
}