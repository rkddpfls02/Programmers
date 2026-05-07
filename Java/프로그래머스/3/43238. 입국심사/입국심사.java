import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        

        
        Arrays.sort(times); // 심사관 정렬
        
        // 젤 오래 걸린 시간 -> 0 가능한거 찾기
        long left= 0;
        long right= (long) times[times.length-1]*n;
        
        
        while(left<= right){
            long mid= (left+right)/2;
            long cnt=0;
            for(int i=0; i< times.length; i++){
                cnt += mid / times[i];
            }
            
            if(cnt >= n) right= mid-1;
            else left= mid +1 ;
            
        }
        
        
        return right +1;
        
        
    }
}