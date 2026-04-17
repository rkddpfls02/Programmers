import java.util.*;

class Solution {
    
    static int min= Integer.MAX_VALUE;

    public int solution(int[][] maps) {
        int n= maps.length;
        int m= maps[0].length;        
        
        int[][] dist= new int [n][m];
        
        int[] dx= {0, -1, 0, 1}; // 4방향 가능
        int[] dy= {1, 0, -1, 0};

        Queue<int[]> q= new LinkedList<>();
        q.add(new int[] {0, 0});
        dist[0][0]= 1;
        
        while(!q.isEmpty()){
            int[] tmp= q.remove();
            int x= tmp[0];
            int y= tmp[1];
            
            if(x== n-1 && y== m-1) return dist[x][y];
        
            
            for(int i=0; i< 4; i++) {
                int X= x+ dx[i]; // 이동할 좌표 
                int Y= y+ dy[i];


                if(X>=0 && X<n && Y>=0 && Y<m){
                    if(maps[X][Y]==1 && dist[X][Y]==0) {
                        dist[X][Y]= dist[x][y]+1;
                        q.add(new int[] {X, Y});
                        }
            }
        }
            
        
    }
        
       return -1;

        
    }
    
}