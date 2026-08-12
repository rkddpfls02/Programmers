import java.util.*;
class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        
        int max=0;
        for(int diff: diffs) max= Math.max(max, diff);
        
        int low= 1;
        int upper= max;
        
        while(low<= upper){
            int mid= (low+upper)/2;
            long total=0;
            int time_prev=0;
            
            for(int i=0; i< diffs.length; i++){
                
                if(diffs[i]<= mid) total += times[i];
                else{
                    total += (diffs[i]- mid)* (time_prev+ times[i])+ times[i];
                }
                
                time_prev= times[i];
                
            }
            
            if(total > limit) low= mid+1;
            else upper= mid-1;
            
            
        }
        
        return low;
    }
}