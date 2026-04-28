import java.util.*;
class Solution {
    
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer= new ArrayList<>();
        Queue<Integer> q= new LinkedList<>();
        
        for(int i=0; i< progresses.length; i++) {
            int left= 100- progresses[i];
            if(left% speeds[i]==0) q.offer(left/speeds[i]);
            else q.offer(left/speeds[i]+1);
        }
        
        int days= q.poll();
        int cnt=1;
        
        while(!q.isEmpty()){
            
            if(days>= q.peek()) {
                cnt++;
                q.poll();
            }
            else {
                answer.add(cnt);
                cnt= 1;
                days= q.poll();
            }
            
            
        }
        
        answer.add(cnt);
        
        int[] arr= new int[answer.size()];
        for(int i=0; i< answer.size(); i++) arr[i]= answer.get(i);
        
        return arr;
    }
    
}
 
