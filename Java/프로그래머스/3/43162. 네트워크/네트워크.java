import java.util.*;

class Solution {
    
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        visited= new boolean[n];
        Arrays.fill(visited, false);
        
        int answer = 0;
        
        for(int i=0; i< computers.length; i++){
            if(!visited[i]) answer ++;
            dfs(i, computers);
        }
        
        return answer;
    }
    
    public void dfs(int i, int[][] computers){
        
        visited[i]= true;
        
        for(int j=0; j< visited.length; j++) {
            if(computers[i][j]==1 && !visited[j]) dfs(j, computers);
            
        }
    }
    
}