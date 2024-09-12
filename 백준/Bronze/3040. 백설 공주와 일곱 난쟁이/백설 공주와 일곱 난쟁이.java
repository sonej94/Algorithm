import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] list = new int[9];
		int add = 0;

		for (int i = 0; i < 9; i++) {
			list[i] = Integer.parseInt(br.readLine());
			add += list[i];
		}

		for (int i = 0; i < 9; i++) {
			for (int j = i+1; j < 9; j++) {

				if (add - list[i] - list[j] == 100) {

					for (int k = 0; k < 9; k++) {

						if (list[k] != list[i] && list[k] != list[j]) {
							System.out.println(list[k]);

						}

					}

				}

			}
		}

	}
}