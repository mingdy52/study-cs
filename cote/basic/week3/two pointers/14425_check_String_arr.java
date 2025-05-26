import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
    14425 문자열 집합에 문자가 포함되어 있는지 확인하기
*/
class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" "); // 집합 크기와 문자열 개수

		int arr = Integer.parseInt(s[0]); // 집합 크기
		Set<String> set = new HashSet<>();
		for (int i = 0; i < arr; i++) {
			set.add(br.readLine()); // set에 집합 문자열 추가
		}

		int result = 0; // 포함되는 문자열 개수
		int cnt = Integer.parseInt(s[1]);
		for (int i = 0; i < cnt; i++) { 
			if(set.contains(br.readLine())) { // set에 포함되어 있는지 확인
				result++; 
			}
		}
		System.out.println(result);
	}
}