import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken()); 

        int[] minWeight = new int[n];
        int[] weightUp = new int[n]; 

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            minWeight[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            weightUp[i] = Integer.parseInt(st.nextToken());
        }

        long cnt = 0;
        long now = 0;

        for (int i = 0; i < n; i++) {
            now += weightUp[i];

            if (now < minWeight[i]) {
                long need = (minWeight[i] - now + x - 1) / x;
                
                if (cnt >= need) {
                    cnt -= need;
                    now += need * x;
                } else {
                    cnt = -1;
                    break;
                }
            } else {
                long extra = (now - minWeight[i]) / x;
                cnt += extra;
                now -= extra * x;
            }
        }

        System.out.println(cnt);
    }
}
