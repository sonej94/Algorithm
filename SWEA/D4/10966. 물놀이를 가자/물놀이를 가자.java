import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static int[] dy = {-1, 0 , 1, 0};
    static int[] dx = {0, 1, 0, -1};
    
    static int N, M;
    static char[][] map;
    static int[][] dist;
    static Queue<Point> qu;
    
    static class Point {
        int y, x;
        
        Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        for(int tc=1; tc<=T; tc++){
        	
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	N = Integer.parseInt(st.nextToken());
        	M = Integer.parseInt(st.nextToken());
        	
        	 map = new char[N][M];
             dist = new int[N][M];
             qu = new LinkedList<>();  
        	
        	for(int i=0; i<N; i++){
        		String line = br.readLine();
        		for(int j=0; j<M; j++) {
        			map[i][j] = line.charAt(j);
        			dist[i][j] = -1;
        			
        			if(map[i][j] == 'W') {
        				qu.offer(new Point(i,j));
        				dist[i][j] = 0;
        			}
        		}
        	}
        	
        	BFS();
        	
        	int result = total();
        	System.out.println("#"+ tc +" " + result);
        }

    }
    
    static boolean check(int y, int x) {
    	return y >= 0 && x>= 0 && y<N && x< M;
    }
    
    static int total() {
    	int sum = 0;
    	
    	for(int i=0; i<N; i++) {
    		for(int j=0; j<M; j++) {
    			
    			if(map[i][j] == 'L') {
    				sum += dist[i][j];
    			}
    		}
    	}
		return sum;
    }
    
    static void BFS() {
    	while( !qu.isEmpty() ) {
    		
    		Point now = qu.poll();
    		
    		for(int dr = 0; dr <4; dr++){
    			int ny = now.y + dy[dr];
    			int nx = now.x +dx[dr];
    			
    			if(check(ny,nx) && dist[ny][nx] == -1){
    				dist[ny][nx] = dist[now.y][now.x] +1;
    				qu.offer(new Point(ny, nx));
    			}
    		}
    	}
    }

}