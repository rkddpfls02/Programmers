import java.util.*;
class Solution {
    
//     class Process implements Comparable<Process>{
//         int index;
//         int priority;
        
//         public int compareTo(Process o){
//             return  o.priority- this.priority;
//         }
        
//         Process(int index, int priority){
//             this.index= index;
//             this.priority= priority;
//         }
//     }
    
    public int solution(int[] priorities, int location) {
        int n= priorities.length;
        Queue<Integer> q= new LinkedList<>();
        int[] p = new int[n];
        
        for(int i=0; i< n; i++){
            p[i]= priorities[i];
            q.offer(i);
        }
        
        Arrays.sort(p);
        
        int first=n-1;
        int cnt=0;
        
        while(first>=0){
            int now= q.poll();
            
            if(priorities[now] == p[first]){
                cnt++;
                first--;
                if(now == location) return cnt;
            }
            
            else q.offer(now);
            
        }

        return cnt;
    }
}