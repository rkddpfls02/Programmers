import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        
        int[] pattern1= {1, 2, 3, 4, 5};      
        int[] pattern2= {2, 1, 2, 3, 2, 4, 2, 5};      
        int[] pattern3= {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};   
        
        int p1= 0;
        int p2= 0;
        int p3= 0; 
        
        for(int i=0; i< answers.length; i++) {
            
            if(answers[i] == pattern1[i% pattern1.length]) p1 ++;
            if(answers[i] == pattern2[i% pattern2.length]) p2 ++;
            if(answers[i] == pattern3[i% pattern3.length]) p3 ++;
            
        }
        
        List<Integer> tmp= new ArrayList<>();
        int max= Math.max(p1, Math.max(p2, p3));
        
        if(p1 == max) tmp.add(1);
        if(p2 == max) tmp.add(2);
        if(p3 == max) tmp.add(3);

        int[] answer = new int [tmp.size()];
        for(int i=0; i< tmp.size(); i++) answer[i]= tmp.get(i);
        
        return answer;
    }
}