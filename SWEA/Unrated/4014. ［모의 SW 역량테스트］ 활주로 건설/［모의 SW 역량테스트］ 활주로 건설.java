import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N, X, cnt;
    static int[][] map;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            
            map = new int[N][N];
            cnt = 0;
            
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            for(int i=0; i<N; i++){
                if (checkRow(i)) cnt++;
                if (checkCol(i)) cnt++;
            }

            sb.append("#").append(tc).append(" ").append(cnt).append("\n");
        }
        System.out.print(sb);
    }
    
    public static boolean checkRow(int row) {
        boolean[] inst = new boolean[N];
        
        for(int j=0; j<N-1; j++){
            int diff = map[row][j] - map[row][j+1];
            
            if (diff == 0) continue;
            if (Math.abs(diff) > 1) return false;
            
            if (diff == 1) {
                for (int k = 1; k <= X; k++) {
                    if(j+k >= N || inst[j+k] || map[row][j+1] != map[row][j+k]){
                        return false;
                    }
                    inst[j+k] = true;
                }
            } else {
                for (int k = 0; k < X; k++) {
                    if (j-k < 0 || inst[j-k] || map[row][j] != map[row][j-k]) {
                        return false;
                    }
                    inst[j-k] = true;
                }
            }
        }
        return true;
    }
    
    static boolean checkCol(int col) {
        boolean[] inst = new boolean[N];
        
        for (int i = 0; i < N-1; i++) {
            int diff = map[i][col] - map[i+1][col];
            
            if (diff == 0) continue;
            if (Math.abs(diff) > 1) return false;
            
            if (diff == 1) {
                for (int k = 1; k <= X; k++) {
                    if (i+k >= N || inst[i+k] || map[i+1][col] != map[i+k][col]) 
                        return false;
                    inst[i+k] = true;
                }
            } else {
                for (int k = 0; k < X; k++) {
                    if (i-k < 0 || inst[i-k] || map[i][col] != map[i-k][col]) 
                        return false;
                    inst[i-k] = true;
                }
            }
        }
        return true;
    }
}