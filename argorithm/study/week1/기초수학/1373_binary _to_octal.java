import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
	1373 2진수를 8진수로 변환
*/
class Main {
    public static void main(String[] args) throws IOException {
		/**
			2진수를 8진수로 변환하는 방법

			1. 2진수를 오른쪽부터 3자리씩 그룹으로 나눈다.
			2. 3자리로 나누어지지 않는 경우 왼쪽에 0을 추가한다.
			3. 각 3자리 그룹을 2 -> 10진수로 변환한다.
			4. 변환된 값을 결합한다.

			=> 8진수
		*/

		BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
		String binaryString = br.readLine();

		int remainder = binaryString.length() % 3; // 2진수의 길이를 3으로 나눈 나머지
		if (remainder != 0) { // 나머지가 0이 아니면 0을 추가
			int padNum = 3 - remainder; // 추가할 0의 개수

			for (int i = 0; i < padNum; i++) {
				binaryString = "0" + binaryString;
			}
		}

		StringBuilder result = new StringBuilder();
		for (int i = 0; i < binaryString.length(); i+=3) { 
			int r = Integer.parseInt(binaryString.substring(i, i + 3), 2); // 2진수를 3자리 그룹으로 나누어 10진수로 변환
			result.append(r); // 결합하면 8진수 완성
		}

		System.out.println(result);

    }
}