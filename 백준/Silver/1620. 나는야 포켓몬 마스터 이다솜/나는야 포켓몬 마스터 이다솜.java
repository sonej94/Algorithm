import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main{

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		HashMap<String, Integer> hm1 = new HashMap<String, Integer>();
		HashMap<Integer, String> hm2 = new HashMap<Integer, String>();
		
		String[] t = br.readLine().split(" ");
		int N = Integer.parseInt(t[0]);
		int M = Integer.parseInt(t[1]);
		
		for(int i=1; i<=N; i++ ) {
			String st = br.readLine();
			hm1.put(st, i);
			hm2.put(i, st);
			}
		
		for(int i =0; i<M; i++) {
			String st = br.readLine();
			char s = st.charAt(0);
			if(Character.isDigit(s)){
				sb.append(hm2.get(Integer.parseInt(st)) + "\n");
			}else {
				sb.append(hm1.get(st) + "\n");
			}
		}
		System.out.println(sb);

	}
}
