class Solution {
    
    int[] dx = {-1,-1,-1, 0, 0, 1, 1, 1};
    int[] dy = {-1, 0, 1,-1, 1,-1, 0, 1};
    
    public int solution(int[][] board) {

        int n = board.length;
        boolean[][] bam = new boolean[n][n];  

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){

                if(board[i][j]==1){
                    bam[i][j] = true;

                    for(int k =0; k<8; k++){
                        int nx = i+dx[k];
                        int ny = j+dy[k];
                        if( 0<= nx && nx <n && 0<= ny && ny <n){
                            bam[nx][ny] = true;
                        }
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!bam[i][j]) answer++;
            }
        }

        return answer;
    }
}