import java.util.*;

class Solution {
    public long solution(long n) {
        StringBuilder answer = new StringBuilder();
        
        String[] s = String.valueOf(n).split("");
        Arrays.sort(s, Collections.reverseOrder());
        
        for(int i=0; i<s.length; i++){
            answer.append(s[i]);
        }
        
        return Long.parseLong(answer.toString());
    }
}