class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        int len = arr.length;
        
        for(int a : arr){
            answer += a;
        }
        answer /= len;
        
        return answer;
    }
}