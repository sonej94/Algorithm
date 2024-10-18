import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		
		for(int tc=0; tc<T; tc++) {
			int n = Integer.parseInt(br.readLine());
			int count = 0;
			
			for(int i=1; i*i<=n; i++){
				count++;
			}
			sb.append(count).append("\n");
		}
			System.out.print(sb.toString());
	}
}