import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Integer> stack = new ArrayDeque<>();

		int k = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < k; i++) {
			int  n = Integer.parseInt(br.readLine());
			if(n== 0) {
				stack.pop();
			}else {
				stack.push(n);
			}
		}
		
		int result = 0;
		int size = stack.size();
		for(int i =0; i<size; i++) {
			result += stack.pop();
		}

		System.out.println(result);
	}
}
