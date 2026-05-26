import java.util.*;
class Solution {
    
    static int[] diff;
    
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        int m= rocks.length;
        diff= new int[m+1];
        diff[0]= rocks[0];
        int prev= rocks[0];
        for(int i= 1; i< m; i++){
            diff[i]= rocks[i]- prev;
            prev= rocks[i];
        }
        diff[m]= distance- rocks[m-1];
        
        // 최소 간격이 mid일 것이라고 예상 - 간격이 mid 보다 작은 거 없애기
        int min= 1;
        int max= distance;
        int mid;
        
        while(min <= max){
            mid= (min+ max) / 2;
            int remove= 0;
            int now=0;
            for(int i=0; i< m+1; i++){
                now+= diff[i];
                if(now< mid){
                    remove++;
                } else{
                    now=0;
                };
            }
            
            if(remove> n) {
                max= mid -1;
            } else min= mid +1;
            
        }
        return min-1;
    }
}