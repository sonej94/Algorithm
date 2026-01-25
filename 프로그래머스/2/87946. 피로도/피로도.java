import java.util.*;

class Solution {
    int max = 0;
    
    public int solution(int k, int[][] dungeons) {
        
        boolean[] visited = new boolean[dungeons.length];

        dfs(k, dungeons, visited, 0 );
        
        return max;
    }
    
    public void dfs(int p, int[][] dungeons, boolean[] visited, int cnt ){

        max = Math.max(max, cnt);
        
        for(int i=0; i<dungeons.length; i++ ){
        
            if(visited[i]) continue;  
            
                int need = dungeons[i][0];
                int gamso = dungeons[i][1];

            if( p >= need){

                visited[i] =true;
                dfs(p-gamso, dungeons, visited, cnt+1 );
                visited[i] = false;
            }
        }
    }
}