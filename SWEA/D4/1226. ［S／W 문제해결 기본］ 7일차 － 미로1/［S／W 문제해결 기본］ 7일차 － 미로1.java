import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class Solution {

	public static int[] dy = {-1, 0, 1, 0};
	public static int[] dx = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc = 1; tc<=10; tc++) {

			int t = Integer.parseInt(br.readLine());

			int[][] map = new int[16][16];
			boolean[][] visited = new boolean[16][16];
			Queue<int[]> gil = new LinkedList<>();
			
			for(int i = 0; i<16; i++) {
				String[] st = br.readLine().split("");
				for(int j =0; j<16; j++) {
					map[i][j] = Integer.parseInt(st[j]);
					
					if(map[i][j] == 2) {
						gil.add(new int[] {i,j});
						visited[i][j] = true;
					}
				}
			}
			
			int result =0;
			while(!gil.isEmpty()) {
				int[] now = gil.poll();
				int y = now[0];
				int x = now[1];
				
				if(map[y][x] == 3) {
					result = 1;
					break;
				}

				for(int bang = 0; bang<4; bang++) {
					int newY = y + dy[bang];
					int newX = x + dx[bang];
					
					if(newY>=0 && newY<16 && newX>= 0 && newX<16) {
						if(!visited[newY][newX] && map[newY][newX] != 1){
							gil.add(new int[] {newY,newX});
							visited[newY][newX] = true;
						}
					}
					
				}
			}
			
			System.out.println("#"+t+" "+result);
		}//

	}
}