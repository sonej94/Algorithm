import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dy = { -1, 0, 1, 0 };
    static int[] dx = { 0, 1, 0, -1 };

    static int R, C;
    static char[][] map;
    static boolean[][] visited;

    static Queue<Node> dochi = new LinkedList<>();
    static Queue<Node> water = new LinkedList<>();

    static class Node {
        int y, x, time;

        public Node(int y, int x, int time) {
            this.y = y;
            this.x = x;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);

                if (map[i][j] == '*') {
                    water.add(new Node(i, j, 0));
                } else if (map[i][j] == 'S') {
                    dochi.add(new Node(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }

        int result = bfs();
        System.out.println(result == -1 ? "KAKTUS" : result);
    }

    public static int bfs() {
        while (!dochi.isEmpty()) {
            // 물 이동
            int waterSize = water.size();
            for (int i = 0; i < waterSize; i++) {
                Node now = water.poll();

                for (int d = 0; d < 4; d++) {
                    int ny = now.y + dy[d];
                    int nx = now.x + dx[d];

                    if (ny >= 0 && ny < R && nx >= 0 && nx < C) {
                        if (map[ny][nx] == '.' || map[ny][nx] == 'S') {
                            map[ny][nx] = '*';
                            water.add(new Node(ny, nx, 0));
                        }
                    }
                }
            }

            // 고슴도치 이동
            int dochiSize = dochi.size();
            for (int i = 0; i < dochiSize; i++) {
                Node now = dochi.poll();

                for (int d = 0; d < 4; d++) {
                    int ny = now.y + dy[d];
                    int nx = now.x + dx[d];

                    if (ny >= 0 && ny < R && nx >= 0 && nx < C) {
                        
                        if (map[ny][nx] == 'D') {
                            return now.time + 1;
                        }
                        if (map[ny][nx] == '.' && !visited[ny][nx]) {
                            visited[ny][nx] = true;
                            dochi.add(new Node(ny, nx, now.time + 1));
                        }
                    }
                }
            }
        }
        return -1;
    }
}