import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        int n= triangle.length;
        int[][] dp= new int [n][n] ;
        dp[0][0]= triangle[0][0];
        
        for(int i=1; i< n; i++){
            
            for(int j= 0; j< i+1; j++){
                int[] points= {j-1, j};
                
                for (int y: points){
                    if(y>=0 && y< i){
                        dp[i][j]= Math.max(dp[i][j], 
                                 triangle[i][j] +dp[i-1][y]);
                    }
                    
                }
                
            }
        }
        
        int [] last= dp[n-1];
        
        Arrays.sort(last);
        
        return last[n-1];
    }
}