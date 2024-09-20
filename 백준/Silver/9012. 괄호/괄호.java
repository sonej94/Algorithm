import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		for (int t = 0; t < N; t++) {

			String[] st = br.readLine().split("");
			Stack<String> stack = new Stack<>();
			boolean F = true;

			for (int i = 0; i < st.length; i++) {

				if (st[i].equals("(")) {
					stack.push(st[i]);
				} else if (st[i].equals(")")) {
					if (stack.isEmpty()) {
						F = false;
						break;
					}
					stack.pop();
				}
			}

			if (F && stack.isEmpty()) {
				System.out.println("YES");

			} else {
				System.out.println("NO");
			}
		}
	}
}