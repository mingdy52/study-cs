package practice.week01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FindPrimeListUnderNumber {

    /**
     문제
         정수를 입력 했을 때, 그 정수 이하의 소수를 모두 반환하시오.
         소수는 자신보다 작은 두 개의 자연수를 곱하여 만들 수 없는 1보다 큰 자연수이다.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int inputNumber = Integer.parseInt(bufferedReader.readLine());

        List<Integer> primes = findPrimeListUnderNumber(inputNumber);

        for (Integer prime : primes) {
            System.out.print(prime + " ");
        }

        System.out.println();
        System.out.println("Sieve of Eratosthenes");
        List<Integer> sievePrimes = sieveFindPrimeListUnderNumber(inputNumber);

        for (Integer prime : sievePrimes) {
            System.out.print(prime + " ");
        }
    }

    private static List<Integer> findPrimeListUnderNumber(int inputNumber) {
        List<Integer> primes = new ArrayList<>();

        for (int i = 2; i <= inputNumber; i++) {
            if(isPrime(i)) primes.add(i);
        }
        return primes;
    } // O(n√n)

    private static boolean isPrime(int n) {
        if(n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if(n % i == 0) return false;
        }
        return true;
    }

    /**
        에라토스테네스의 체 (Sieve of Eratosthenes)
             시간 복잡도: O(n log log n)
             빠르고 효율적이며, 많은 수의 소수를 한 번에 구할 때 최적
     */

    private static List<Integer> sieveFindPrimeListUnderNumber(int inputNumber) {
        boolean[] isComposite  = new boolean[inputNumber + 1];

        for (int i = 2; i <= inputNumber; i++) {
            if(!isComposite [i]) {
                for (int j = i * i; j <= inputNumber; j += i) {
                    isComposite [j] = true;
                }
            }

        }

        List<Integer> primes = new ArrayList<>();

        for (int i = 2; i <= inputNumber; i++) {
            if(!isComposite [i]) primes.add(i);
        }

        return primes;

    } // O(n log log n)


}
