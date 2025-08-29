class Solution {
    public int solution(int n, int w, int num) {
        
        int totalh= n/w+ (n%w==0? 0:1) ;
        int left= n%w;
        int h= num /w+ (num%w==0? 0:1) ;
                
        boolean totalLeft= totalh %2!=0;
        
        boolean numLeft= h %2!=0;
        
        int y = numLeft? (num-1)%w: w-1 - (num-1)%w;
        int answer;
        
        if(left==0) answer= totalh- h;
        else if(totalLeft){
            answer = totalh- h - (y >left-1 && h != totalh? 1:0); // 그리고 젤 위면 0
        } else{
            answer= totalh- h - (y < w-left && h != totalh ? 1:0);
        }
        
        return answer+1;
    }
}