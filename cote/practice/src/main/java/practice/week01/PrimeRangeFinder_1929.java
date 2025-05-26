package practice.week01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PrimeRangeFinder_1929 {

    /**
     문제
        M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.

     입력
        첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1 ≤ M ≤ N ≤ 1,000,000)
        M이상 N이하의 소수가 하나 이상 있는 입력만 주어진다.

     출력
        한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] range = bufferedReader.readLine().split(" ");
        int start = Integer.parseInt(range[0]);
        int end = Integer.parseInt(range[1]);
        if (start < 2) start = 2;

        List<Integer> primes = primeRangeFinder(start, end);

        StringBuilder sb = new StringBuilder();
        for (Integer prime : primes) {
            sb.append(prime).append("\n");
        }
        System.out.print(sb);

        System.out.println("\nSieve of Eratosthenes");
        List<Integer> sievePrimes = sievePrimeRangeFinder(start, end);

        sb = new StringBuilder();
        for (Integer prime : sievePrimes) {
            sb.append(prime).append("\n");
        }
        System.out.print(sb);
    }

    private static List<Integer> primeRangeFinder(int start, int end) {
        List<Integer> primes = new ArrayList<>();

        for (int i = start; i <= end; i++) {
            if(isPrime(i)) primes.add(i);
        }

        return primes;
    }

    private static boolean isPrime(int number) {
        if(number < 2) return false;
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    private static List<Integer> sievePrimeRangeFinder(int start, int end) {
        boolean[] isComposite  = new boolean[end + 1];
        for (int i = 2; i * i <= end; i++) {
            if(!isComposite[i]) {
                for (int j = i * i; j <= end; j+=i) {
                    isComposite[j] = true;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            if(!isComposite[i]) primes.add(i);
        }

        return primes;
    }
}
