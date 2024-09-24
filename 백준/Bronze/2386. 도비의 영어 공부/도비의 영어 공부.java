import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			String line = br.readLine();
			if (line.equals("#")) {
				break;
			}

			String[] st = line.split(" ");
			char s = st[0].toLowerCase().charAt(0);
			String text = line.substring(2).toLowerCase();
			int cnt = 0;

			for (int i = 0; i < text.length(); i++) {
				if (text.charAt(i) == s) {
					cnt++;
				}
			}
			sb.append(s).append(" ").append(cnt).append("\n");
		}
		System.out.print(sb);
	}
}