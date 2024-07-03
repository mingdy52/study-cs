import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
    1541 연산식에 괄호 넣어서 최소값 찾기
*/
class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] operation  = br.readLine().split("\\-"); // - 로 나눔

		int result = sum(operation[0]); // 첫 번째 덧셈식 게산
		for (int i = 1; i < operation.length; i++) {
			// 나머지 덧셈식을 계산해서 결과값에서 뺌
			result -= sum(operation[i]);
		}

		System.out.println(result);
	}

	public static int sum(String sum) {
		int result = 0;
		String[] nums = sum.split("\\+");
		for (String num : nums) {
			result += Integer.parseInt(num);
		}
		return result;
	}
}