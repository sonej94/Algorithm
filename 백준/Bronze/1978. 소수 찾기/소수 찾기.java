import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static boolean TF(int num) {

		if(num<2) {
			return false;
		}
		for (int i = 2; i < num; i++) {

			if (num % i == 0) {
				return false;
			}
		}

		return true;
	}

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		String[] st = br.readLine().split(" ");

		int[] list = new int[N];
		int cnt=0;
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st[i]);
			if(TF(list[i])) {
				cnt++;
			}
		}

		System.out.println(cnt);
	}
}