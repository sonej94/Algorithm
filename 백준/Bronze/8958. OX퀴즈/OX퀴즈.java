import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

	
		for (int i = 0; i < N; i++) {

			String txt = br.readLine();
			int cnt = 0;
			int result = 0;

			for (int j = 0; j < txt.length(); j++) {

				if (txt.charAt(j) == 'O') {
					cnt++;
					result += cnt;
				}else if (txt.charAt(j) == 'X') {
					cnt = 0;
				}

			}
			System.out.println(result);
		}

	}
}