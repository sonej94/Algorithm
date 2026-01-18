import java.util.*;

class Solution {
    Set<Integer> set = new HashSet<>();
    boolean[] used;

    public int solution(String numbers) {
        used = new boolean[numbers.length()];

        dfs(numbers, "");

        int answer = 0;
        for (int num : set) {
            if (isSosu(num)) answer++;
        }
        
        return answer;
    }

    private void dfs(String numbers, String now) {
        if (!now.isEmpty()) {
            set.add(Integer.parseInt(now));
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (used[i]) continue;

            used[i] = true;
            dfs(numbers, now + numbers.charAt(i));
            used[i] = false;
        }
    }

    private boolean isSosu(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        
        return true;
    }
}
