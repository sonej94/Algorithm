import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= T; tc++) {
            
            int N = Integer.parseInt(br.readLine());
            int[] tree = new int[N];
            int maxH = 0;
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                tree[i] = Integer.parseInt(st.nextToken()); 
                maxH = Math.max(maxH, tree[i]);
            }
             
            int odd = 0;
            int even = 0;
            
            for (int i = 0; i < N; i++) {
                int growth = maxH - tree[i];
                even += growth / 2; 
                odd += growth % 2;
            }
             
            if (even > odd) {
                while (Math.abs(even - odd) > 1) {
                    even -= 1;
                    odd += 2;
                }
            }
            
            int minDays;
            if (odd > even) {
                minDays = odd * 2 - 1;
                
            } else if (even > odd) {
                minDays = even * 2;
                
            } else {
                minDays = even + odd;
            }
            
            System.out.println("#" + tc + " " + minDays);
        }
    }
}
