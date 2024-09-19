import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String st = br.readLine();
		String[] stli = br.readLine().split(" ");
		int N = Integer.parseInt(st);
		int[] list = new int[N];
		int M = 0;
		float add = 0;

		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(stli[i]);
			if (list[i] > M) {
				M = list[i];
			}
		}

		for (int i = 0; i < N; i++) {
			add += (float) list[i] / M * 100;
		}
		float result = add / N;

		System.out.println(result);
	}
}
