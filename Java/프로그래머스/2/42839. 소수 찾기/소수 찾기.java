import java.util.*;
class Solution {
    static int cnt=0;
    static String[] s;
    static boolean[] visited;
    static Set<Integer> set;
    
    public int solution(String numbers) {
        s= numbers.split("");
        set= new HashSet<>();
        
        visited= new boolean[s.length];
        Arrays.fill(visited, false);
        
        for(int i=1; i<= s.length; i++) {
            dfs(0,i,"");
        }
        
        for(int num: set) isPrime(num);
        
        return cnt;
    }
    
    public void isPrime(int n){
        for (int i=2; i*i <= n; i++) if(n%i==0) return;
        if (n >1)cnt ++;
    }
    
    public void dfs (int depth, int target, String num){
        if(depth== target) {
            set.add(Integer.parseInt(num));
            System.out.print(num+" ");
            return;
        } 
        
        
        for(int i=0 ; i< s.length; i++) {
            if(!visited[i]){
                visited[i]= true;
                dfs(depth+1, target, num+ s[i]);
                visited[i]= false; // 백트레킹
            }
        }
        
    }
}