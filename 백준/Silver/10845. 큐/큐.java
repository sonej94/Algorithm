import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> qu = new LinkedList<>();
        int last = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String S = st.nextToken();

            switch (S) {
                case "push":
                    last = Integer.parseInt(st.nextToken());
                    qu.offer(last);
                    break;
                case "pop":
                    if (qu.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(qu.poll()).append("\n");
                    }
                    break;
                case "size":
                    sb.append(qu.size()).append("\n");
                    break;
                case "empty":
                    if (qu.isEmpty()) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;
                case "front":
                    if (qu.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(qu.peek()).append("\n");
                    }
                    break;
                case "back":
                    if (qu.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(last).append("\n");
                    }
                    break;
            }
        }
        System.out.print(sb);
    }
}