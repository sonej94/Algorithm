import java.util.Arrays;

class Solution {
    public int solution(String A, String B) {

        char[] start = A.toCharArray();
        char[] end = B.toCharArray();

        for(int i = 0; i<A.length(); i++){
            
           if (Arrays.equals(start, end)) return i;

            char last = start[start.length-1];
            for(int j = start.length-1; j>0; j-- ){
                start[j] = start[j-1];
            }
            start[0] = last;

        }
        
        return -1;
    }
}