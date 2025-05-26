package practice.week01;

import java.util.Stack;

public class FindMaxNum {
    /**
     문제
        다음과 같이 영어로 되어 있는 문자열이 있을 때
        , 이 문자열에서 반복되지 않는 첫번째 문자를 반환하시오. 만약 그런 문자가 없다면 _ 를 반환하시오.

     */
    public static void main(String[] args) {
        System.out.println("정답 = 6 / 현재 풀이 값 = " + findMaxNum(new int[] {3, 5, 6, 1, 2, 4}));
        System.out.println("정답 = 6 / 현재 풀이 값 = " + findMaxNum(new int[] {6, 6, 6}));
        System.out.println("정답 = 1888 / 현재 풀이 값 = " + findMaxNum(new int[] {6, 9, 2, 7, 1888}));

    }

    private static int findMaxNum(int[] array) {
        for (int number : array) {
            boolean isMaxNum = true;

            for (int compareNumber : array) {
                if (number < compareNumber) {
                    isMaxNum = false;
                    break;
                }
            }
            if (isMaxNum) {
                return number;
            }
        }

        return 0; // 배열이 비어있는 경우
    }


    private static int findMaxNum2(int[] nums) {
        int max = 0;
        for (int num : nums) {
            if(num >= max) max = num;
        }

        return max;
    }

}
