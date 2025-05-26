package practice.week01;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FindNotRepeatingFirstCharacter {
    /**
     문제
        다음과 같이 영어로 되어 있는 문자열이 있을 때, 이 문자열에서 반복되지 않는 첫번째 문자를 반환하시오. 만약 그런 문자가 없다면 _ 를 반환하시오.
     */
    public static void main(String[] args) {
        String str1 = "abadabac";
        String str2 = "aabbcddd";
        String str3 = "aaaaaaaa";

        System.out.println("정답 = d 현재 풀이 값 = " + findNotRepeatingFirstCharacter(str1));
        System.out.println("정답 = c 현재 풀이 값 = " + findNotRepeatingFirstCharacter(str2));
        System.out.println("정답 = _ 현재 풀이 값 = " + findNotRepeatingFirstCharacter(str3));

        System.out.println("정답 = d 현재 풀이 값 = " + linkedFindNotRepeatingFirstCharacter(str1));
        System.out.println("정답 = c 현재 풀이 값 = " + linkedFindNotRepeatingFirstCharacter(str2));
        System.out.println("정답 = _ 현재 풀이 값 = " + linkedFindNotRepeatingFirstCharacter(str3));

        System.out.println("정답 = d 현재 풀이 값 = " + streamFindFirstNonRepeatingChar(str1));
        System.out.println("정답 = c 현재 풀이 값 = " + streamFindFirstNonRepeatingChar(str2));
        System.out.println("정답 = _ 현재 풀이 값 = " + streamFindFirstNonRepeatingChar(str3));


    }

    public static char findNotRepeatingFirstCharacter(String str) {
        int[] alphabetOccurrences = new int[26];

        // 알파벳 등장 횟수 저장 (소문자 기준)
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!Character.isLetter(ch)) {
                continue;
            }
            ch = Character.toLowerCase(ch); // 대소문자 구분 없이 처리하려면 필요
            int index = ch - 'a';
            alphabetOccurrences[index]++;
        }

        // 다시 처음부터 탐색하면서 첫 번째로 중복되지 않은 문자 찾기
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!Character.isLetter(ch)) {
                continue;
            }
            char lowerCh = Character.toLowerCase(ch);
            int index = lowerCh - 'a';
            if (alphabetOccurrences[index] == 1) {
                return ch; // 원래 문자 그대로 반환 (대소문자 유지)
            }
        }

        return '_'; // 중복되지 않은 문자가 없을 경우
    }

    private static char linkedFindNotRepeatingFirstCharacter(String str) {
        Map<Character, Integer> frequencyMap = new LinkedHashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return '_';
    }

    private static char streamFindFirstNonRepeatingChar(String str) {
        Map<Character, Long> counts = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()));

        return counts.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse('_');
    }

}

// O(N)
