import java.util.*;
class Solution {
    public String solution(String number, int k) {
        
        Deque<Integer> stack= new ArrayDeque<Integer>();
        char[] nums= number.toCharArray();
        
        StringBuilder sb= new StringBuilder();
        
        for(int i=0; i< nums.length; i++){
            int now= nums[i]-'0';
            
            while(!stack.isEmpty() && stack.peekFirst()< now && k> 0) {
                k--;
                stack.pop();
            }
            
            stack.push(now);
        }
        
        if(k !=0){
            while (k !=0) {
                stack.pop();
                k--;
            }
        }
        
        
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        
        return sb.reverse().toString();
    }
}