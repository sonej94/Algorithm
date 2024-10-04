import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringBuilder sb = new StringBuilder();
	
	int L = Integer.parseInt(br.readLine());
	int N = Integer.parseInt(br.readLine());
	
	int p = 0;
	int k = 0;
	int m = 0;
	int[] arr= new int[L+1];
	int[] cnt = new int[N+1];
	
	int maxP = 0;
	int result =0;
	int reMaxP = 0;
	
	for(int i=1; i<=N; i++) {
		String[] st = br.readLine().split(" ");
		p = Integer.parseInt(st[0]);
		k = Integer.parseInt(st[1]);
		
		if (k - p > m) {
            m = k - p;
            maxP = i;
        }

		for( int j= p; j<=k; j++) {
			if(arr[j]==0){
				arr[j] = i;			
				cnt[i]++;
			}
		
		}
	}

	for(int i=1; i<=N; i++){
		if(cnt[i]>result) {
			result = cnt[i];
			reMaxP = i;
		}
		
	}
	System.out.println(maxP);
	System.out.println(reMaxP);
		
	}
}
