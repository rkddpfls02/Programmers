import java.util.*;
class Solution {
    public int answer= 0;
    public int[] numbers;
    public int target;
    
    public int solution(int[] numbers, int target) {
        this.target= target;
        this.numbers= numbers;
        dfs(0,0);
        return answer;
    }
    
    public void dfs(int i, int total){
        if (i== numbers.length) { // 마지막까지 더한 상태
            if(total == target) answer ++;
            return;
        }
        
        dfs(i+1, total+ numbers[i]);
        dfs(i+1, total- numbers[i]);

        
    }
}