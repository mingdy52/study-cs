package practice.week01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindCountToTurnOutToAllZeroOrAllOne {

    /**
     문제
         0과 1로만 이루어진 문자열이 주어졌을 때, 이 문자열에 있는 모든 숫자를 전부 같게 만들려고 한다.
        할 수 있는 행동은 문자열에서 연속된 하나 이상의 숫자를 잡고 모두 뒤집는 것이다.
        뒤집는 것은 1을 0으로, 0을 1로 바꾸는 것을 의미한다.

         예를 들어 S=0001100 일 때,
         전체를 뒤집으면 1110011이 된다.
         4번째 문자부터 5번째 문자까지 뒤집으면 1111111이 되어서 2번 만에 모두 같은 숫자로 만들 수 있다.
         하지만, 처음부터 4번째 문자부터 5번째 문자까지 문자를 뒤집으면 한 번에 0000000이 되어서 1번 만에 모두 같은 숫자로 만들 수 있다.

         주어진 문자열을 모두 0 혹은 모두 1로 같게 만드는 최소 횟수를 반환하시오.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String binaryString = bufferedReader.readLine();
        countMinFlipsToMakeUniform(binaryString);
    }

    /**
        핵심 아이디어
            문자열을 인접한 숫자가 바뀌는 시점마다 그룹이 생긴다.
        예) 0001100
            그룹1: 000
            그룹2: 11
            그룹3: 00
            👉 0 그룹과 1 그룹의 수 중 더 작은 값이 최소 뒤집기 횟수
     */

    private static void countMinFlipsToMakeUniform(String binaryString) {
        int flipToZeroCount = 0;
        int flipToOneCount = 0;

        char prevChar = binaryString.charAt(0);
        if(prevChar == '0') flipToZeroCount++;
        else flipToOneCount++;

        for (int i = 1; i < binaryString.length(); i++) {
            char currentChar = binaryString.charAt(i);

            if(prevChar != currentChar) {
                if(currentChar == '0') flipToZeroCount++;
                else flipToOneCount++;

                prevChar = currentChar;
            }

        }

        System.out.println(Math.min(flipToZeroCount, flipToOneCount));
    } // O(N)

}
