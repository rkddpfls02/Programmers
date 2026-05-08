import java.util.*;

class Solution {
    
    
    static int now=0;
    static int total=0;
    static int cnt=0;
    public int solution(int[][] jobs) {
        Queue<Process> q= new PriorityQueue<>();
        
        // 시작 시간 순으로 정렬
        Arrays.sort(jobs, (o1,o2)->  o1[0]-o2[0] ); 
        int n= jobs.length;
        
        for(int i=0; i< n; i++){
            
        }
        
        int qidx= 0;
        
        
        while(cnt < n){
            
            // 프로세스 시작 전에 현재시간보다 start시간이 작은거 큐에 다 넣기
            for(int i= qidx; i< n; i++){
                
            if(jobs[i][0]<= now) {
                q.offer(new Process(i, jobs[i][0], jobs[i][1]));
                qidx ++;
            }
            else break;
            }
            
            if(!q.isEmpty()) {
                Process p = q.poll();
                now += p.time;
                total += now - p.start;
                cnt++;
            } else now = jobs[qidx][0];
            
        } 
        
        return total / n;
    }
    
    
    static class Process implements Comparable<Process>{
        int num;
        int start;
        int time;
        
        Process(int num, int start, int time){
            this.num= num;
            this.start= start;
            this.time= time;
        }
        
        public int compareTo(Process o){
            if(this.time== o.time){
                if(this.start== o.start) return this.num- o.num;
                else return this.start- o.start;
            } else return this.time- o.time;
        }
        
    }
}