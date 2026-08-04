import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        int[] p1= { 1, 2, 3, 4, 5};
        int[] p2= { 2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3= {  3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
        
        int[] s= new int [3];
        
        for(int i=0; i< answers.length; i++){
            s[0]+= answers[i]== p1[i% p1.length]? 1:0;
            s[1]+= answers[i]== p2[i% p2.length]? 1:0;
            s[2]+= answers[i]== p3[i% p3.length]? 1:0;
        }
        
        List<Integer> list= new ArrayList<>();
        int max=  Math.max(Math.max(s[0], s[1]),s[2]);
        for(int i=0; i<3; i++) if(s[i]== max) list.add(i+1);
        
        int[] answer= new int [list.size()];
        for(int i=0; i< answer.length; i++) answer[i]= list.get(i);
        
        return answer;
    }
}