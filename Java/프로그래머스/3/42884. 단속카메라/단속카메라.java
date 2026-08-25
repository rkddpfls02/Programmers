import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        
        Arrays.sort(routes, (r1, r2)-> r1[0]- r2[0]);
        
        // 초기엔 처음 구간이 현재 원소 겹치는 구간
        int [] overlap= routes[0];
        int cnt= 0;
        
        for(int[] route: routes){
            int start= route[0]; // 다음 시작
            int end= route[1]; // 다음 끝
            
            //  경로가 겹치면 overlap 갱신
            if(start<= overlap[1]) {
                overlap[0]= start;
                if(end<= overlap[1]) overlap[1]= end;
            } else { // 경로가 겹치지 않으면 하나씩 증가
                cnt++;
                overlap= route;
            }
            
            
        }
        
        return cnt+1;
    }
}