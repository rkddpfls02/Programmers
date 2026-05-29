import java.util.*;
class Solution {
    public int solution(int[] topping) {
        Map<Integer, Integer> me= new HashMap<>();
        Map<Integer, Integer> sister= new HashMap<>();
        
        int cnt=0;
        for(int i= 0; i< topping.length; i++){
                sister.put(topping[i], sister.getOrDefault(topping[i],0)+1);
        }

        for(int i=0; i< topping.length; i++){
            me.put(topping[i], sister.getOrDefault(topping[i],0)+1);
            sister.put(topping[i],sister.get(topping[i])-1);
            if(sister.get(topping[i])==0) sister.remove(topping[i]);
            
            if(me.size()== sister.size()) cnt++;
        }
        
        return cnt;
    }
}