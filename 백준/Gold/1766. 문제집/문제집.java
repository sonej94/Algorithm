import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] dig;
	static List<Integer>[] lists;

	 public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	

		StringTokenizer st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		lists = new ArrayList[N+1];
		dig = new int[N+1];
		int A, B;
		
		for(int i=1; i<=N; i++){
			lists[i] = new ArrayList<>();
			dig[i] = 0;
		}
		
		for(int i=0; i<M; i++) {
			st= new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			lists[A].add(B);
			dig[B]++;
		}
		
		String result = solve();
		System.out.println(result);

		}

	 private static String solve() {
		 
		 StringBuilder sb = new StringBuilder();		
		 PriorityQueue<Integer> qu = new PriorityQueue<Integer>();
		 
		 for(int i =1; i<= N; i++){
			 if(dig[i] == 0) {
				 qu.add(i);
			 }
		 }
		 while(!qu.isEmpty()){
			 Integer poll = qu.poll();
			 sb.append(poll).append(" ");
			 
			 for(Integer now: lists[poll]){
				 dig[now]--;
				 if(dig[now] == 0) {
					 qu.add(now);
				 }
			 }
		 }
		 return sb.toString();
	 }
}
