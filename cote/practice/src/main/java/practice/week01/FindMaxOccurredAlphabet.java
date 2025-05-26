package practice.week01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindMaxOccurredAlphabet {

    public static void main(String[] args) {
        System.out.println("정답 = i 현재 풀이 값 =" + findMaxOccurredAlphabet("hello my name is mingdii"));
        System.out.println("정답 = e 현재 풀이 값 =" + findMaxOccurredAlphabet("we love algorithm"));
        System.out.println("정답 = b 현재 풀이 값 =" + findMaxOccurredAlphabet("best of best youtube"));

        System.out.println("정답 = i 현재 풀이 값 =" + findMaxOccurredAlphabet2("hello my name is mingkii"));
        System.out.println("정답 = e 현재 풀이 값 =" + findMaxOccurredAlphabet2("we love algorithm"));
        System.out.println("정답 = b 현재 풀이 값 =" + findMaxOccurredAlphabet2("best of best youtube"));

        System.out.println("정답 = i 현재 풀이 값 =" + findMaxOccurredAlphabet3("hello my name is mingkii"));
        System.out.println("정답 = e 현재 풀이 값 =" + findMaxOccurredAlphabet3("we love algorithm"));
        System.out.println("정답 = b 현재 풀이 값 =" + findMaxOccurredAlphabet3("best of best youtube"));
    }

    private static String findMaxOccurredAlphabet(String string){
        char[] charArray = string.replace(" ", "").toCharArray();

        int maxOccurredCount = 0;
        char maxOccurredChar = charArray[0];

        for (char c : charArray) {
            int occurredCount = 0;

            for (int i = 0; i < charArray.length; i++) {
                if (c == charArray[i]) occurredCount++;
            }

            if (occurredCount > maxOccurredCount) {
                maxOccurredCount = occurredCount;
                maxOccurredChar = c;
            }
        }

        return String.valueOf(maxOccurredChar);
    }

    private static String findMaxOccurredAlphabet2(String string){
        char[] charArray = string.replace(" ", "").toCharArray();

        Map<Character, Integer> occurredMap = new HashMap<>();

        int maxOccurredCount = 0;
        char maxOccurredChar = charArray[0];

        for (char c : charArray) {
            occurredMap.put(c, occurredMap.getOrDefault(c, 0) + 1);
        }

        for (Character c : occurredMap.keySet()) {
            Integer occurredCount = occurredMap.get(c);

            if(occurredCount > maxOccurredCount) {
                maxOccurredCount = occurredCount;
                maxOccurredChar = c;
            }
        }
        return String.valueOf(maxOccurredChar);
    }


    public static char findMaxOccurredAlphabet3(String str) {
        int[] alphabetOccurrenceArray = new int[26];

        str = str.toLowerCase();

        for (char c : str.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                int index = c - 'a';
                alphabetOccurrenceArray[index]++;
            }
        }

        int maxOccurrence = 0;
        int maxAlphabetIndex = 0;
        for (int i = 0; i < alphabetOccurrenceArray.length; i++) {
            if (alphabetOccurrenceArray[i] > maxOccurrence) {
                maxOccurrence = alphabetOccurrenceArray[i];
                maxAlphabetIndex = i;
            }
        }

        return (char) (maxAlphabetIndex + 'a');
    }

}
