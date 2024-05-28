import java.util.HashMap;
import java.util.Scanner;

/**
	9046 암호해독
		암호에서 가장 빈번하게 나타나는 문자를 출력
		알 수 없는 경우 ? 출력
 */
class Main {
    public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int length = readLength(s); // 입력될 문자열의 개수
		s.nextLine(); // 개행문자 제거
		char[] print = new char[length]; // 출력할 문자 배열

		for (int i = 0; i < length; i++) {
			String code = s.nextLine().replaceAll("\\s+", ""); // 입력받은 문자열 공백 제거
			print[i] = processString(code);
		}

		for (char c : print) {
			System.out.println(c);
		}

		s.close();
    }
    
    public static int readLength(Scanner s) {
		return s.nextInt();
	}

	public static char processString(String code) {
		HashMap<Character, Integer> map = new HashMap<>(); // 각 문자와 빈도수를 저장할 맵
		int max = 0; // 가장 많이 나타나는 문자의 빈도수
		char result = '?';

		for (int j = 0; j < code.length(); j++) {
			char ch = code.charAt(j);

			if(map.containsKey(ch)) { // 이미 맵에 존재하는 문자라면 +1, 아니면 1로 초기화
				map.put(ch, map.get(ch) + 1);
			} else {
				map.put(ch, 1);
			}

			if(map.get(ch) > max) { // 가장 많이 나타나는 문자의 빈도수와 문자 저장
				max = map.get(ch);
				result = ch;
			} else if (map.get(ch) == max) {
				result = '?';
			}
		}
        return result;
    }

	// 시간 복잡도: O(m×n)
	// m: 문자열의 개수 
	// n: 각 문자열의 평균 길이
}
