import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int round = Integer.parseInt(br.readLine());

		for (int i = 0; i < round; i++) {
			String[] docInfo = br.readLine().split(" ");
			String[] priorities = br.readLine().split(" ");
			int target = Integer.parseInt(docInfo[1]);

			Queue<Document> queue = new LinkedList<>();

			for (int j = 0; j < priorities.length; j++) { // 문서의 중요도와 문서 인덱스를 큐에 추가
				int priority = Integer.parseInt(priorities[j]);
				queue.add(new Document(priority, j));
			}

			int count = 0;
			while(!queue.isEmpty()) {
				Document current = queue.poll(); // 큐에서 문서를 꺼냄
				boolean flag = true; // 현재 문서를 출력할지 말지 결정하는 flag

				for (Document doc : queue) { // 큐에 남아있는 문서들의 중요도와 비교
					if(current.priority < doc.priority) { // 현재 문서의 중요도보다 큐에 남아있는 문서의 중요도가 높으면
						queue.add(current); // 현재 문서를 큐의 맨 뒤로 보냄
						flag = false; // flag를 false로 변경
						break;
					}
				}

				if(flag) {
					count++; // 출력한 문서의 수 증가
					if(target == current.index) { // 출력한 문서가 찾고자 하는 문서라면
						System.out.println(count); // 출력한 문서의 수 출력
						break;
					}
				}
			}
		}
	}
}

class Document {
	int priority;
	int index;

	public Document(int priority, int index) {
		this.priority = priority;
		this.index = index;
	}

}
