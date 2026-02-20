import java.util.*;
class Solution {
    public int answer= 0;
    public int[] numbers;
    public int target;
    
    public int solution(int[] numbers, int target) {
        this.target= target;
        this.numbers= numbers;
        dfs(0, 0);
        return answer;
    }
    
    public void dfs(int i, int sum){
        
        if(i==numbers.length) {
            if(sum== target) answer ++;
            return;
        }
        
        dfs(i+1, sum+ numbers[i]);
        dfs(i+1, sum- numbers[i]);
        
    }
}