import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
    1158 josephus problem
*/
class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		int n = Integer.parseInt(input.split(" ")[0]); // 사람의 수
		int k = Integer.parseInt(input.split(" ")[1]); // 제거할 사람의 순서

		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			queue.add(i); // 1부터 n까지의 사람을 큐에 추가
		}

		StringBuilder result = new StringBuilder(); 
		result.append("<");


		while(!queue.isEmpty()) {
			for (int i = 1; i <= k - 1; i++) { // k-1번째까지의 사람을 뒤로 보내기
				queue.add(queue.poll());
			}

			result.append(queue.poll()); // k번째 사람을 제거
			if(!queue.isEmpty()) { // 큐가 비어있지 않으면
				result.append( ", "); // 쉼표 추가
			}

		}
		result.append(">");
		System.out.println(result);
	}
}