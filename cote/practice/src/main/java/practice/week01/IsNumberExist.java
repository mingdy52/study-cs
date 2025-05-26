package practice.week01;

import java.util.Arrays;

public class IsNumberExist {

    public static void main(String[] args) {
        System.out.println("정답 = True 현재 풀이 값 = " + isNumberExist(3, new int[] {3, 5, 6, 1, 2, 4}));
        System.out.println("정답 = False 현재 풀이 값 = " + isNumberExist(7, new int[] {6, 6, 6}));
        System.out.println("정답 = True 현재 풀이 값 = " + isNumberExist(2, new int[] {6, 9, 2, 7, 1888}));

        System.out.println("정답 = True 현재 풀이 값 = " + isNumberExist2(3, new int[] {3, 5, 6, 1, 2, 4}));
        System.out.println("정답 = False 현재 풀이 값 = " + isNumberExist2(7, new int[] {6, 6, 6}));
        System.out.println("정답 = True 현재 풀이 값 = " + isNumberExist2(2, new int[] {6, 9, 2, 7, 1888}));

        System.out.println("정답 = True 현재 풀이 값 = " + isNumberExist3(3, new int[] {3, 5, 6, 1, 2, 4}));
        System.out.println("정답 = False 현재 풀이 값 = " + isNumberExist3(7, new int[] {6, 6, 6}));
        System.out.println("정답 = True 현재 풀이 값 = " + isNumberExist3(2, new int[] {6, 9, 2, 7, 1888}));
    }

    private static boolean isNumberExist(int findNumber, int[] numberArray) {
        for (int i : numberArray) {
            if (findNumber == i) {
                return true;
            }
        }

        return false;
    }

    // stream
    private static boolean isNumberExist2(int findNumber, int[] numberArray) {
        // anyMatch(i -> i == findNumber)는 조건에 하나라도 만족하면 true 반환.
        return Arrays.stream(numberArray).anyMatch(i -> i == findNumber);
    }

    // 이진 탐색
    private static boolean isNumberExist3(int findNumber, int[] numberArray) {
        Arrays.sort(numberArray);  // 정렬 필요
        return Arrays.binarySearch(numberArray, findNumber) >= 0;
        // 값이 존재하면 해당 인덱스(0 이상)를 반환, 없으면 음수를 반환.
    }

}

// O(N)