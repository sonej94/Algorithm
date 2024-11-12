import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	
	private static class Node {
		
		int Y, X;
		
		public Node(int Y, int X){
			
			this.Y = Y;
			this.X = X;
		}
	}
	
	private static int[] dy = {-1,1,0,0};
	private static int[] dx = {0,0,1,-1};
	
	private static boolean[] used;
	private static int Y, X;
	private static int answer;
	private static char[][] map;
	
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        map = new char[Y][X];
        
        answer =0;
        
        for(int i=0; i<Y; i++) {
        	map[i] = br.readLine().toCharArray();
        }
        
        used = new boolean['Z' - 'A'+1];
        
        used[map[0][0] - 'A'] = true;
        backtrack( new Node(0, 0), 1);
        
        System.out.println(answer);
	}
    
    private static void backtrack(Node now, int cnt) {
    	
    	answer = Math.max(answer, cnt);
    	
    	for(int i=0; i<4; i++){
    		int ny = now.Y + dy[i];
    		int nx = now.X + dx[i];
    		
    		if(ny < 0 || nx <0 || ny>= Y || nx>= X) {
    			continue;
    		}
    		if(used[map[ny][nx] - 'A']) {
    			continue;
    		}
    		
    		used[map[ny][nx] - 'A'] = true;
    		backtrack(new Node(ny, nx), cnt+1);
    		used[map[ny][nx] - 'A'] = false;

    	}
    }
}