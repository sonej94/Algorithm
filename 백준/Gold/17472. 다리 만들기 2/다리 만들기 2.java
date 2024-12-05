import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] map;
	static int landCnt = 2;
	static int[][] breideLen;
    static List<int[]>[] adjList;
	
	static int[] dy = { 1, 0, -1, 0 };
	static int[] dx = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		bfs();
		bridge();
		graph();
		
		int result = prim();
		
		System.out.println(result);
	}

	private static void bfs() {
		boolean[][] visited = new boolean[N][M];
		Queue<int[]> qu = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {

				if (map[i][j] == 1 && !visited[i][j]) {

					qu.offer(new int[] { i, j });
					visited[i][j] = true;
					map[i][j] = landCnt;

					while (!qu.isEmpty()) {
						int[] now = qu.poll();
						int y = now[0];
						int x = now[1];

						for (int dir = 0; dir < 4; dir++) {
							int ny = y + dy[dir];
							int nx = x + dx[dir];

							if ((ny >= 0 && ny < N && nx >= 0 && nx < M) && !visited[ny][nx] && map[ny][nx] == 1) {
								visited[ny][nx] = true;
								map[ny][nx] = landCnt;
								qu.offer(new int[] { ny, nx });
							}
						}
					}
					landCnt++;

				}
			}
		}
	}

	// 다리만들기
	private static void bridge() {
		breideLen = new int[landCnt][landCnt];
		for (int i = 0; i < landCnt; i++) {
		    Arrays.fill(breideLen[i], Integer.MAX_VALUE);
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {

				if (map[i][j] >= 2) {
					int from = map[i][j];

					for (int dir = 0; dir < 4; dir++) {
						
						int ny = i;
						int nx = j;
						int len = 0;
						
						while (true) {
							nx += dx[dir];
							ny += dy[dir];

							if (!(ny >= 0 && ny < N && nx >= 0 && nx < M)) break;
							
							if (map[ny][nx] == from) break;

							if (map[ny][nx] == 0) {
								
								len++;
								
							} else {
								
								int to = map[ny][nx];
								if (len >= 2) {
									if (breideLen[from][to] > len) {
										
										breideLen[from][to] = len;
										breideLen[to][from] = len;
									}
								}
								break;
							}
						}
					}
				}
			}
		}

	}

	// 간선찾기
	private static void graph() {
		
		adjList = new ArrayList[landCnt];
		for(int i=0; i<landCnt; i++ ) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int from = 2; from < landCnt; from++) {
			for(int to =2; to<landCnt; to++) {
				
				if( from != to && breideLen[from][to] != Integer.MAX_VALUE ) {
					int len = breideLen[from][to];
					
					// 인접 리스트
					adjList[from].add(new int[]{to, len});
					adjList[to].add(new int[] {from, len});
					
				}

			}
		}

	}

	// 프림
	private static int prim() {
		
		boolean[] visited = new boolean[landCnt];
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(Comparator.comparingInt(o -> o[1]));
//		 public int compare(int[] o1, int[] o2) {
//             return o1[1] - o2[1]; // 다리 길이를 기준으로 오름차순 정렬
//         }
		
		
		int totalLen = 0;
        int dari = 0;
		
        visited[2] = true;
        dari++;
        
        for (int[] edge : adjList[2]) {
            pq.offer(edge);
        }
        
        while (!pq.isEmpty()) {
            int[] currentEdge = pq.poll();
            int to = currentEdge[0];
            int len = currentEdge[1];

            if (!visited[to]) {
                visited[to] = true;
                totalLen += len;
                dari++;

                // 새로운 섬에 연결된 간선들을 큐에 추가
                for (int[] nextEdge : adjList[to]) {
                    if (!visited[nextEdge[0]]) {
                        pq.offer(nextEdge);
                    }
                }
            }
        }

        if (dari != landCnt - 2) {
            return -1; 
        }

        return totalLen;
        
	}
}
