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
		int K = Integer.parseInt(st.nextToken());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int[] plant =new int[N];
		Arrays.fill(plant, K);
		
		int day = 1;
		while(true) {
			
			int minWater = Integer.MAX_VALUE;
            int minIndex = 0;

            for(int i=0; i<=N-A; i++) {
            	int sum =0;
            	for (int j = i; j < i + A; j++) {
            		sum += plant[j];
            	}
            	if(sum < minWater) {
            		minWater = sum;
            		minIndex = i;
            	}
            }
            for(int i =minIndex; i< minIndex + A; i++) {
            	plant[i] +=B;
            }
            
            for(int i=0; i<N; i++){
            	plant[i]--;
            	
            	if(plant[i] <= 0) {
            		System.out.println(day);
            		return;
            	}
            }
           day++;
		}
		
	}
}