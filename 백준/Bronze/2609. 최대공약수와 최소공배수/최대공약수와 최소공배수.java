import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] t = br.readLine().split(" ");
		int n = Integer.parseInt(t[0]);
		int m = Integer.parseInt(t[1]);

		int result1 = 0;

		for (int i = 1; i <= Math.max(n, m); i++) {
			if (n % i == 0 && m % i == 0) {
				result1 = i;
			}
		}

		int result2 = (n * m) / result1;

		System.out.println(result1);
		System.out.println(result2);

	}

}
