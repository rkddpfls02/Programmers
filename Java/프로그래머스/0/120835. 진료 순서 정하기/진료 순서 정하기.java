import java.util.*;

class Solution {
    public int[] solution(int[] emergency) {
        Map<Integer, Integer> map= new HashMap<>();
        for (int i=0; i< emergency.length; i++) map.put(emergency[i],i);
        
        Arrays.sort(emergency);
        int[] answer = new int [emergency.length];
        
        int n= emergency.length-1;
        
        for (int i=0; i<= n; i++){
            int index= map.get(emergency[n-i]);
            answer[index]=i+1;
            
        }
        
        return answer;
    }
}