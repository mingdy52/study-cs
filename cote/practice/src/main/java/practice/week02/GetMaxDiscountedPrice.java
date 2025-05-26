package practice.week02;

import java.util.Arrays;
import java.util.Collections;

public class GetMaxDiscountedPrice {

    /**
         문제
             다음과 같이 숫자로 이루어진 배열이 두 개가 있다.
             하나는 상품의 가격을 담은 배열이고, 하나는 쿠폰을 담은 배열이다.
             쿠폰의 할인율에 따라 상품의 가격을 할인 받을 수 있다.
             이 때, 최대한 할인을 많이 받는다면 얼마를 내야 하는가?
             단, 할인쿠폰은 한 제품에 한 번씩만 적용 가능하다.

     */

    public static void main(String[] args) {
        Integer[] shopPrices1  = new Integer[]{30000, 2000, 1500000};
        Integer[] userCoupons1 = new Integer[]{20, 40};

        Integer[] shopPrices2 = new Integer[]{50000, 1500000};
        Integer[] userCoupons2 = new Integer[]{10, 70, 30, 20};

        Integer[] shopPrices3 = new Integer[]{50000, 1500000};
        Integer[] userCoupons3 = new Integer[]{0};

        Integer[] shopPrices4 = new Integer[]{20000, 100000, 1500000};
        Integer[] userCoupons4 = new Integer[]{10, 10, 10};

        System.out.println("정답 = 926000 / 현재 풀이 값 = " + getMaxDiscountedPrice(shopPrices1, userCoupons1));
        System.out.println("정답 = 485000  / 현재 풀이 값 = " + getMaxDiscountedPrice(shopPrices2, userCoupons2));
        System.out.println("정답 = 1550000  / 현재 풀이 값 = " + getMaxDiscountedPrice(shopPrices3, userCoupons3));
        System.out.println("정답 = 1458000  / 현재 풀이 값 = " + getMaxDiscountedPrice(shopPrices4, userCoupons4));

    }

    private static int getMaxDiscountedPrice(Integer[] prices, Integer[] coupons) {
        Arrays.sort(prices, Collections.reverseOrder());
        Arrays.sort(coupons, Collections.reverseOrder());

        int index = 0;
        int maxPrice = 0;

        while (index < prices.length && index < coupons.length) {
            int price = prices[index] * (100 - coupons[index]) / 100;
            maxPrice += price;
            index++;
        }

        while (index < prices.length) {
            maxPrice += prices[index];
            index++;
        }

        return maxPrice;

    }
}
