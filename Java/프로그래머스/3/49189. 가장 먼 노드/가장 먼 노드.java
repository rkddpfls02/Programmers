import java.util.*;

class Solution {
    
    static int[] dist;
    public int solution(int n, int[][] edge) {
        
        dist= new int[n+1];
        List[] arr = new List[n+1];
        
        for(int i=1; i<=n ; i++) arr[i]= new ArrayList<Integer>();
        
        for(int[] e: edge){
            
            int start= e[0];
            int end= e[1];
            
            arr[start].add(end);
            arr[end].add(start);
            
        }
        
        Queue<Integer> q= new LinkedList<>();
        q.offer(1);
        dist[1]=1;
        
        while(!q.isEmpty()){
            int now= q.poll();
            List<Integer> tmp= arr[now];
            
            for(int j: tmp){
                
                if(dist[j]==0) {
                    dist[j]= dist[now]+1;
                    q.offer(j);
                } 
            }
            
        }
        
        Arrays.sort(dist);
        
        int max= dist[n];
        int cnt= 0;
        
        for(int i= n; i>0; i--) if (dist[i] == max) cnt++;
        
        return cnt;
    }
    
    
  
}