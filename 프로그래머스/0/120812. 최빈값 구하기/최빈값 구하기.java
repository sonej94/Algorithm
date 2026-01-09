import java.util.*;

class Solution {
    public int solution(int[] array) {
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int ar : array){
            map.put(ar, map.getOrDefault(ar, 0) + 1);
        }
        
        int maxCnt = 0;
        int mode = -1;
        boolean flag = false;
        
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            int num = e.getKey();
            int cnt = e.getValue();
            
            if (cnt > maxCnt) {
                maxCnt = cnt;
                mode = num;
                flag = false;
            } else if (cnt == maxCnt) {
                flag = true; 
            }
            
        }
        
        return flag? -1 : mode;
    }
}