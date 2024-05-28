import java.util.Scanner;

class Main {
    public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		char[][] words = charProcess(s); // 입력된 문자열을 2차원 배열로 저장
		String print = verticalRead(words); // 세로로 읽은 문자열
		System.out.print(print);
	}

	public static char[][] charProcess(Scanner s) {
		char[][] words = new char[5][15];

		for(int i = 0; i < 5; i++) {
			String word = s.nextLine();
			for (int j = 0; j < word.length(); j++) {
				words[i][j] = word.charAt(j);
			}
		}

		return words;
	}

	public static String verticalRead(char[][] words) {
		StringBuffer sb = new StringBuffer();

		for(int i = 0; i < 15; i++) {
			for (int j = 0; j < 5; j++) {
				if (i < words[j].length  && words[j][i] != '\u0000') { // null 문자 제거
					sb.append(words[j][i]);
				}
			}
		}

		return sb.toString();
	}

    // 시간 복잡도: O(1) 
}