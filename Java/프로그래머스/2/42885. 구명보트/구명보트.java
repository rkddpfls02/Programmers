import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        
        Arrays.sort(people);
        int answer = 0;
        int n= people.length;

        int left=0;
        int right= n-1;
        
        while(left<= right){
            
            if(people[left]+people[right]<= limit) { 
                left++;   
            }
            answer ++;
            right--;
        }

        return answer;
    }
}