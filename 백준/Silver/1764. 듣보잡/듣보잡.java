import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] st = br.readLine().split(" ");
		
		int N = Integer.parseInt(st[0]);
		int M = Integer.parseInt(st[1]);
		
		int cnt=0;
		ArrayList<String> list = new ArrayList<String>();
		Set<String> set = new HashSet<>();
		String[] dontSee = new String[M];
		
		
		for(int i=0; i<N; i++) {
			set.add(br.readLine());
		}
		for(int i=0;i<M;i++) {
			dontSee[i] = br.readLine();
		}
		
		
		for(int i=0; i<M; i++) {
			if(set.contains(dontSee[i])){
				cnt++;
				list.add(dontSee[i]);
			}
		}
		
		Collections.sort(list);
		sb.append(cnt + "\n");

		for(int i=0; i<cnt; i++){
			sb.append(list.get(i) + "\n");
		}

		System.out.println(sb);
	}
}
