package practice.week02.stack;

public class MyStackTest {

    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack.pop());  // 30
        System.out.println(stack.peek()); // 20
        System.out.println(stack.pop());  // 20
        System.out.println(stack.pop());  // 10
        System.out.println(stack.isEmpty()); // true

        // stack.pop(); // 예외 발생 확인: java.util.EmptyStackException
    }

}
