import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Node implements Comparable<Node> {
		
		int y,x,cost;
		
		Node(int y, int x, int cost){
			this.y = y;
			this.x = x;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}
		
	}
	
	static int N;
	static int[][] map;
	static int[][] dist;
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0 , 0 ,1, -1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = 1;
		
		while(true) {
			
			N = Integer.parseInt(br.readLine());

			if(N == 0) break;
			
			map = new int[N][N];
            dist = new int[N][N];
			
			for(int i =0; i<N; i++){
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++){
					map[i][j] = Integer.parseInt(st.nextToken());
					dist[i][j] = Integer.MAX_VALUE;
				}
			}
			
			dijkstra();
			
			sb.append("Problem ").append(tc).append(": ").append(dist[N-1][N-1]).append("\n");			
			tc++;
		}
		System.out.println(sb.toString());
	}

	static void dijkstra() {
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(0, 0, map[0][0]));
		
		dist[0][0] = map[0][0];
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			int y = now.y;
			int x = now.x;
			int cost = now.cost;

			if(cost > dist[y][x]) continue;
			
			for(int i=0; i<4; i++){
				
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if(ny <0 || nx < 0 || ny>= N || nx >= N) continue;
				
				int newCost = map[ny][nx] + cost;
				
				if(newCost < dist[ny][nx]) {
					dist[ny][nx] = newCost;
					pq.offer(new Node(ny, nx, newCost));

				} 
			}

		}

	}

}
