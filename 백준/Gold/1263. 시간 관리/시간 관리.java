import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        int N = Integer.parseInt(br.readLine());
        int[][] todo = new int[N][2];
        
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            todo[i][0] = Integer.parseInt(st.nextToken());
            todo[i][1] = Integer.parseInt(st.nextToken()); 
        }
        Arrays.sort(todo, (a, b) -> b[1] - a[1]);
        
        int curTime = todo[0][1];
        
        for (int i = 0; i < N; i++) {
           
            if (curTime > todo[i][1]) {
                curTime = todo[i][1];
            }
            curTime -= todo[i][0]; 
            

            if (curTime < 0) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(curTime);
    }
}
