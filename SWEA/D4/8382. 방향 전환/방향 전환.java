import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution{

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        for(int tc=1; tc<=T; tc++){
        	
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int startX = Integer.parseInt(st.nextToken());
        	int startY  = Integer.parseInt(st.nextToken());
        	int endX = Integer.parseInt(st.nextToken());
        	int endY = Integer.parseInt(st.nextToken());
        	
        	int X = Math.abs(endX - startX); 
        	int Y = Math.abs(endY - startY);
        	
        	int t = (X+Y)/2;
        	int result = t*2 + Math.abs(X-t) + Math.abs(Y-t);

        	System.out.println("#"+ tc+" " + result);
        }
    }

}