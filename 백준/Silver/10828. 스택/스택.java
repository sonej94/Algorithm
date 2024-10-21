import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> stack = new ArrayList<>();

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			String[] list = br.readLine().split(" ");

			switch (list[0]) {
			case "push":
				stack.add(Integer.parseInt(list[1]));
				break;
			case "pop":
				if (stack.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(stack.remove(stack.size() - 1)).append("\n");
				}
				break;
			case "size":
				sb.append(stack.size()).append("\n");
				break;
			case "empty":
				sb.append(stack.isEmpty() ? 1 : 0).append("\n");
				break;
			case "top":
				if (stack.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(stack.get(stack.size() - 1)).append("\n");
				}
				break;
			}
		}
		System.out.print(sb);
	}
}