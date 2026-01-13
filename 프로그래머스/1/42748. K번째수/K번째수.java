import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        int idx = 0;
        for(int[] command :commands){
            int i = command[0];
            int j = command[1];
            int k = command[2];
            
            List<Integer> list = new ArrayList<>();
            for(int p=i-1; p<j; p++){
                list.add(array[p]);
            }
            Collections.sort(list);
            int n = list.get(k-1);

            answer[idx++] = n;
        }
        
//         for (int t = 0; t < commands.length; t++) {
//             int i = commands[t][0];
//             int j = commands[t][1];
//             int k = commands[t][2];

//             int[] cut = Arrays.copyOfRange(array, i - 1, j);
//             Arrays.sort(cut);
//             answer[t] = cut[k - 1];
//         }
        
        return answer;
    }
}