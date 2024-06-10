import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
	10798 5개의 단어를 입력받아 세로로 읽었을 때의 문자열을 출력하는 문제
*/
class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[][] board = new char[5][15]; // 5개의 단어를 입력받아 세로로 읽었을 때의 문자열을 저장할 배열

		for (int i = 0; i < 5; i++) {
			String word = br.readLine();
			for (int j = 0; j < word.length(); j++) { 
				board[i][j] = word.charAt(j); // 입력받은 단어를 배열에 저장
			}
		}

		StringBuilder result = new StringBuilder();
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 5; j++) { // 세로로 읽기
				if(0 < board[j].length && board[j][i] != '\u0000') { // 배열의 길이가 0보다 크고, null이 아니면 결과에 추가
					result.append(board[j][i]);
				}
			}
		}

		System.out.println(result);
	}

}