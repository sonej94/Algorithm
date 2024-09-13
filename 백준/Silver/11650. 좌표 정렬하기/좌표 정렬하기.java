import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main{

	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] list = new int[N][2];

		for (int i = 0; i < N; i++) {
			String[] st = br.readLine().split(" ");
			int x = Integer.parseInt(st[0]);
			int y = Integer.parseInt(st[1]);

			list[i][0] = x;
			list[i][1] = y;
		}

		Arrays.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] lis1, int[] lis2) {
				return lis1[0] != lis2[0] ? lis1[0] - lis2[0] : lis1[1] - lis2[1];
			}
		});

		for (int i = 0; i < N; i++) {
			System.out.print(list[i][0] + " " + list[i][1] + "\n");
		}
	}
}