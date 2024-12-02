import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
 
    static int maxV;
     
    public static void main(String[] args) throws IOException {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
         
        for(int tc = 1; tc<=T; tc++){
             
            StringTokenizer st = new StringTokenizer(br.readLine());
             
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
             
            int[] arrA = new int[N];
            int[] arrB = new int[M];
 
            st = new StringTokenizer(br.readLine());
            for(int i =0; i< N; i++){
                arrA[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i =0; i< M; i++){
                arrB[i] = Integer.parseInt(st.nextToken());
            }
             
            maxV = Integer.MIN_VALUE; 
             
            if(arrA.length > arrB.length ){
                fnc(arrB, arrA);
                 
            }else {
                fnc(arrA, arrB);
            }
             
            System.out.println( "#"+ tc + " " + maxV);
        }
    }
     
    public static void fnc(int[] A, int[] B) {
         
        for(int i =0; i< B.length - A.length+1; i++) {
             
            int result= 0;
             
            for(int j = 0; j < A.length; j++){
                 
                result += B[i+j] * A[j];
                 
            }
             
            maxV = Math.max(maxV, result);
             
        }
    }
}