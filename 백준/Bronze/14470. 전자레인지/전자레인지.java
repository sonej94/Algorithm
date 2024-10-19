import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		int D = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		if(A < 0) {
			cnt = C * (Math.abs(A)-0);
			cnt += D;
			cnt +=  E*(B-0);
		}else if(A == 0) {
			cnt = D;
			cnt +=  E*(B-0);
		}else if(A > 0) {
			cnt = E*(B-A);
		}

		System.out.print(cnt);
	}

}