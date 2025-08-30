class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for(int i= 0; i< schedules.length; i++){
            boolean pass= true;    
            
            int[] log= timelogs[i];
            for(int j= 0, day= startday; j< 7; j++, day++){ // 총 7일 7번 반복 
                if(day>5) { // day 6과 7은 볼 필요 없음 그리고 일욜이면 0으로 초기화
                    if(day==7) day=0;
                    continue;
                }
            
                if(!isPass(schedules[i],log[j])) pass= false;
            }
            
            if(pass) answer ++;
        }
        
        return answer;
    }
    
    public boolean isPass(int schedule, int time){
        int limit= schedule%100>= 50 ? (schedule/100+1)*100+schedule%10: schedule+10;
        System.out.print(schedule+" "+limit+" ");
        return limit>= time;
    } 
}