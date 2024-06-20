import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

/**
    2141 우체국 위치 구하기
    각 사람들까지의 거리의 합이 최소(중위값)에 우체국을 지음
    마을까지의 거리 아님.
*/
class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 마을의 수

        // 마을(key)를 순서대로 정렬하기 위해 TreeMap
		TreeMap<Integer, Integer> map = new TreeMap<>(); 
		long totalpop = 0; // 총 인구
		for (int i = 0; i < n; i++) {
			String[] s = br.readLine().split(" ");
			int vill = Integer.parseInt(s[0]); // 마을
			int pop = Integer.parseInt(s[1]); // 마을의 인구
			totalpop += pop;
			map.put(vill, pop);
		}

		long cumul = 0; // 누적 인구
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			cumul += entry.getValue(); // 마을 인구를 누적합

			if(cumul >= (totalpop+1)/2) { 
                // 누적합이 총인구의 절반보다 크면 그 마을에 우체국 건설
				System.out.println(entry.getKey());
				break;
			}

            /**
                총 인구에 1을 더해서 2로 나누는 이유: 중간 지점을 올바르게 계산하기 위해
                
                1. 짝수의 경우:
                총 인구수가 10이라면, 중간 지점은 (10 + 1) / 2 = 5.5가 되고 정수로 처리되기 때문에 5가 된다.
                이 경우 5명이 있는 지점까지의 거리를 최소화하려는 목적과 일치한다.
                
                2. 홀수의 경우:
                총 인구수가 11이라면, 중간 지점은 (11 + 1) / 2 = 6이 된다.
                중간값은 정확히 5.5지만, 정수 5로 처리된다.
                정수로는 6명이 되는 지점까지의 거리를 최소화하려는 목적과 일치한다.
            
            */
		}
	}
}