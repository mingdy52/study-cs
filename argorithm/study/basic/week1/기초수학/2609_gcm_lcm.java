import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
	2609 두 수의 최대공약수와 최소공배수를 구하는 문제
*/
class Main {
    public static void main(String[] args) throws IOException {
  		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num = br.readLine();
		String[] s = num.split(" ");

		int a = Integer.parseInt(s[0]);
		int b = Integer.parseInt(s[1]);

		int gcm = getGcm(a, b);
		int lcm = getLcm(a, b, gcm);
		System.out.println(gcm);
		System.out.println(lcm);

	}

	public static int getGcm(int a, int b) {
        // 유클리드 호제법
        // a를 b로 나눈 나머지를 r이라고 했을 때 a와 b의 최대공약수는 b와 r의 최대공약수와 같다.
		while(b != 0) {
			int temp  = b;
			b = a % b;
			a = temp;
		}

		return  a;
	}

	public static int getLcm(int a, int b, int gcm) {
        // 최소공배수는 두 수의 곱을 최대공약수로 나눈 값과 같다.
		return a * b / gcm;
	}
}