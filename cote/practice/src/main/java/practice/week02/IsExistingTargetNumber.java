package practice.week02;


public class IsExistingTargetNumber {
    /**
     문제
        1에서 16까지 오름차순으로 정렬되어 있는 배열이 있다. 이 배열 내에 14가 존재한다면 True, 존재하지 않는다면 False 를 반환하시오.
     */

    private static final int  FINDING_TARGET = 14;
    private static final int[] FINDING_NUMBERS = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};

    public static void main(String[] args) {
        System.out.println(isExistingTargetNumberBinary(14));
    }

    private static boolean isExistingTargetNumber(int targetNumber) {
        for (int findingNumber : FINDING_NUMBERS) {
            if(findingNumber == targetNumber) return true;
        }

        return false;
    } // O(N)

    private static boolean isExistingTargetNumberBinary(int targetNumber) {
        int min = 0;
        int max = FINDING_NUMBERS.length - 1;

        while(min <= max) {
            int mid = (min + max) / 2;

            if(FINDING_NUMBERS[mid] == targetNumber) return true;

            if(FINDING_NUMBERS[mid] > targetNumber) max = mid - 1;

            if(FINDING_NUMBERS[mid] < targetNumber) min = mid + 1;
        }

        return false;
    } //  O(logN)

}
