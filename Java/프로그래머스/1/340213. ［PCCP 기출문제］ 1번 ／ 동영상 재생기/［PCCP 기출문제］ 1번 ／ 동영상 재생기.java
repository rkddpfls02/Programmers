class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        
        int posTime= StringToTime(pos);   
        int len= StringToTime(video_len);
        int opStart= StringToTime(op_start);
        int opEnd= StringToTime(op_end);

        posTime= opPass(posTime, opStart, opEnd);
        
        for(String command: commands){
            switch(command){
                    case "prev":
                        posTime-= 10;
                        break;
                    case "next":
                        posTime+= 10;
                        break;
            }
            
            if(posTime<0) posTime=0;
            if(posTime>len) posTime= len;
            
            posTime= opPass(posTime, opStart, opEnd);

            
        }
            
        return String.format("%02d:%02d",posTime/60,posTime%60);
    }
    
    public int StringToTime(String s){
        String[] str= s.split(":");
        return Integer.parseInt(str[0])*60+ Integer.parseInt(str[1]);
    }
    
    public int opPass(int pos, int start, int end){
        // 오프닝 건너뛰기
        if(pos >= start && pos <= end) {
            pos= end;
        }
        
        return pos;
    }
    
}
