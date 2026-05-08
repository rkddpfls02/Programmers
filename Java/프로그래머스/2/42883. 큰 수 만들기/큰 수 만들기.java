import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Integer> stack= new Stack<>();
        int cnt=0;
        int idx=0;
        
        while(idx<number.length()){
            int num= number.charAt(idx)-'0';
            while(cnt<k && !stack.isEmpty() && stack.peek()< num ){
                stack.pop();
                cnt ++;
            }
            stack.add(num);
            idx++;
        }
        
        if (cnt==0) return number.substring(0, number.length()-k);
        
        String answer="";
        while(!stack.isEmpty()){
            answer = stack.pop()+ answer;
        }
        
        return answer;
    }
}