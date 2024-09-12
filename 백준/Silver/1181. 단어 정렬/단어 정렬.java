import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String[] st = new String[N];

		for (int i = 0; i < N; i++) {
			st[i] = br.readLine();

		}

		Arrays.sort(st, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if (s1.length() - s2.length() == 0) {
					return s1.compareTo(s2);
				}

				return s1.length() - s2.length();
			}
		});

		for (int i = 0; i < N; i++) {
			if(i+1 != N) {
				if(st[i].equals(st[i+1])) {
					continue;
				}				
			}
			System.out.println(st[i]);
		}
	}
}