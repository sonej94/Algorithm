import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int A = Integer.parseInt(br.readLine());
        
        int result = 0;
        int startA= A;
        for(int i=0; i<N; i++){
        	int nextA = Integer.parseInt(br.readLine());
        	
        	int ex1 = Math.abs(nextA - startA);
        	int ex2 = 360 - ex1;
        	
        	result += Math.min(ex1,ex2);
        	startA = nextA;
        }
        
        System.out.print(result);
    }
}