import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static Boolean TF(int num) {

		if (num < 2) {
			return false;
		}
		for (int i = 2; i*i <= num; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] st = br.readLine().split(" ");

		int M = Integer.parseInt(st[0]);
		int N = Integer.parseInt(st[1]);

		for (int i = M; i <= N; i++) {
			if (TF(i)) {
				System.out.println(i);
			}
		}
	}
}