import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());

		for (int i = 0; i < count; i++) {
			String chromosome = br.readLine();
			String regex = "^[A-F]?A+F+C+[A-F]?$";

			if(chromosome.matches(regex)) {
				System.out.println("Infected!");
			} else {
				System.out.println("Good");
			}

		}
    }
}