
class Solution {
    boolean solution(String s) {
        boolean answer = false;

        int cntp =0;
        int cnty =0;
            
        for(int i=0; i< s.length(); i++){
            
            char c = s.charAt(i);
            
            if(c == 'p' || c == 'P'){
                cntp++;
            }else if(c == 'y' || c == 'Y'){
                cnty++;
            }

        }

        if(cntp == cnty){
            return true;
        }

        return answer;
    }
}