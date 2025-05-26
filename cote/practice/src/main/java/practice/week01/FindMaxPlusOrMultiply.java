package practice.week01;

import java.util.Arrays;

public class FindMaxPlusOrMultiply {
    /**
     문제
     다음과 같이 0 혹은 양의 정수로만 이루어진 배열이 있을 때,
     왼쪽부터 오른쪽으로 하나씩 모든 숫자를 확인하며 숫자 사이에 '✕' 혹은 '+' 연산자를 넣어
     결과적으로 가장 큰 수를 구하는 프로그램을 작성하시오.
     단, '+' 보다 '✕' 를 먼저 계산하는 일반적인 방식과는 달리, 모든 연산은 왼쪽에서 순서대로 이루어진다.
     */

    public static void main(String[] args) {
        int[] arr1 = {0,3,5,6,1,2,4};
        int[] arr2 = {3,2,1,5,9,7,4};
        int[] arr3 = {1,1,1,3,3,2,5};

        System.out.println("정답 = 728 현재 풀이 값 = " + findMaxPlusOrMultiply(arr1));
        System.out.println("정답 = 8820 현재 풀이 값 = " + findMaxPlusOrMultiply(arr2));
        System.out.println("정답 = 270 현재 풀이 값 = " + findMaxPlusOrMultiply(arr3));

        System.out.println();

        System.out.println("정답 = 728 현재 풀이 값 = " + streamFindMaxPlusOrMultiply(arr1));
        System.out.println("정답 = 8820 현재 풀이 값 = " + streamFindMaxPlusOrMultiply(arr2));
        System.out.println("정답 = 270 현재 풀이 값 = " + streamFindMaxPlusOrMultiply(arr3));

        System.out.println();

        dfsFindMaxPlusOrMultiply(arr1, 1, arr1[0]);
        System.out.println("정답 = 728 현재 풀이 값 = " + max);
        dfsFindMaxPlusOrMultiply(arr2, 1, arr2[0]);
        System.out.println("정답 = 8820 현재 풀이 값 = " + max);
        dfsFindMaxPlusOrMultiply(arr3, 1, arr3[0]);
        System.out.println("정답 = 270 현재 풀이 값 = " + max);

        System.out.println();

        System.out.println("정답 = 728 현재 풀이 값 = " + dpMaxPlusOrMultiply(arr1));
        System.out.println("정답 = 8820 현재 풀이 값 = " + dpMaxPlusOrMultiply(arr2));
        System.out.println("정답 = 270 현재 풀이 값 = " + dpMaxPlusOrMultiply(arr3));
    }

    private static int findMaxPlusOrMultiply(int[] intArrays) {
        int maxPlusOrMultiplySum = 0;
        for (int num : intArrays) {
            if(num <= 1 || maxPlusOrMultiplySum <= 1) {
                maxPlusOrMultiplySum += num;
                continue;
            }
            maxPlusOrMultiplySum *= num;
        }

        return maxPlusOrMultiplySum;
    }

    private static int streamFindMaxPlusOrMultiply(int[] arr) {
        return Arrays.stream(arr).reduce((a, b) -> (a <= 1 || b <= 1) ? a + b : a * b).orElse(0);
    }

    /**
     ✔️ 사용하기 좋은 상황
         - 입력이 크고 빠른 결과가 필요한 경우 (O(N)의 성능).
         - 문제 조건이 순차적으로 처리해도 최적해가 보장되는 경우 (이 문제처럼 연산 순서가 고정됨).
         - 연산에 우선순위가 없거나, 우선순위가 문제에서 정해져 있는 경우.

     ❌ 피해야 할 상황
         - 중간에 다양한 경로에 따라 결과가 달라지는 경우.
         - 모든 경우의 수를 고려해야 최적해가 나오는 경우.
     */


    public static int max = Integer.MIN_VALUE;
    private static void dfsFindMaxPlusOrMultiply(int[] arr, int index, int currentValue) {
        if (index == arr.length) {
            max = Math.max(max, currentValue);
            return;
        }

        dfsFindMaxPlusOrMultiply(arr, index + 1, currentValue + arr[index]); // +
        dfsFindMaxPlusOrMultiply(arr, index + 1, currentValue * arr[index]); // *
    }
    /**
     ✔️ 사용하기 좋은 상황
         - 문제에서 가능한 모든 연산의 조합을 다 고려해야 할 때.
         - N이 작을 때 (보통 20 이하), 테스트나 검증 용도로.
         - 최적의 결과가 Greedy로는 보장되지 않을 때.

     ❌ 피해야 할 상황
         - N이 크고, 시간이 촉박할 때 (폭발적인 시간 복잡도).
         - 메모리, 스택 오버플로우가 발생할 수 있음.
     */


    private static int dpMaxPlusOrMultiply(int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            dp[i] = Math.max(dp[i - 1] + arr[i], dp[i - 1] * arr[i]);
        }

        return dp[arr.length - 1];
    }

    /**
     ✔️ 사용하기 좋은 상황
         - 앞선 상태를 기억해서 중복 계산을 줄일 수 있는 경우.
         - 복잡한 조건에서 Greedy가 해답을 보장하지 못할 때.
         - 상태 전이가 명확하고, 부분 문제로 쪼갤 수 있을 때.

     ❌ 피해야 할 상황
         - 문제 구조가 DP에 맞지 않거나, 부분 문제가 독립적이지 않을 때.
         - 코드가 단순한데 과도하게 복잡하게 보일 수 있음.
     */

}

// O(N)


