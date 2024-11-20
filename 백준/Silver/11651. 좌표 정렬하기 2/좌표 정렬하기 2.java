import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        
        int[][] list = new int[N][2];
        
        for(int i=0; i<N; i++){
        	
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	list[i][0] = Integer.parseInt(st.nextToken());
        	list[i][1] = Integer.parseInt(st.nextToken());
        }	
        
        Arrays.sort(list, Comparator.comparingInt((int[] e) -> e[1]) // y값 기준 정렬
                .thenComparingInt(e -> e[0]));  // y값이 같으면 x값 정렬

        		
    	for(int i = 0 ; i< N ; i++) {
    		 sb.append(list[i][0]).append(" ").append(list[i][1]).append('\n');
    	}
    	System.out.println(sb);
    }
}