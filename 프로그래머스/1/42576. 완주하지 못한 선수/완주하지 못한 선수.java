import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        
        for( String name : participant){
            Integer cnt = map.get(name);
            
            if(cnt == null){
                map.put(name,1);
            }else{
                map.put(name, cnt+1);
            }

        }
        
        for(String name : completion){
            map.put(name, map.get(name)-1);
        }

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(entry.getValue() != 0) return entry.getKey();
        }
        
        return "";
    }
}