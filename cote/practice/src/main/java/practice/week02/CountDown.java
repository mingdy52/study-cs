package study.cs.argorithm.week02;


public class CountDown {
    /**
     문제
     60에서 0까지 숫자를 출력하시오.
     */

    public static void main(String[] args) {
        countDown(60);
    }

    private static void countDown(int number) {
        if(number < 0) return;
        System.out.println(number);
        countDown(--number);
    }

}
