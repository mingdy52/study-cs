package practice.week02.sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] array1 = new int[]{-7, -1, 9, 40, 5, 6, 10, 11};
        int[] array2 = new int[]{-1, 2, 3, 5, 40, 10,78,100};
        int[] array3 = new int[]{-1,-1,0, 1, 6, 9, 10};

        array1 = mergeSort(array1);
        array2 = mergeSort(array2);
        array3 = mergeSort(array3);

        System.out.println("정답 = [-7, -1, 5, 6, 9, 10, 11, 40] / 현재 풀이 값 = " + printArray(array1));
        System.out.println("정답 = [-1, 2, 3, 5, 10, 40, 78, 100] / 현재 풀이 값 = " + printArray(array2));
        System.out.println("정답 = [-1, -1, 0, 1, 6, 9, 10] / 현재 풀이 값 = " + printArray(array3));
    }

    private static int[] mergeSort(int[] array) {
        if(array.length < 2)
            return array;

        int mid = array.length / 2;

        int[] left = mergeSort(Arrays.copyOfRange(array, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(array, mid, array.length));

        return merge(left, right);
    }// O(nlogn)

    /**
         배열의 앞부분과 뒷부분의 두 그룹으로 나누어 각각 정렬한 후 병합하는 작업을 반복하는 알고리즘

         예를 들어서
         A 라고 하는 배열이 1, 2, 3, 5 로 정렬되어 있고,
         B 라고 하는 배열이 4, 6, 7, 8 로 정렬되어 있다면
         이 두 집합을 합쳐가면서 정렬하는 방법
     */
    private static int[] merge(int[] array1, int[] array2) {
        int[] result = new int[array1.length + array2.length];
        int array1Index = 0;
        int array2Index = 0;
        int resultIndex = 0;

        while(array1Index < array1.length && array2Index < array2.length) {
            if(array1[array1Index] <= array2[array2Index]) {
                result[resultIndex++] = array1[array1Index++];
            } else {
                result[resultIndex++] = array2[array2Index++];
            }
        }

        while(array1Index < array1.length) {
            result[resultIndex++] = array1[array1Index++];
        }

        while(array2Index < array2.length) {
            result[resultIndex++] = array2[array2Index++];
        }

        return result;
    }// O(n + m)

    private static String printArray(int[] array) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
