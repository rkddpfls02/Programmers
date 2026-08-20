class Solution {
    
    private static boolean[] visited;
    private static int[][] computers;
    
    private static void dfs(int node){
        for(int j=0; j< computers.length; j++){
            
            if(computers[node][j]==1 && !visited[j]) {
                visited[j]= true;
                dfs(j);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited= new boolean[n];
        this.computers= computers;
        
        for(int i=0; i< n; i++){
            if(!visited[i]){
                answer ++;
                dfs(i);
            }
        }
        
        
        return answer;
    }
}