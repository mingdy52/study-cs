package practice.week02.sort;

public class SelectionSort {
    /**
         선택! 해서 정렬한다.
         한번 쓱 둘러보면서 가장 작은 값을 찾고, 맨 앞으로 옮긴다.
         다음에 두 번째로 작은 값을 두 번째에 배치 시킨다.
     */

    public static void main(String[] args) {
        int[] array1 = new int[]{4, 6, 2, 9, 1};
        int[] array2 = new int[]{3, -1, 17, 9};
        int[] array3 = new int[]{100, 56, -3, 32, 44};

        selectionSort(array1);
        selectionSort(array2);
        selectionSort(array3);

        System.out.println("정답 = [1, 2, 4, 6, 9] / 현재 풀이 값 = " + printArray(array1));
        System.out.println("정답 = [-1, 3, 9, 17] / 현재 풀이 값 = " + printArray(array2));
        System.out.println("정답 = [-3, 32, 44, 56, 100] / 현재 풀이 값 = " + printArray(array3));
    }
    private static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if(array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            if(i != minIndex) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
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
