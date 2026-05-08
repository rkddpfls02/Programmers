import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        
        Queue<Integer> q= new PriorityQueue<>();
        for(int tmp: scoville) q.offer(tmp);
        
        int cnt=0;
        
        while (!q.isEmpty()){
            int min= q.poll();
            
            if(min >= K) break;
            
            if(q.isEmpty()) return -1;
            int next= q.poll();
            
            q.offer(min+(next*2));
            cnt++;
            
        }
        
        
        return cnt;
    }
}