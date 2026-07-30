import java.util.*;

class Solution {
    public int solution(int[] citations) {
        
        Arrays.sort(citations);
        int n= citations.length;
        
        
        
        
        for(int h= citations[n-1]; h>=0; h--){
            int cnt=0; // h이상 몇개인지
            
            for(int i= n-1; i>= 0; i--){
                
                if(citations[i] >= h) cnt++;
                else break;
                
            }
            if(cnt >= h && n-cnt <= h) return h;
            
        }
        
        return citations[0];
    }
}