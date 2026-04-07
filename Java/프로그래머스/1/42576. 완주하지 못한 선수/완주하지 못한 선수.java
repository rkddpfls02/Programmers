import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        Map <String, Integer> map= new HashMap<>();
        for(String person : completion) {
            if(!map.containsKey(person)) map.put(person,1);
            else {
                map.put(person, map.get(person)+1);
            }
        }

        for(String person : participant){
            if(!map.containsKey(person)) return person; // 없으면 바로 답
            else { // 있으면 1보다 크면 하나 빼고 아니면 없애기
                if(map.get(person) > 1) map.put(person, map.get(person)-1);
                else map.remove(person);
            }
        }

        for(String answer: map.keySet()) return answer;
        
        return "";
}
}