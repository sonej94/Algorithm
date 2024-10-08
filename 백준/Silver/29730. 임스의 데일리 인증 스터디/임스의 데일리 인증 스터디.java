import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		ArrayList<String> study = new ArrayList<>();
		ArrayList<String> boj = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			String st = br.readLine();

			if (st.startsWith("boj.kr/")) {
				boj.add(st);
			} else {
				study.add(st);
			}
		}
		
		Collections.sort(study, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() != s2.length()) {
                    return s1.length() - s2.length();
                }
                return s1.compareTo(s2);
            }
        });
				
		Collections.sort(boj, (a, b) -> {
			int num1 = Integer.parseInt(a.substring(7));
			int num2 = Integer.parseInt(b.substring(7));
			return Integer.compare(num1, num2);
		});

		for (int i = 0; i < study.size(); i++) {
			sb.append(study.get(i)).append("\n");
		}
		for (int i = 0; i < boj.size(); i++) {
			sb.append(boj.get(i)).append("\n");
		}
		System.out.print(sb);

	}

}