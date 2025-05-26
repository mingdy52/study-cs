package practice.week02.stack;

import java.util.EmptyStackException;

public class MyStack<T> {
    public MyStack(Node<T> head) {
        this.head = head;
    }

    public MyStack() {}

    private Node<T> head;


    public void push(T data) {
        Node<T> newHead = new Node<T>(data);
        newHead.setNext(this.head);
        this.head = newHead;
    }

    public T pop() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }

        Node<T> currentHead = this.head;
        Node<T> next = currentHead.getNext();
        this.head = next;

        return currentHead.getData();
    }

    public T peek() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }

        return this.head.getData();
    }

    public boolean isEmpty() {
        return this.head == null;
    }
}
