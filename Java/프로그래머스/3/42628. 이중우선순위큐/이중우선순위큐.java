import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        Queue<Integer> min_q= new PriorityQueue<>();
        Queue<Integer> max_q = new PriorityQueue<>(Collections.reverseOrder());
        
        
        for(String operation: operations){
            
            if(operation.startsWith("I")) {
                int num= Integer.parseInt(operation.split(" ")[1]);
                min_q.offer(num);
                max_q.offer(num);
            }
            
            if(operation.equals("D 1")){
                if(!max_q.isEmpty()) min_q.remove(max_q.poll());
            }
            
            if(operation.equals("D -1")){
                if(!min_q.isEmpty()) max_q.remove(min_q.poll());
            }
            
            
        }
        
        
        
        if(min_q.isEmpty() && max_q.isEmpty()) return new int []{0,0};
        else{
            return new int [] { max_q.poll(), min_q.poll()};       
        }
        
    }
}