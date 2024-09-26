import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			String[] s = br.readLine().split(" ");
			int n = Integer.parseInt(s[0]);
			String[] st = s[1].split("");
			String result = "";
			
			for (int j = 0; j < st.length; j++) {
				
				for(int k=0; k<n; k++ ) {
					result += st[j];
				}
			}
			System.out.println(result);
		}

	}

}