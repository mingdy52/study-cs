import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


/**
    2531 컨베이어 벨트 스시
    1. 벨트의 임의의 한 위치부터 k개의 접시를 연속해서 먹을 경우 할인된 정액 가격으로 제공
    2. 초밥의 종류 하나가 쓰인 쿠폰을 발행하고, 
        1번 행사에 참가할 경우 이 쿠폰에 적혀진 종류의 초밥 하나를 추가로 무료로 제공

    회전 초밥 음식점의 벨트 상태, 메뉴에 있는 초밥의 가짓수, 연속해서 먹는 접시의 개수
    , 쿠폰 번호가 주어졌을 때, 손님이 먹을 수 있는 초밥 가짓수의 최댓값을 구하는 문제
*/
class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] q = br.readLine().split(" ");
		int n = Integer.parseInt(q[0]); // 접시의 수
		int k = Integer.parseInt(q[2]); // 연속해서 먹는 접시의 개수
		int c = Integer.parseInt(q[3]); // 쿠폰 번호

		int[] sushies = new int[n];
		for (int i = 0; i < n; i++) {
            // 초밥의 종류를 int로 변환해서 sushies에 저장
			sushies[i] = Integer.parseInt(br.readLine());
		}

		int current	= 0;

        // 초밥의 종류를 key로, 개수를 value로 저장
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < k; i++) { // 연속해서 먹을 접시의 개수만큼 반복 
            // 초밥의 종류와 개수를 map에 저장
			map.put(sushies[i], map.getOrDefault(sushies[i], 0) + 1);

            // 초밥 개수가 1이라면
			if(map.get(sushies[i]) == 1) {
                // 초밥 가짓수 증가
				current++;
			}
		}

		int max = current;
		for (int i = 0; i < n; i++) { // 접시의 수만큼 반복(회전해서 돌아오니까)
			int out = sushies[i]; // 빠져나가는 초밥
			int in = sushies[(i + k) % n]; // 들어오는 초밥

            // 빠져나가는 초밥의 개수를 1 감소
			map.put(out, map.get(out) - 1);
			if(map.get(out) == 0) { // 빠져나가는 초밥의 개수가 0이라면
				map.remove(out); // map에서 제거
				current--; // 초밥 가짓수 감소
			}

            // 들어오는 초밥의 개수를 1 증가
			map.put(in, map.getOrDefault(in, 0) + 1);
			if(map.get(in) == 1) { // 들어오는 초밥의 개수가 1이라면
				current++; // 초밥 가짓수 증가
			}

            // 쿠폰 처리
			if(map.containsKey(c)) {
				max = Math.max(max, current);
			} else {
				max = Math.max(max, current  + 1);
			}
		}
		System.out.println(max);
	}
}