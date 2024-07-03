import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
    2164 카드2
	맨 마지막에 버려지는 카드 번호를 구하는 문제
	ex) 1234 -> 234 -> 342 ...
*/
class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		Queue<Integer> queue = new LinkedList<>(); 
		for (int i = 1; i <= n; i++) { // 1부터 n까지 큐에 추가
			queue.add(i);
		}

		while(queue.size() > 1) { // 큐의 카드가 1장이 될 때까지
			queue.poll(); // 맨 위의 카드를 버림
			queue.add(queue.poll()); // 그 다음 카드를 맨 아래로 옮김
		}
		System.out.println(queue.poll());
	}
}
