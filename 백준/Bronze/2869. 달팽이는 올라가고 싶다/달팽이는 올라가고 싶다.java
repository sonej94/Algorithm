import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] st = br.readLine().split(" ");

		int A = Integer.parseInt(st[0]);
		int B = Integer.parseInt(st[1]);
		int V = Integer.parseInt(st[2]);
		
		int day = (V - B) / (A-B);
		if(((V - B) % (A-B)) != 0 ) {
			day++;
		}
		
		System.out.println(day);
	}
}