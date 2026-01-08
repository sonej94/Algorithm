import java.util.*;

class Solution {
    public int solution(int[] nums) {

        int pick = nums.length /2;
        Set<Integer> kinds = new HashSet<>();
        
        for (int x : nums) {
            kinds.add(x);
        }

        return Math.min(kinds.size(), pick);
    }
}