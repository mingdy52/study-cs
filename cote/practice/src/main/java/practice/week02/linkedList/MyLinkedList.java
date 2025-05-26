package practice.week02.linkedList;

import practice.week02.linkedList.Node;

public class MyLinkedList<T> {

    public MyLinkedList() {}

    public MyLinkedList(T data) {
        this.head = new Node<>(data);
    }

    private Node<T> head;

    public void append(T data) {
        Node<T> newNode = new Node<>(data);

        if(isEmpty()) {
            this.head = newNode;
            return;
        }

        Node<T> current = this.head;
        while(current.nextIsNotEmpty()) {
            current = current.getNext();
        }

        current.setNext(newNode);

    }

    public void addNode(int index, T data) {
        Node<T> newNode = new Node<>(data);

        if(index == 0) {
            newNode.setNext(this.head);
            this.head = newNode;
            return;
        }

        Node<T> prevNode = getNode(index - 1);
        Node<T> nextNode = prevNode.getNext();
        prevNode.setNext(newNode);
        newNode.setNext(nextNode);

    }

    public Node<T> getNode(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index cannot be negative.");
        }


        Node<T> current = this.head;
        int currentIndex = 0;

        while(currentIndex != index) {
            current = current.getNext();

            if (current == null) {
                throw new IndexOutOfBoundsException("Index out of bounds: " + index);
            }

            currentIndex++;
        }
        return current;
    }

    public void deleteNode(int index) {
        if(index == 0) {
            Node<T> newHead = this.head.getNext();
            this.head = newHead;
            return;
        }

        Node<T> prevNode = getNode(index - 1);
        Node<T> currendtNode = prevNode.getNext();

        if (currendtNode == null) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }

        prevNode.setNext(currendtNode.getNext());
    }

    public void printAll() {
        if(isEmpty()) {
            System.out.println("empty");
            return;
        }

        Node<T> current = this.head;

        StringBuilder sb = new StringBuilder();
        while(current != null) {
            sb.append("[").append(current.getData()).append("]");
            current = current.getNext();
        }

        System.out.println(sb);
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public Node<T> getHead() {
        return head;
    }
}
