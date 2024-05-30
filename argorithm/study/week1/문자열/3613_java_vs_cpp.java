import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Character.toLowerCase;
import static java.lang.Character.toUpperCase;


class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		char[] charArray = s.toCharArray();

		if (isJavaStyle(s)) { // Java 형식인 경우
			System.out.println(toSnakeCase(charArray)); // Java -> C++
		} else if (isCppStyle(s)) { // C++ 형식인 경우
			System.out.println(toCamelCase(charArray)); // C++ -> Java
		} else {
			System.out.println("Error!"); // 형식이 잘못된 경우
		}
	}
    
    // Java 형식인지 확인
    private static boolean isJavaStyle(String name) {
        return name.matches("[a-z]+([A-Z][a-z]*)*"); 
    }

    // C++ 형식인지 확인
    private static boolean isCppStyle(String name) {
        return name.matches("[a-z]+(_[a-z]+)*"); 
    }

	public static String toCamelCase(char[] charArray) {
		StringBuilder result = new StringBuilder();
		boolean tag = false;

		for (char c : charArray) {

			if(c == '_') { // '_'가 나오면 
				tag = true; // 다음 문자를 대문자로 바꿔준다.
				continue;
			}

			if(tag) {
				c = toUpperCase(c); 
				tag = false;
			}

			result.append(c);
		}

		return result.toString();
	}

	public static String toSnakeCase(char[] charArray) {
		StringBuilder result = new StringBuilder();

		for (char c : charArray) {
			if(Character.isUpperCase(c)) { // 대문자인 경우
				result.append("_"); // '_'를 추가하고 소문자로 변환
				c = toLowerCase(c);
			}

			result.append(c);
		}

		return result.toString();
	}
}