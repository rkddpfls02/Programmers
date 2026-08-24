import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        int n= triangle.length;
        int[][] sums= new int[n][];
        for(int i=0; i< n; i++) sums[i]= new int[triangle[i].length];
                
        sums[0][0]= triangle[0][0];
        
        for(int i=1; i< n; i++){
           for(int j=0; j< triangle[i].length; j++){
               
                // left- 왼쪽대각선
                if(j >0) {
                    sums[i][j]= Math.max(sums[i][j] ,sums[i-1][j-1]+triangle[i][j]);
                }
                // right- 그냥 바로 윗원소
                if(j != triangle[i].length-1) {
                    sums[i][j]= Math.max(sums[i][j], sums[i-1][j]+triangle[i][j]);
                }
               
            } 
        }
        
        Arrays.sort(sums[n-1]);
        return sums[n-1][n-1];
    }
}