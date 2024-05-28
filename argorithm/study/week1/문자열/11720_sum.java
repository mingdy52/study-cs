import java.util.Scanner;


/**
	11720 입력된 숫자 N개의 합 출력
*/
class Main {
    public static void main(String[] args) {
				Scanner s = new Scanner(System.in);

				int length = s.nextInt(); // 입력될 숫자의 개수
				String nums = s.next();	// 합을 구할 숫자들

				int sum = 0;
				for(int i = 0; i < length; i++) {
					sum += Character.getNumericValue(nums.charAt(i)); // char -> int
				}
				System.out.print(sum);

				s.close();
    }

	// 시간 복잡도: O(n) ->  for 루프가 문자열의 각 문자를 한 번씩 처리하기 때문
	// n: 문자열의 길이.
}