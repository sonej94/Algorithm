import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	
	static int N;
	static int[][] map;	
	static ArrayList<Core> coreList;

	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};

	static int maxCore;
	static int minLine;
	
	static class Core{
		int y, x;
		public Core(int y, int x) {
			this.y = y;
			this.x = x;
		}
	} 
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			coreList = new ArrayList<>();
			 
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
					for(int j=0; j<N; j++){
						map[i][j] = Integer.parseInt(st.nextToken());
						
						if(map[i][j] == 1) {
							if( i != 0 && i != N-1 && j != 0 && j != N-1 ) {
								coreList.add(new Core(i, j));
							}
						}	
				}
			}
			maxCore = 0;
            minLine = Integer.MAX_VALUE;
            
            DFS(0, 0, 0);
			
			
			System.out.println("#"+tc+" "+ minLine);
		}
	}
	
	public static void DFS(int index, int coreCnt, int lineLen) {
		
		if( index == coreList.size()) {
			if(coreCnt > maxCore ){
				maxCore = coreCnt;
				minLine = lineLen;
			}else if(coreCnt == maxCore) {
				minLine = Math.min(minLine, lineLen);
			}
			return;				
		}
		
		Core now = coreList.get(index);
		
		for(int dir =0; dir < 4; dir++){
			
			if( possible(now.y, now.x, dir)) {
				
				int lines = setLine(now.y, now.x, dir, 2);
				DFS(index +1, coreCnt +1, lineLen + lines);
				setLine(now.y, now.x, dir, 0);
			}
		}
		DFS(index + 1, coreCnt, lineLen);
	
	}
	
	static boolean possible(int y, int x, int dir) {
		
		y += dy[dir];
		x += dx[dir];
		
		while( y >= 0 && y<N && x>=0 && x<N){
			
			if(map[y][x] != 0) return false;
			y += dy[dir];
			x += dx[dir];
		}
		return true;		
	}
	
	static int setLine(int y, int x, int dir, int value){
		int cnt =0;
		y += dy[dir];
		x += dx[dir];
		
		while( y >= 0 && y<N && x>= 0 && x<N){
			map[y][x] = value;
			cnt++;
			y += dy[dir];
			x += dx[dir];
		}
		return cnt;
	}

}