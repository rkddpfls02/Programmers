import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        
        int n= words.length;
        int [] cnt= new int[n+1];

        
        Queue<Integer> q= new LinkedList<>();
        for(int i=0; i< words.length; i++) {
            if(wordMatch(begin, words[i])) {
                q.offer(i);
                cnt[i]++;
            }
        }
        
        
        while(!q.isEmpty()) {
            int now= q.poll();
            if(words[now].equals(target)) return cnt[now];
            
            
            for(int i=0; i< words.length; i++){
                if(cnt[i]==0 && wordMatch(words[now], words[i])) {
                    cnt[i]= cnt[now]+1;
                    q.offer(i);
                }
            }
        }
        
        return 0;
    }
    
    
    public boolean wordMatch (String w1, String w2){
        if (w1.length() != w2.length()) return false;
        int cnt=0;
        for(int i=0; i< w1.length(); i++) {
            if(w1.charAt(i) != w2.charAt(i)) cnt++;
            if(cnt>1) return false;
        }
        
        return true;
    }
}