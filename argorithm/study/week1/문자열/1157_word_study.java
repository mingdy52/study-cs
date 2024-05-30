import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
	1157 단어에서 가장 많이 사용된 알파벳을 출력하는 문제
*/
class Main {
    public static void main(String[] args) {
		Scanner s = new Scanner(System.in); 
		String word = s.nextLine().toUpperCase();
		char result = resultProcess(word);
		System.out.print(result);
		s.close();
    }
    
	public static char resultProcess(String word) {
		Map<Character, Integer> map = new HashMap<>();

		int max = 0; // 가장 많이 나타나는 문자의 빈도수
		char result = '?'; 

		for (int i = 0; i < word.length(); i++) {
			char alphabet = word.charAt(i);
			map.put(alphabet, map.getOrDefault(alphabet, 0) + 1); // key에 해당하는 value를 반환하고, 없으면 기본값을 반환
		}

		for (Map.Entry<Character, Integer> entry : map.entrySet()) { 
			if (entry.getValue() > max) { // value값과 max값 비교
				max = entry.getValue();
				result = entry.getKey();
			} else if (entry.getValue() == max) { // value값이 max값과 같다면 '?' 저장
				result = '?';
			}
		}

		return result;
	}

	// 시간복잡도: O(n)
	// 1. 첫 번째 for 루프에서 문자열의 모든 문자를 순회. 문자열의 길이에 비례하므로 O(n)
	// 2. 두 번째 for 루프에서 map의 모든 entry를 순회. map의 크기에 비례하므로 O(n)
}
