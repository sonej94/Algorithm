import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.io.IOException;

public class Main {

	public static int[] dy = {1, 0, -1, 0};
	public static int[] dx = {0, 1, 0, -1};
	public static int n, m;
	public static int[][] map;
	public static boolean[][] visited;
	
    public static void main(String[] args) throws IOException {
        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String[] st = br.readLine().split(" ");
    	
    	n = Integer.parseInt(st[0]);
    	m = Integer.parseInt(st[1]);
    	
    	int cnt = 0;
    	int maxNer = 0;
    	
    	map = new int[n][m];
    	visited = new boolean[n][m];
    	
    	for(int j = 0; j<n; j++ ){
    		String[] s = br.readLine().split(" ");
    		for(int i =0; i<m; i++){
    			map[j][i] = Integer.parseInt(s[i]);
    		}
    	}
    	
    	for(int j = 0; j<n; j++ ){
    		for(int i =0; i<m; i++){
    			if(map[j][i] == 1 && !visited[j][i]) {
    				cnt++;
    				int area = bfs(j,i);
    				maxNer = Math.max(maxNer, area);
    			}
			}
		}
    	
    	System.out.println(cnt);
    	System.out.println(maxNer);
       
    }
    
    public static int bfs(int startY, int startX) {
    	Queue<int[]> queue = new LinkedList<>();
    	queue.offer(new int[] {startY, startX});
    	visited[startY][startX] = true;
    	int area = 1;
    	
    	while(!queue.isEmpty()) {
    		int[] now = queue.poll();
    		int y = now[0];
    		int x = now[1];
    		
    		for(int i= 0; i<4; i++){
    			int ny = y + dy[i];
    			int nx = x + dx[i];
    			
    			if(ny >= 0 && ny < n && nx >= 0 && nx<m && map[ny][nx] == 1 && !visited[ny][nx]){
    				queue.offer(new int[] {ny, nx});
    				visited[ny][nx] = true;
    				area++;
    			}
    		}		
    	}	
    	return area;
    }
}