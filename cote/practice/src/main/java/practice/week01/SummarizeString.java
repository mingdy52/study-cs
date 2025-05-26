package practice.week01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class SummarizeString {

    /**
     문제
         1. 입력으로 소문자의 알파벳 순으로 정렬된 문자열이 입력됩니다.
         2. 각 알파벳은 중복이 가능합니다.
         3. 중간에 없는 알파벳이 있을 수도 있습니다.

         입,출력 예시와 같이 입력 문자열에 나타나는 각 알파벳의 종류,갯수를 요약하여 나타내시오.

         Ex 1) abc 	# a1/b1/c1

         Ex 2) aaabbbc	# a3/b3/c1
     */

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String inputString = bufferedReader.readLine();
        summarizeString(inputString);
        linkedMapSummarizeString(inputString);
    }

    private static void summarizeString(String inputString) {
        int count = 1;
        char prevChar = inputString.charAt(0);

        StringBuilder result = new StringBuilder();
        for (int i = 1; i < inputString.length(); i++) {
            char currentChar = inputString.charAt(i);

            if(prevChar == currentChar) {
                count++;
            }

            if(prevChar != currentChar) {
                result.append(prevChar).append(count).append("/");

                prevChar = currentChar;
                count = 1;
            }

        }

        result.append(prevChar).append(count);
        System.out.println(result);
    } // O(N)

    private static void linkedMapSummarizeString(String inputString) {
        Map<Character, Integer> countMap = new LinkedHashMap<>();

        StringBuilder result = new StringBuilder();
        for (char c : inputString.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            result.append(entry.getKey()).append(entry.getValue()).append("/");
        }

        result.setLength(result.length()-1);
        System.out.println(result);
    }
}
