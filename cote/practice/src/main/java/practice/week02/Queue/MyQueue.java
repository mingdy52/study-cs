package practice.week02.Queue;

import java.util.EmptyStackException;

public class MyQueue<T> {
    public MyQueue(Node<T> head) {
        this.head = head;
        this.tail = head;
        while (this.tail.getNext() != null) {
            this.tail = this.tail.getNext();
        }
    }

    public MyQueue() {}

    private Node<T> head;
    private Node<T> tail;


    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);

        if(isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
            return;
        }

        this.tail.setNext(newNode);
        this.tail = newNode;
    }

    public T dequeue() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }

        Node<T> currentHead = this.head;
        this.head = this.head.getNext();

        if(this.head == null) {
            this.tail = null;
        }

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
