class Solution {
    public int solution(String t, String p) {
        int len= p.length();
        long target= Long.parseLong(p);
        int answer=0;
        
        
        
        for(int i= 0; i<= t.length()-len; i++){
            long now= Long.parseLong(t.substring(i,i+len));
            if(now<= target) answer ++;
        }
        
        return answer;
    }
}