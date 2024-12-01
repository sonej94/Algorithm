import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int N, K, cnt;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++){
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arr = new int[N];
			cnt = 0;
			
			st = new StringTokenizer(br.readLine());
			for(int i =0 ;i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			fnc(0,0);

			System.out.println( "#"+ tc + " " + cnt);
		}
	}
	
	public static void fnc(int index, int totalSum) {
		
		if(index == N) {
			
			if(totalSum == K) {
				cnt++;
			}
			return;
		}
		
		fnc(index+1, totalSum);
		
		fnc(index+1, totalSum + arr[index]);

	}

}