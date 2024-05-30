import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
	9996 파일명이 검색 패턴과 일치하는지 확인하는 문제
	DA: YES
	NE: NO
*/
class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int round = Integer.parseInt(br.readLine());
		String pattern = br.readLine().toLowerCase();

		int astIndex = pattern.indexOf("*"); // *의 인덱스
		String prefix = pattern.substring(0, astIndex); // * 이전 문자열
		String suffix = pattern.substring(astIndex + 1); // * 이후 문자열

		StringBuilder result = new StringBuilder();

		for (int i = 0; i < round; i++) {
			String fileName = br.readLine();

			boolean match = isMatch(prefix, suffix, fileName); // 파일명이 패턴과 일치하는지 확인
			
			if(match) {
				result.append("DA\n");
			} else {
				result.append("NE\n");
			}
		}

		System.out.println(result);

	}
	
	public static boolean isMatch(String prefix, String suffix, String fileName) {
		if(fileName.length() < prefix.length() + suffix.length()) { // 파일명이 패턴보다 짧은 경우 false
			return false;
		}
		
		return fileName.startsWith(prefix) && fileName.endsWith(suffix);
	}


}
