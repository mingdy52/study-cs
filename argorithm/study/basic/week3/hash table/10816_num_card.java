import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
    10816 숫자 카드 2
	카드에 적힌 숫자의 개수를 구하는 문제
*/
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String n = br.readLine(); // 카드의 개수
		String[] cards = br.readLine().split(" "); // 카드에 적힌 숫자

		Map<String, Integer> map = new HashMap<>(); // 카드의 숫자와 개수를 저장할 맵
		for (String card : cards) {
			map.put(card, map.getOrDefault(card, 0) +1); // 카드의 숫자를 키로, 개수를 값으로 저장
		}

		String m = br.readLine();
		String[] keys = br.readLine().split(" "); // 찾고자 하는 숫자
		StringBuilder result = new StringBuilder(); 
		for (String key : keys) {
			if(map.containsKey(key)) { // 숫자가 맵에 존재하면
				result.append(map.get(key) + " "); // 해당 숫자의 개수를 결과에 추가
			} else {
				result.append("0 "); // 숫자가 맵에 존재하지 않으면 0을 결과에 추가
			}
		}
		System.out.println(result.toString().trim());
	}
}