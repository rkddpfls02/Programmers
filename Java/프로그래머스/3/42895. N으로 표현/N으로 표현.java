import java.util.*;
class Solution {
    public int solution(int N, int number) {
        Set [] dp= new Set [9]; // i개의 number로 만들 수 있는 수들
                
        if(N==number) return 1;
        
        for(int i= 1; i<= 8; i++) dp[i]= new HashSet<Integer>();  
        dp[1].add(N);
        
        for(int i=2; i<= 8; i++){
            
            int max= 0; // 제일 넘버만 i개 쓴거
            for(int j=1; j<=i; j++) max = max*10 + N;
            if(max== number) return i;
            dp[i].add(max);
            
            for(int k=1; k< i; k++){
                Set<Integer> set1= dp[k];
                Set<Integer> set2= dp[i-k];
                
                for(int n1: set1){
                    for(int n2: set2){
                        
                        if(n1+n2 == number){
                            return i;
                        } else dp[i].add(n1+n2);
                        
                        if(n1-n2 == number){
                            return i;
                        } else {
                            dp[i].add(n1-n2);
                        }
                        
                        if(n1*n2 == number){
                            return i;
                        } else dp[i].add(n1*n2);
                        
                        if(n2 !=0) {
                            if(n1/n2 == number) return i;
                            dp[i].add(n1/n2);
                        }
                        
                    }
                }
                
        }
        
    }
        return -1;
}
}