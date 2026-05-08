import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        // 키와 값으로 관리
        Queue<int[]> min_q= new PriorityQueue<>(11, (o1, o2) -> o1[1] - o2[1]);
        Queue<int[]> max_q = new PriorityQueue<>(11, (o1, o2) -> o2[1] - o1[1]);
        
        Map<Integer, Boolean> used = new HashMap<>();
        int lastKey= 0;
        
        for(String operation: operations){
            
            if(operation.startsWith("I")) {
                used.put(lastKey, false); // 유효한 숫자
                int num= Integer.parseInt(operation.split(" ")[1]);
                min_q.offer(new int[] {lastKey, num});
                max_q.offer(new int[] {lastKey, num});
                lastKey++;
            }
            
            if(operation.equals("D 1")){
               while (!max_q.isEmpty()) {
                   int key= max_q.poll()[0];
                   if(!used.get(key)) { // 사용안했으면 뺌
                       used.put(key, true);
                       break; // 하나 뺐으면 끝
                   }
               }
            }
            
            if(operation.equals("D -1")){
               while (!min_q.isEmpty()) {
                   int key= min_q.poll()[0];
                   if(!used.get(key)) {
                       used.put(key, true);
                       break;
                   }
               }
            }
            
            
        }
        
        int[] answer = new int [2];
        
        if(!used.containsValue(false)) return new int []{0,0};
        else{
            int[] tmp;
            
            while (!max_q.isEmpty()) {
                   tmp= max_q.poll();
                    
                   if(!used.get(tmp[0])) { 
                       answer[0]= tmp[1];
                       break;
                   }
               }
            
            while (!min_q.isEmpty()) {
                   tmp = min_q.poll();
                    
                   if(!used.get(tmp[0])) { 
                       answer[1]= tmp[1];
                       break;
                   }
               }
        }
        
        
        return answer;
    }
}