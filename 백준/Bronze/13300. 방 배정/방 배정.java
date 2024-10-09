import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] st = br.readLine().split(" ");

		int N = Integer.parseInt(st[0]);
		int K = Integer.parseInt(st[1]);
		
		int[] f = new int[7];
		int[] m = new int[7];
		int cnt =0;
		
		for(int i = 0; i<N; i++) {
			String[] t = br.readLine().split(" ");
			int fm = Integer.parseInt(t[0]);
			int gr = Integer.parseInt(t[1]);
			
			if(fm == 0){
				f[gr] += 1;
			}else {
				m[gr] += 1;
			}
		}
		
		for(int i = 1; i<=6; i++) {
			
			if(f[i]%K == 0) {
				cnt += f[i]/K;
			}else {
				cnt += f[i]/K+1;
			}
			
			if(m[i]%K == 0) {
				cnt += m[i]/K;
			}else {
				cnt += m[i]/K+1;
			}

		}
		
		System.out.println(cnt);
	}

}
