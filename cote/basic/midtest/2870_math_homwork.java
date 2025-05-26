import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
    2870 수학숙제
*/
class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int round = Integer.parseInt(br.readLine());

		List<BigInteger> numbers = new ArrayList<>(); 
		// 각 줄은 최대 100글자. integer의 범위를 넘어가므로 BigInteger 사용
		StringBuilder number = new StringBuilder(); // 숫자를 저장할 StringBuilder
		for (int i = 0; i < round; i++) {
			String line = br.readLine(); 
			String regex = ".*\\d.*"; // 숫자가 포함된 줄만 추출
			boolean matches = line.matches(regex); // 정규식과 일치하는지 확인
			if(!matches) { 
				continue; // 숫자가 포함되지 않은 경우 다음 줄로 넘어감
			}

			int length = line.length();
			for (int j = 0; j < length; j++) {
				char ch = line.charAt(j);

				if(Character.isDigit(ch)) { // 숫자인 경우
					number.append(ch); // StringBuilder에 추가
				} else {
					if (number.length() > 0) { // 숫자가 있는 경우
						numbers.add(new BigInteger(number.toString())); 
						// BigInteger로 변환하여 리스트에 추가
						number.setLength(0); // StringBuilder 초기화
					}
				}
			}

			// 마지막 숫자가 있는 경우
			if (number.length() > 0) { 
				numbers.add(new BigInteger(number.toString()));
				number.setLength(0);
			}
		}

		// 정렬 후 출력
		numbers.stream().sorted().forEach(System.out::println);

	}
}


