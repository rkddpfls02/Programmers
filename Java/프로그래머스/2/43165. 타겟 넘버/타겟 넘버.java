class Solution {
    private static int [] numbers;
    private static int target;
    private static int answer;
    
    private static void dfs(int depth, int sum){
        if(depth >= numbers.length){
            if(sum == target) answer ++;
            return;
        }
        
        dfs(depth+1, sum+ numbers[depth]);
        dfs(depth+1, sum- numbers[depth]);
        
    }
    public int solution(int[] numbers, int target) {
        this.numbers= numbers;
        this.target= target;
        dfs(0,0);
        return answer;
    }
}