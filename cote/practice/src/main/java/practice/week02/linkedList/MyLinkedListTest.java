package practice.week02.linkedList;

public class MyLinkedListTest {

    public static void main(String[] args) {
        MyLinkedList<Integer> intLinkedList= new MyLinkedList<>();
        intLinkedList.append(5);
        intLinkedList.append(7);
        intLinkedList.append(4);
        intLinkedList.append(12);
        intLinkedList.printAll();

        Node<Integer> integerNode = intLinkedList.getNode(3);
        System.out.println(integerNode.getData());

        intLinkedList.addNode(2, 9);
        intLinkedList.printAll();

        intLinkedList.deleteNode(6);
        intLinkedList.printAll();


        MyLinkedList<String> stringLinkedList= new MyLinkedList<>();
        stringLinkedList.append("한국");
        stringLinkedList.append("일본");
        stringLinkedList.append("중국");
        stringLinkedList.append("몽골");
        stringLinkedList.printAll();

    }

}
