import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();

        
        String [] s = new String [numbers.length];
        
        for(int i=0; i< numbers.length; i++) {
            s[i]= Integer.toString(numbers[i]);
        }
        
        Arrays.sort(s, (o1,o2) -> {
            String s1= o1 + o2;
            String s2 = o2 + o1;
            return s1.compareTo(s2);
        });
        
        if(s[s.length-1].equals("0")) return "0";
            
        for(int i= numbers.length-1 ;i>=0 ;i--) {
            answer.append(s[i]);
        }
        
        return answer.toString();
            
        }
        
    }