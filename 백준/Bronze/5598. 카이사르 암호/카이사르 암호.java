import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		char[] st = br.readLine().toCharArray();;
		
		for(int i = 0; i<st.length; i++) {

			if(st[i]<= 'C') {
				sb.append((char)(st[i] + 23));
			}else {
				sb.append((char)(st[i]-3));
			}
			
		}
		System.out.println(sb);

	}
}