import java.util.*;
class Solution {
    public int[] solution(String my_string) {
        StringBuilder sb= new StringBuilder();
        
        for(int i=0; i< my_string.length(); i++){
            char c= my_string.charAt(i);
            if(Character.isDigit(c)) sb.append(c);
        }
        
        my_string= sb.toString();
        String[] s= my_string.split("");

        int[] answer = new int[my_string.length()];                
        for(int i=0; i< s.length; i++) answer[i]= Integer.parseInt(s[i]);
        
        Arrays.sort(answer);
        
        return answer;
    }
}