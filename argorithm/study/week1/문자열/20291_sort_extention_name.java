import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
	20291 파일명을 입력받아 확장자별로 정렬하여 확장자와 그 개수를 출력하는 문제
*/
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
		int fileCount = Integer.parseInt(br.readLine());
		
		Map<String, Integer> map = new HashMap<>(); // 확장자와 그 확장자의 개수를 저장
		TreeSet<String> sortedExtensions = new TreeSet<>(); // 확장자 이름을 정렬하기 위한 TreeSet
		
		for(int i = 0; i < fileCount; i++) {
			String fileName = br.readLine();
			String extension = fileName.substring(fileName.indexOf(".") + 1); // 확장자만 추출
			map.put(extension, map.getOrDefault(extension, 0) + 1); // 확장자가 이미 있으면 개수를 1 증가, 없으면 1로 초기화

			sortedExtensions.add(extension); // TreeSet에 확장자 추가
		}

		for(String key : sortedExtensions) {
			System.out.println(key + " " + map.get(key)); // 확장자 이름과 그 확장자의 개수 출력
		}
    }
}