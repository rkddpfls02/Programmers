import java.util.*;
class Solution {
    
    public int solution(int[][] jobs) {
        int n= jobs.length;
        
        Queue<int []> pq = new PriorityQueue<>((q1, q2)->{
            if(q1[1]!= q2[1]) return q1[1]- q2[1];
            if(q1[0]!= q2[0]) return q1[0]- q2[0];
            return q1[2]- q2[2];
        });
        
        // 들어온 순서대로 맞춤
        Queue<int[]> idxJobs = new PriorityQueue<>((q1, q2)-> {
            if(q1[0] != q2[0]) return q1[0]-q2[0];
            return q1[1]-q2[1];
        });
        
        // 기존의 jobs배열에 인덱스 필드 추가
        for(int i=0; i< n; i++){
            int[] idxJob= new int[3];
            idxJob[0]= jobs[i][0];
            idxJob[1]= jobs[i][1];
            idxJob[2]= i;
            idxJobs.offer(idxJob);
        }
                
        int time=0;
        int total=0;
        
        for(int i=0; i< n; i++){
            while(!idxJobs.isEmpty()){                
                // 아직 시작시간이 되지 않으면 넣지 않음
                if(idxJobs.peek()[0] <= time) pq.offer(idxJobs.poll());
                else break;
            }
            
            int[] now;
            
            // 시작시간이 된 거 하나도 없으면 다음꺼 꺼냄
            if(pq.isEmpty()) now= idxJobs.poll();
            else now= pq.poll();
            
            // 현재시간보다 시작시간이 더 뒤면
            if(time< now[0]) time= now[0];
            
            time+= now[1];
            total += time -now[0];
        }

        return total/n;
    }
}