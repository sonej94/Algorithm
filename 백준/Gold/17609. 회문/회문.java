import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
            String str = br.readLine();
            sb.append(solve(str)).append('\n');
        }
		 System.out.print(sb);
	}
	
	static int solve(String str) {
		int left = 0;
        int right = str.length() - 1;
        
        if (rome(str, left, right)) {
            return 0;
        }

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                if (rome(str, left + 1, right)) {
                    return 1;
                }
                if (rome(str, left, right - 1)) {
                    return 1;
                }
                return 2;
            }
            left++;
            right--;
        }
        
        return 0;
    }
	
	static boolean rome(String str, int left, int right) {
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}