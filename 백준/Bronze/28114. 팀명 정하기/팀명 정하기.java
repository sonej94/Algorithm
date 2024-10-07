import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringBuilder sb = new StringBuilder();
		 
		 HashMap<Integer, String> map = new HashMap<>();

		 int[] years = new int[3];
		 int[] cnt = new int[3];
	        
		for (int i = 0; i < 3; i++) {
			String[] st = br.readLine().split(" ");

			int problem = Integer.parseInt(st[0]);
			int year = Integer.parseInt(st[1])%100;
			String name = st[2];

			years[i] = year;
			cnt[i] = problem;
			map.put(problem, name);
		}
		
		Arrays.sort(cnt);
		Arrays.sort(years);
		
		for(int i=0; i<3; i++){
			sb.append(years[i]);
		}
		sb.append("\n");

		for(int i=2; i>=0; i--){
			sb.append(map.get(cnt[i]).charAt(0));
		}
		
		System.out.println(sb);
	}
}
