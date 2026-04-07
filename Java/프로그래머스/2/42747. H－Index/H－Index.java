import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer=0;
        int n= citations.length;
        int idx = n; // h 인용 이하 몇개인지
        Arrays.sort(citations);
        for(int h= n; h >=0; h--){ 
            
           for (int j= idx-1; j>=0; j--){
               if(citations[j]>= h) idx--;
               if(idx+1<= h && n-idx >= h) return h;
           }
        }
        return answer;
    }
}