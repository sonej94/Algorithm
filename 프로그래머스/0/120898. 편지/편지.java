import java.util.*;

class Solution {
    public int solution(String message) {
        int answer = 0;
        
        for(char i : message.toCharArray()){
            
            if( i == '"') continue;
            answer += 2;           
            
        }
        
        return answer;
    }
}