import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
    18258 큐 연습
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