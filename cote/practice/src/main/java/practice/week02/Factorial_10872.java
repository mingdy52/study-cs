package practice.week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Factorial_10872 {
    /**
     문제
        0보다 크거나 같은 정수 N이 주어진다. 이때, N!을 출력하는 프로그램을 작성하시오.
        첫째 줄에 정수 N(0 ≤ N ≤ 12)이 주어진다.
     */

    private static int SUM = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputN = Integer.parseInt(br.readLine());

        factorial(inputN);
        System.out.println(SUM);

        int result = factorial2(inputN);
        System.out.println(result);
    }

    private static void factorial(int n) {
        if(n < 1) return;
        SUM *= n;
        factorial(--n);
    }

    private static int factorial2(int n) {
        if (n <= 1) return 1;
        return n * factorial2(n - 1);
    }

}
