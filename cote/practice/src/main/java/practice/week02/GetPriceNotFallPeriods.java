package practice.week02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GetPriceNotFallPeriods {
    /**
     문제
         초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때,
         가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 함수를 완성하세요.

         prices = [1, 2, 3, 2, 3]
         answer = [4, 3, 1, 1, 0]

     */

    public static void main(String[] args) {
        int[] prices1 = new int[]{1, 2, 3, 2, 3};
        int[] prices2 = new int[]{3, 9, 9, 3, 5, 7, 2};
        int[] prices3 = new int[]{1, 5, 3, 6, 7, 6, 5};

        int[] notFallPeriods1 = getPriceNotFallPeriods(prices1);
        int[] notFallPeriods2 = getPriceNotFallPeriods(prices2);
        int[] notFallPeriods3 = getPriceNotFallPeriods(prices3);

        System.out.println("정답 = [4, 3, 1, 1, 0] / 현재 풀이 값 = " + printPriceNotFallPeriods(notFallPeriods1));
        System.out.println("정답 = [6, 2, 1, 3, 2, 1, 0] / 현재 풀이 값 = " + printPriceNotFallPeriods(notFallPeriods2));
        System.out.println("정답 = [6, 1, 4, 3, 1, 1, 0] / 현재 풀이 값 = " + printPriceNotFallPeriods(notFallPeriods3));

        System.out.println();

        int[] notFallPeriods4 = getPriceNotFallPeriodsQueue(prices1);
        int[] notFallPeriods5 = getPriceNotFallPeriodsQueue(prices2);
        int[] notFallPeriods6 = getPriceNotFallPeriodsQueue(prices3);

        System.out.println("정답 = [4, 3, 1, 1, 0] / 현재 풀이 값 = " + printPriceNotFallPeriods(notFallPeriods4));
        System.out.println("정답 = [6, 2, 1, 3, 2, 1, 0] / 현재 풀이 값 = " + printPriceNotFallPeriods(notFallPeriods5));
        System.out.println("정답 = [6, 1, 4, 3, 1, 1, 0] / 현재 풀이 값 = " + printPriceNotFallPeriods(notFallPeriods6));

    }

    private static int[] getPriceNotFallPeriods(int[] prices) {
        int n = prices.length;

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int duration = 0;

            for (int j = i + 1; j < n; j++) {
                duration++;
                if (prices[j] < prices[i]) {
                    break;
                }
            }

            result[i] = duration;

        }

        return result;

    }// O(N^2)

    private static int[] getPriceNotFallPeriodsQueue(int[] prices) {
        Queue<Integer> queue = new LinkedList<>();
        for (int price : prices) {
            queue.offer(price);
        }

        List<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()) {
            Integer currentPrice = queue.poll();
            int duration = 0;

            for (int nextPrice : queue) {
                duration++;
                if(nextPrice < currentPrice) {
                    break;
                }

            }

            result.add(duration);
        }

        return result.stream().mapToInt(Integer::intValue).toArray();

    }// O(N^2)

    private static String printPriceNotFallPeriods(int[] notFallPeriods) {
        StringBuilder sb = new StringBuilder("[");

        for (int i = 0; i < notFallPeriods.length; i++) {
            sb.append(notFallPeriods[i]);
            if (i < notFallPeriods.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();

    }
}
