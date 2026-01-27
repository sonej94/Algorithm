import java.util.*;

class Solution {
    
    public int solution(String word) {
        int answer = 0;
        
        int[] su = {781, 156, 31, 6, 1};
        String w = "AEIOU";
        
        for (int i = 0; i < word.length(); i++) {
            
            int index = w.indexOf(word.charAt(i));
            answer += index * su[i];
            answer += 1;
        }

        return answer;
    }
}