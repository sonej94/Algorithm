class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] yes = {"aya", "ye", "woo", "ma"};

        for (int i = 0; i < babbling.length; i++) {
            String word = babbling[i];
            int len = word.length();
            int idx = 0;

            boolean[] used = new boolean[4];

            while (idx < len) {
                boolean flag = false;

                for (int k = 0; k < 4; k++) {
                    
                    if (!used[k] && word.startsWith( yes[k], idx)) {
                        used[k] = true;
                        idx += yes[k].length();
                        flag = true;
                        break;
                    }
                }
                if (!flag) break;
            }
            
            if (idx == len) answer++;
        }

        return answer;
    }
}
