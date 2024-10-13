import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int N = Integer.parseInt(br.readLine());
    	int total = 0;
    	int maxUp = 0;
    	String maxName = "";
    	
    	for(int i=0; i<N; i++){
    		String name = br.readLine();
    		String[] st = br.readLine().split(" ");
    		int need = Integer.parseInt(st[0]);
    		int myCandy = Integer.parseInt(st[1]);
    		
    		int up = 0;
    		while(myCandy >= need) {
    			up++;
    			myCandy = myCandy - need +2;
    		}
    		
    		total += up;
    		
    		if(up > maxUp) {
    			maxUp = up;
    			maxName = name;
    		}
     	}

       System.out.println(total);
       System.out.println(maxName); 
    }
}