import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        System.out.println(fnc(N, K));
    }
	
	public static int fnc(int n, int k) {
		
		if( k == n || n == 0 ) {
			return 1;
		}
		
		return factorial(n) / ( factorial(k) * factorial(n-k));
	}

	public static int factorial(int n) {
		
		int result = 1;
		for(int i =2; i<= n; i++) {
			result *= i;
		}
		
		return result;
	}
}
