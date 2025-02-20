package study.cs.argorithm.week01;

import java.util.Stack;

public class FindMaxNum {

    public static void main(String[] args) {
        System.out.println("정답 = 6 / 현재 풀이 값 = " + findMaxNum(new int[] {3, 5, 6, 1, 2, 4}));
       System.out.println("정답 = 6 / 현재 풀이 값 = " + findMaxNum(new int[] {6, 6, 6}));
        System.out.println("정답 = 1888 / 현재 풀이 값 = " + findMaxNum(new int[] {6, 9, 2, 7, 1888}));

    }

    private static int findMaxNum(int[] nums) {
        int max = 0;
        for (int num : nums) {
            if(num >= max) max = num;
        }

        return max;
    }

}
