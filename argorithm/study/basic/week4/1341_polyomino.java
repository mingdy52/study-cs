import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
    1341 polyomino
    XXXX -> AAAA
    XX -> BB
    . -> .
*/
class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] ch = br.readLine().toCharArray(); // 보드판 입력
		int n = ch.length;

		List<String> board = converter(ch, n); // 변환된 보드판
		if(board.contains("-1")) { // 변환값에 -1이 있으면
			System.out.println(-1); // 불가능한 보드판
			return;
		}

		StringBuilder result = new StringBuilder();
		for (String s : board) {
			result.append(s);
		}
		System.out.println(result);
	}

	public static List<String> converter(char[] ch, int n) {
        // 변환된 보드판을 저장할 리스트
		List<String> board = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
            
			if(ch[i] != 'X') { 
                // .인 경우
				if(sb.length() != 0) { // sb에 값이 있으면 먼저 변환
					board.add(converter(sb.toString()));
					sb.setLength(0);
				}
				board.add(".");
			} else {
                // X인 경우
				sb.append(ch[i]); // sb에 X 추가
				if(sb.length() == 4) { // 4개가 되면 변환
					board.add(converter(sb.toString()));
					sb.setLength(0);
				}
			}
		}
		if (sb.length() > 0) { // sb에 남은 값이 있으면 변환
			board.add(converter(sb.toString()));
		}
		return board;
	}

	public static String converter(String code) {
		String cd;
		switch (code) {
			case "XXXX":
				cd = "AAAA";
				break;
			case "XX":
				cd = "BB";
				break;
			default:
				cd = "-1";
				break;
		}
		return cd;
	}
}