package practice.week02;

import practice.week02.linkedList.MyLinkedList;
import practice.week02.linkedList.Node;

public class GetLinkedListSum {
    /**
     문제
         다음과 같은 두 링크드 리스트를 입력받았을 때, 합산한 값을 반환하시오.
         예를 들어 아래와 같은 링크드 리스트를 입력받았다면,
         [6] -> [7] -> [8]
         [3] -> [5] -> [4]

         각각 678, 354 이므로 두개의 총합 678 + 354 = 1032 를 반환해야 한다.
         단, 각 노드의 데이터는 한자리 수 숫자만 들어갈 수 있다.
     */

    public static void main(String[] args) {
        MyLinkedList<Integer> linkedList1 = new MyLinkedList<>(6);
        linkedList1.append(7);
        linkedList1.append(8);

        MyLinkedList<Integer> linkedList2 = new MyLinkedList<>(3);
        linkedList2.append(5);
        linkedList2.append(4);

        System.out.println(getLinkedListSum(linkedList1, linkedList2));
    }

    private static int getLinkedListSum(MyLinkedList<Integer> linkedList1, MyLinkedList<Integer> linkedList2) {
        int listToInt1 = convertLinkedListToInt(linkedList1);
        int listToInt2 = convertLinkedListToInt(linkedList2);

        return listToInt1 + listToInt2;
    }

    private static int convertLinkedListToInt(MyLinkedList<Integer> linkedList) {
        if(linkedList.isEmpty()) {
            return 0;
        }

        Node<Integer> current = linkedList.getHead();

        StringBuilder convertedInt = new StringBuilder();
        while(current != null) {
            int data = current.getData();

            if(data < 0 || data > 9) {
                throw new IllegalArgumentException("Node must contain a single digit (0-9).");
            }

            convertedInt.append(data);
            current = current.getNext();
        }

        return Integer.parseInt(convertedInt.toString());
    }

}
