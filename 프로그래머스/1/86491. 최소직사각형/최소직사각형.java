import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int maxw = 0;
        int maxh = 0;

        for(int[] size : sizes){

            int w = Math.max(size[0], size[1]);
            int h = Math.min(size[0], size[1]);
            
            maxw = Math.max(maxw, w);
            maxh = Math.max(maxh, h);         
            
        }
        
        return maxw*maxh;
    }
}