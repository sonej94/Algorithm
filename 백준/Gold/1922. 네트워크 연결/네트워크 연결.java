import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    
    static int arr[];
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        
        int networks[][] = new int[m][3];
        StringTokenizer st;
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            networks[i][0] = Integer.parseInt(st.nextToken());
            networks[i][1] = Integer.parseInt(st.nextToken());
            networks[i][2] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(networks, Comparator.comparingInt(o -> o[2])); //정렬

        int res = 0;
        for (int[] network : networks) {
            if (union(network[0], network[1])) { 
                res += network[2];
            }
        }
        
        bw.write(res + "\n");
        bw.flush();
    }
    
    static int find(int a) { // 탐색
        if (a == arr[a]) {
            return a;
        }
        return arr[a] = find(arr[a]);
    }

    static boolean union(int from, int to) { // 병합
        int a = find(from);
        int b = find(to);
        if (a != b) { 
            arr[a] = b;
            return true;
        }
        return false;
    }
}