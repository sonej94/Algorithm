import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int[] sizes = new int[6];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            sizes[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        
        int ts = 0;
        for (int size : sizes) {
            ts += size/T;
            if (size % T > 0) ts++;
        }   
            
        int pens = N/P;    
        int pen = N%P;
        
        bw.write(ts + "\n");
        bw.write(pens + " " + pen);
        bw.flush();
    }
}