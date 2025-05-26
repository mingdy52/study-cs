package practice.week02.linkedList;

public class Node<T> {

    public Node(T data) {
        this.data = data;
    }

    private T data;
    private Node<T> next;

    public boolean nextIsNotEmpty() {
        return this.next != null;
    }

    public Node<T> getNext() {
        return this.next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }
}
