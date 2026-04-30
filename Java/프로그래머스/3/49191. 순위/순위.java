import java.util.*;

class Solution {
    
    static int cnt=0;
    
    public int solution(int n, int[][] results) {
        
        int [][] arr= new int [n+1][n+1];
        
        
        for(int[] result: results) {
            
            int win= result[0];
            int lose= result[1];
            arr[win][lose]= 1;
            arr[lose][win]= -1;

        }
        
        
        for(int k=1; k <= n; k++) {
            for(int i=1; i<= n; i++){
                for(int j=1; j<= n; j++){
                    if(i==k || k==j) continue;
                    
                    // i가 k한테 이기고 k가 j를 이겨야함
                    // k가 i한테 지고 j가 k 한테 져야함 
                    if(arr[i][k]== 1 && arr[k][j]== 1) {
                        arr[i][j]= 1;
                        arr[j][i]= -1;
                    }
                }
            }
        }
        
        
        for(int i=1; i<= n; i++){
                
            boolean pass= true;
            
            for(int j=1; j<= n; j++){
                if(i==j) continue;
                if(arr[i][j] ==0) pass= false;
            }
            
            if(pass) cnt++;
        }
        
        return cnt;
    }   
        
        
        
}
