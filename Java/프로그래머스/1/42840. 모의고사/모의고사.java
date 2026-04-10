import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        
        int[] pattern1= {1, 2, 3, 4, 5};      
        int[] pattern2= {2, 1, 2, 3, 2, 4, 2, 5};      
        int[] pattern3= {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};   
        
        int[] cnt= new int [3];
        
        int p1= 0;
        int p2= 0;
        int p3= 0;
        
        for(int num: answers) {
            
            if(num == pattern1[p1]) cnt[0] ++;
            
            if(num == pattern2[p2]) cnt[1] ++;
            
            if(num == pattern3[p3]) cnt[2] ++;
            
            
            if(p1< pattern1.length-1) p1 ++;
            else p1= 0;
            
            if(p2< pattern2.length-1) p2 ++;
            else p2= 0;
            
            if(p3< pattern3.length-1) p3++;
            else p3= 0;
            
        }
        
        
        List<Integer> tmp= new ArrayList<>();
        int max= -1;
        for(int i=0; i< cnt.length; i++){
            
            if(max < cnt[i]) {
                max= cnt[i];
                tmp.clear();
                tmp.add(i+1);
                }
            
            else if(max == cnt[i]) tmp.add(i+1);
        }

        int[] answer = new int [tmp.size()];
        for(int i=0; i< tmp.size(); i++) answer[i]= tmp.get(i);
        
        return answer;
    }
}