import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int cnt= 0;
        Arrays.sort(people);
        int n= people.length;
        int minidx= 0;
        boolean[] ride= new boolean[n];

        
         for(int i= n-1; i>=0 ; i--){
            if(i< minidx) break;
            int left= limit- people[i];
            ride[i]= true;
            cnt++;
            
             
            // 안 탄 젤 작은 사람 탈 수 있나 ?
            // 탈수 있으면 태우고 minidx++;
            if(people[minidx]<= left) minidx++;
            
        }
        
        // 마지막 만들어졌었을테니 +1;
        return cnt;
    }
}