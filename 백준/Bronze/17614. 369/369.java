import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static int fnc(int num) {
		
		int cnt = 0;
		int n =0; 
		while(num>0){
			n = num % 10;
			num = num/10;
			if(n == 3 || n==6 || n==9) {
				cnt++;
			}
		}
		
		return cnt;
	}
	
	
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String st = br.readLine();
		int N = Integer.parseInt(st);
		int result = 0;
		
		for(int i=1; i<=N; i++) {
			result += fnc(i);
		}
		
		System.out.println(result);

	}
}