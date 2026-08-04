class Solution {
    public int[] solution(int n) {
        int [][] triangle= new int [n][];
        for(int i=1; i<= n; i++) triangle[i-1]= new int [i];
        
        
        int[] dx= {1, 0, -1};
        int[] dy= {0, 1, -1};
        
        int x=0;
        int y=0;
        int idx= 0;
        
        for(int i=1; i <= n*(n+1)/2; i++){
            triangle[x][y]= i;
            
            int nx= x+ dx[idx];
            int ny= y + dy[idx];
            
            if(nx>=0 && ny>=0  && nx< n && ny< triangle[nx].length && triangle[nx][ny]==0){
                x= nx;
                y= ny;
            } else{
                idx= (idx+1)% 3;
                x+= dx[idx];
                y+= dy[idx];
            }
            
            
        }
        
        int [] answer= new int [n*(n+1)/2];
        
        idx=0;
        for(int i=0; i< triangle.length; i++){
            for(int j=0; j<= i; j++){
                answer[idx++]= triangle[i][j];
        }
        }
        
        
        return answer;
    }
}