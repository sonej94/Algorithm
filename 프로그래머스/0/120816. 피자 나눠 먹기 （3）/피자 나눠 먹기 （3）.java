class Solution {
    public int solution(int slice, int n) {

        for(int i =1; i<=n; i++){
            
            if(i*slice /n >= 1 ){
                return i;
            }
            
        }
        
        return 0;
    }
}