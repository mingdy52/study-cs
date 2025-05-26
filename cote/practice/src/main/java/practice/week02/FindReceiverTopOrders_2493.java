package practice.week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class FindReceiverTopOrders_2493 {
    /**
         문제
            KOI 통신연구소는 레이저를 이용한 새로운 비밀 통신 시스템 개발을 위한 실험을 하고 있다.
            실험을 위하여 일직선 위에 N개의 높이가 서로 다른 탑을 수평 직선의 왼쪽부터 오른쪽 방향으로 차례로 세우고,
            각 탑의 꼭대기에 레이저 송신기를 설치하였다.
            모든 탑의 레이저 송신기는 레이저 신호를 지표면과 평행하게 수평 직선의 왼쪽 방향으로 발사하고,
            탑의 기둥 모두에는 레이저 신호를 수신하는 장치가 설치되어 있다.
            하나의 탑에서 발사된 레이저 신호는 가장 먼저 만나는 단 하나의 탑에서만 수신이 가능하다.

            예를 들어 높이가 6, 9, 5, 7, 4인 다섯 개의 탑이 수평 직선에 일렬로 서 있고,
            모든 탑에서는 주어진 탑 순서의 반대 방향(왼쪽 방향)으로 동시에 레이저 신호를 발사한다고 하자.
            그러면, 높이가 4인 다섯 번째 탑에서 발사한 레이저 신호는 높이가 7인 네 번째 탑이 수신을 하고,
            높이가 7인 네 번째 탑의 신호는 높이가 9인 두 번째 탑이,
            높이가 5인 세 번째 탑의 신호도 높이가 9인 두 번째 탑이 수신을 한다.
            높이가 9인 두 번째 탑과 높이가 6인 첫 번째 탑이 보낸 레이저 신호는 어떤 탑에서도 수신을 하지 못한다.

            탑들의 개수 N과 탑들의 높이가 주어질 때, 각각의 탑에서 발사한 레이저 신호를 어느 탑에서 수신하는지를 알아내는 프로그램을 작성하라.

         입력
            첫째 줄에 탑의 수를 나타내는 정수 N이 주어진다. N은 1 이상 500,000 이하이다.
            둘째 줄에는 N개의 탑들의 높이가 직선상에 놓인 순서대로 하나의 빈칸을 사이에 두고 주어진다.
            탑들의 높이는 1 이상 100,000,000 이하의 정수이다.

         출력
            첫째 줄에 주어진 탑들의 순서대로 각각의 탑들에서 발사한 레이저 신호를 수신한 탑들의 번호를 하나의 빈칸을 사이에 두고 출력한다.
            만약 레이저 신호를 수신하는 탑이 존재하지 않으면 0을 출력한다.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        br.readLine();
        String[] input = br.readLine().split(" ");

        int[] height = Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] receivers = findSignalReceivers(height);

        StringBuilder sb = new StringBuilder();
        for (int val : receivers) {
            sb.append(val).append(" ");
        }

        System.out.println(sb);
    }

    private static int[] findSignalReceivers(int[] height) {
        int topCount = height.length;
        int[] receivers = new int[topCount];
        Stack<Integer> topIndex = new Stack<>();
//        6 9 5 7 4
//        1 2 3 4 5
//        0 0 2 2 4

        for (int i = 0; i < topCount; i++) {
            while(!topIndex.isEmpty() && height[topIndex.peek()] < height[i]) {
                topIndex.pop();
            }

            if(topIndex.isEmpty()) {
                receivers[i] = 0;
            } else {
                receivers[i] = topIndex.peek() + 1;
            }

            topIndex.push(i);
        }

        return receivers;
    }

/*
    O(N)
      각 탑의 인덱스는 스택에 한 번만 push, 그리고 한 번만 pop 된다.
      while 루프가 중첩처럼 보여 O(N²)로 같지만 실제로는 스택의 요소가 총 N개만 들어가고 나가므로 선형이다.
      즉, 전체적으로 스택 연산의 총합이 최대 2N (N번 push + N번 pop)
      반복문 안의 while 루프가 있지만 전체 합산 기준으로는 O(N)
*/


}
