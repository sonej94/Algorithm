import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	 public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int[][] flowers = new int[N][4];

		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<4; j++){
				flowers[i][j] =Integer.parseInt(st.nextToken());
			}
		}
		
		Arrays.sort(flowers, (a,b) -> {
			int startA = a[0] * 100 + a[1];
			int startB = b[0] * 100 + b[1];
			
			if(startA == startB) {
				int endA = a[2] * 100 + a[3];
				int endB = b[2] * 100 + b[3];
				return endB - endA;
			}
			return startA - startB;
		});
		
		int start = 301;
		int end = 1201;
		int cnt =0;
		int max = 0;
		int idx = 0;

		while(start < end) {
			boolean flag = false;
			
			while(idx < N) {
				int nowS = flowers[idx][0]* 100 + flowers[idx][1];
				int nowE = flowers[idx][2]*100 + flowers[idx][3];
				
				if(nowS > start) break;
				
				max = Math.max(max, nowE);
				flag = true;
				idx++;
			}
			
			if(!flag || max <= start) {
				cnt = 0;
				break;
			}
			
			start = max;
			cnt++;
		}
		System.out.println(cnt);

	}
}