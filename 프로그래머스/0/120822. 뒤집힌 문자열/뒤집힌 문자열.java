import java.util.*;

class Solution {
    public String solution(String my_string) {
        
        StringBuilder sb = new StringBuilder();
        char[] c = my_string.toCharArray();
        
        for(int i= c.length-1; i>=0; i--){
            sb.append(c[i]);  
        }
        
        return sb.toString();
        //return new StringBuilder(my_string).reverse().toString();
    }
}