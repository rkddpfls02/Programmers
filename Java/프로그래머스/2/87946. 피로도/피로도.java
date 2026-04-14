import java.util.*;
class Solution {
    
    static boolean [] visited;
    static int max=0;
    static int[][] dungeons;
    
    public int solution(int k, int[][] dungeons) {
        visited= new boolean[dungeons.length];
        Arrays.fill(visited, false);
        this.dungeons= dungeons;
    
        dfs(0, k);
        
        return max;
    }
    
    public void dfs(int cnt, int k){
        
        for(int i=0; i< dungeons.length; i++) { // i 번째에서 시작한 탐험
            max= Math.max(max, cnt);

            if(!visited[i] && dungeons[i][0]<= k) {
                visited[i] = true;
                
                // 방문안하고 k가 조건을 만족했기에 
                //다음 던전 다시 0부터 되는거 찾기 k의 상태가 바꼈으니까
                dfs(cnt+1, k-dungeons[i][1]); 
                visited[i] = false; // 백트래킹
            }
            
        }
        
    }
}