package practice.week02.sort;

public class BubbleSort {

    /**
        버블 정렬은 첫 번째 자료와 두 번째 자료를, 두 번째 자료와 세 번째 자료를, 세 번째와 네 번째를, …
        이런 식으로 (마지막-1)번째 자료와 마지막 자료를 비교하여 교환하면서 자료를 정렬하는 방식
     */

    public static void main(String[] args) {
        int[] array1 = new int[]{4, 6, 2, 9, 1};
        int[] array2 = new int[]{3, -1, 17, 9};
        int[] array3 = new int[]{100, 56, -3, 32, 44};

        bubbleSort(array1);
        bubbleSort(array2);
        bubbleSort(array3);

        System.out.println("정답 = [1, 2, 4, 6, 9] / 현재 풀이 값 = " + printArray(array1));
        System.out.println("정답 = [-1, 3, 9, 17] / 현재 풀이 값 = " + printArray(array2));
        System.out.println("정답 = [-3, 32, 44, 56, 100] / 현재 풀이 값 = " + printArray(array3));
    }

    private static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 ; j++) {
                if(array[j + 1] < array[j]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }

            }
        }
    }

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
