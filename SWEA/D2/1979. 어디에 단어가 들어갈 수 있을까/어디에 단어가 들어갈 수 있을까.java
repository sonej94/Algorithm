import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int N, K;
	static int[][] arr;
	
	
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int T = Integer.parseInt(br.readLine());

        for (int tc= 1; tc<= T; tc++) {

        	StringTokenizer st = new StringTokenizer(br.readLine());
    		N = Integer.parseInt(st.nextToken());
    		K = Integer.parseInt(st.nextToken());
    		
    		arr = new int[N][N];
    		
    		for(int i=0; i<N; i++) {
    			st = new StringTokenizer(br.readLine());
    			for(int j=0; j<N; j++) {
    				arr[i][j] = Integer.parseInt(st.nextToken());
    			}
    		}
    		
    		
    		int cnt = garo() + sero();
    		
    		
    		System.out.println("#"+tc+" "+cnt);
        }

	}
	
	public static int garo() {
		int cnt =0; 
		int len =0;
		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				
				if(arr[i][j] == 1) {
					len++;
				}else {
					if(len == K){
						cnt++;
					}
					len =0;
				}
			}
			if(len == K) cnt++;
			len =0;
		}
		
		return cnt;
	}
	
	public static int sero() {
		int cnt =0; 
		int len =0;
		
		for(int j=0; j<N; j++){
			for(int i=0; i<N; i++){
				
				if(arr[i][j] == 1) {
					len++;
				}else {
					if(len == K){
						cnt++;
					}
					len =0;
				}
			}
			if(len == K) cnt++;
			len =0;
		}
		
		return cnt;
	}

}
