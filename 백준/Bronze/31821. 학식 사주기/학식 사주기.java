import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] A = new int[N];
		for(int i = 0; i<N; i++){
			A[i] = Integer.parseInt(br.readLine());
		}

		int M = Integer.parseInt(br.readLine());

		int[] B = new int[M];
		for(int i =0; i<M; i++){
			B[i] = Integer.parseInt(br.readLine());
		}				
		
		int result = 0;

		for(int i=0; i<M; i++){
			int num= B[i];
			
			for(int j=0; j<N; j++){

				if( num == (j+1) ){
					result += A[j];
				}
			}	
		}

		System.out.println(result);
	}

}
