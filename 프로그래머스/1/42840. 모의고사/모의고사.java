import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] a = { 1,2,3,4,5 };
        int[] b = { 2,1,2,3,2,4,2,5 };
        int[] c = { 3,3,1,1,2,2,4,4,5,5 };

        int cntA = 0;
        int cntB = 0;
        int cntC = 0;
        
        for(int i =0; i<answers.length; i++){

            if(answers[i] == a[i% a.length]) cntA++;
            if(answers[i] == b[i% b.length]) cntB++;
            if(answers[i] == c[i% c.length]) cntC++;
        }
        int max = Math.max(cntA, Math.max(cntB, cntC)); 

        List<Integer> list = new ArrayList<>();    
        if(max == cntA) list.add(1);
        if(max == cntB) list.add(2);
        if(max == cntC) list.add(3);
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}