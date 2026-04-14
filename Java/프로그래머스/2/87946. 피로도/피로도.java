import java.util.*;
class Solution {
    
    static boolean [] visited;
    static int max=0;
    static int[][] dungeons;
    
    public int solution(int k, int[][] dungeons) {
        visited= new boolean[dungeons.length];
        Arrays.fill(visited, false);
        this.dungeons= dungeons;
            
        for(int i=0; i< dungeons.length; i++){
            dfs(i, 0, k);
            visited[i]= false;
        }
        
        return max;
    }
    
    public void dfs(int now, int cnt, int k){
        
        // 방문한 던전 가능 여부 
        visited[now] = true;
        if(dungeons[now][0]<= k) {
            cnt ++;
            k-= dungeons[now][1];
            max= Math.max(max, cnt);
        }
        
        // 다음 던전 방문
        for(int i=0; i< dungeons.length; i++) {
            
            if(!visited[i] && i != now) {
                dfs(i, cnt, k);
                visited[i] = false; // 백트래킹
            }
        }
        
    }
}