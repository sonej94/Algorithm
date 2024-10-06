import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static int[] dy = { -1, 0, 1, 0 };
	public static int[] dx = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
            StringBuilder sb = new StringBuilder();
			sb.append("#" + tc);
			int N = Integer.parseInt(br.readLine());

			char[][] map = new char[N][N];
			int y = 0;
			int x = 0;
			int endY = 0;
			int endX = 0;

			for (int i = 0; i < N; i++) {
				String[] st = br.readLine().split("");
				for (int j = 0; j < N; j++) {
					map[i][j] = st[j].charAt(0);
					if (map[i][j] == 'X') {
						y = i;
						x = j;
					} else if (map[i][j] == 'Y') {
						endY = i;
						endX = j;
					}
				}
			}

			int Q = Integer.parseInt(br.readLine());

			for (int c = 0; c < Q; c++) {
				int dir = 0;
				int result = 0;
				int startY = y;
				int startX = x;

				String[] cc = br.readLine().split(" ");
				int C = Integer.parseInt(cc[0]);
				String com = cc[1];

				for (int b = 0; b < C; b++) {
					char move = com.charAt(b);

					if (move == 'R') {
						dir = (dir + 1) % 4;
					} else if (move == 'L') {
						dir = (dir - 1 + 4) % 4;
					}

					if (move == 'A') {
						int newY = startY + dy[dir];
						int newX = startX + dx[dir];
						if (newY >= 0 && newY < N && newX >= 0 && newX < N && map[newY][newX] != 'T') {
							startY = newY;
							startX = newX;
						}
					}
				}
				if (startY == endY && startX == endX) {
					result = 1;
				}
				sb.append(" " + result);
			}

			System.out.println(sb);

		}
	}
}