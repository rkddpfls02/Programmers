import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] s= new String[numbers.length];
        
        for(int i=0; i< numbers.length; i++) {
            s[i]= String.valueOf(numbers[i]);
         }
        
        Arrays.sort(s, (s1, s2) -> (s2+s1).compareTo(s1+s2));
        
        
        StringBuilder sb= new StringBuilder();
        for(int i=0; i< numbers.length; i++) {
            
            if(s[0].equals("0")) return "0";
            else sb.append(s[i]);
        }
        
        return sb.toString();
    }
    
}