class Solution
{
    public int solution(String s)
    {
        int answer =1;
                
        // 팰린드롬 길이가 홀수일때
        for(int i=1; i< s.length(); i++){
            int len=1;
            for(int j=1; j<=i; j++){
                if(i+j>= s.length()) break;
                if(s.charAt(i-j)==s.charAt(i+j)) len += 2;
                else break;
                answer= Math.max(answer, len);
            }
        }
        
        //팰린드롬 길이가 짝수일때
        for(int i=0; i< s.length()-1; i++){
            if(s.charAt(i+1) != s.charAt(i)) continue;
            int len= 2;
            answer= Math.max(answer, len);
            for(int j=1; j<=i; j++){
                if(i+j>= s.length()-1) break;
                if(s.charAt(i-j)==s.charAt(i+1+j)) len += 2;
                else break;
                answer= Math.max(answer, len);
            }
        }
        
        return answer;
    }
}