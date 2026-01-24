class Solution {
    public double solution(int[] numbers) {
        double answer = 0;
        
        for(float n:numbers){
            answer += n;
        }
        answer /= numbers.length;
        
        return answer;
    }
}