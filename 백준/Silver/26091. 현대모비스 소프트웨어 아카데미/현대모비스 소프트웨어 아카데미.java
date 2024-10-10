import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] st = br.readLine().split(" ");
        int N = Integer.parseInt(st[0]);
        int M = Integer.parseInt(st[1]);
        
        String[] t = br.readLine().split(" ");     
        int[] stat =new int[N];
        
        for(int i=0; i<N; i++) {
        	stat[i] = Integer.parseInt(t[i]);
        }
        
        
        Arrays.sort(stat);
        
        int cnt = 0;
        int left = 0;
        int right = N-1;
        
        while(left<right){
        	if( stat[left] + stat[right] >= M ) {
        		cnt++;
        		left++;
        		right--;
        	}else {
        		left++;
        	}
        }

        System.out.print(cnt);
    }
}
