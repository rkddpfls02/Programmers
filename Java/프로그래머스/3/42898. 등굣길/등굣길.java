class Solution {
    public int solution(int m, int n, int[][] puddles) {
        
        int [][] map= new int [n+1][m+1];
        map[1][1]= 1;
        
        for(int [] p :puddles) map [p[1]][p[0]]= -1;
        
        for(int i=1; i<= n; i++) {
            for(int j=1; j<=m; j++){
                if(map[i][j] == -1) continue;
                if(j-1 >0  && map[i][j-1] != -1) {
                    map[i][j]= (map[i][j]+ map[i][j-1]) % 1000000007;
                
                }
                if(i-1 >0 && map[i-1][j] != -1) {
                    map[i][j]= (map[i][j]+ map[i-1][j]) % 1000000007;
                }
                
            }
        }
        
        return map[n][m] % 1000000007;
    }
}