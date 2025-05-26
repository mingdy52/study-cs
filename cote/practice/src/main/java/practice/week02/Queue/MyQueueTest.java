package practice.week02.Queue;

import java.util.EmptyStackException;

public class MyQueueTest {

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();

        System.out.println("처음 isEmpty: " + queue.isEmpty());  // true

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("peek(): " + queue.peek());           // 10
        System.out.println("dequeue(): " + queue.dequeue());     // 10
        System.out.println("peek(): " + queue.peek());           // 20
        System.out.println("dequeue(): " + queue.dequeue());     // 20
        System.out.println("dequeue(): " + queue.dequeue());     // 30

        System.out.println("isEmpty: " + queue.isEmpty());       // true

        // 예외 테스트
        try {
            queue.dequeue(); // 예외 발생
        } catch (EmptyStackException e) {
            System.out.println("예외 발생 확인 (dequeue): " + e);
        }

        try {
            queue.peek(); // 예외 발생
        } catch (EmptyStackException e) {
            System.out.println("예외 발생 확인 (peek): " + e);
        }
    }
}
