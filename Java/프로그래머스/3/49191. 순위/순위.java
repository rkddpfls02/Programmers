import java.util.*;
class Solution {
    public int solution(int n, int[][] results) {
        
        int[][] costs= new int [n+1][n+1];
        for(int i= 1; i<= n; i++) {
            Arrays.fill(costs[i], Integer.MAX_VALUE);
            costs [i][i]= -1;
        }
        
        for(int [] result: results) {
            costs[result[0]][result[1]]= 1; // 이긴거
            costs[result[1]][result[0]]= 0; // 진거
        }
        
        for(int k=1; k<= n; k ++){
            for(int i=1; i< costs.length; i++ ){
                if (k == i) continue;
                for(int j=1; j< costs.length; j++){
                    if(costs[i][k]==1 && costs[k][j]==1) {
                        costs[i][j]= 1;
                        costs[j][i]= 0;
                    }
                    
                    if(costs[i][k]==0 && costs[k][j]==0) {
                        costs[i][j]= 0;
                        costs[j][i]= 1;
                    }
                    
                }
            }
        }
        
        int answer= 0;
        for(int i=1; i< costs.length; i++ ){
            boolean confirm= true;
            
            for(int j=1; j< costs.length; j++){
                if(costs[i][j]== Integer.MAX_VALUE) {
                    confirm= false;
                    break;
                } 
            
            }
            if(confirm) answer ++;
        }
        
        return answer;
    }
}