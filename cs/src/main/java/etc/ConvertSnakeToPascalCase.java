package etc;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ConvertSnakeToPascalCase {

    public static void main(String[] args) throws IOException {
        convertSnakeToPascalCase("");
    }


    public static void convertSnakeToPascalCase(String snakeCase) {
        String pascalCase = Arrays.stream(snakeCase.split("_"))
                .filter(s -> !s.isEmpty())
                .map(s -> Character.toUpperCase(s.charAt(0)) + s.substring(1))
                .collect(Collectors.joining());

        System.out.println(pascalCase);
    }

}
