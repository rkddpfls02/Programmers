import java.util.*;

class Solution {
    
    static  List<Integer>[] arr;
    static boolean[] visited;
    static int min= Integer.MAX_VALUE;
    
    public int solution(int n, int[][] wires) {
        
        for(int i=0; i< wires.length; i++){
            makeArr(wires, i, n);
            bfs();
        }
        
        
        return min;
    }
    
    public void makeArr(int[][] wires, int target, int n){
        arr= new ArrayList[n];
        
        for (int i=0; i< n; i++) arr[i]= new ArrayList<Integer>();
        
        for(int i=0; i< wires.length; i++){
            if(i== target) continue; // 와이어 하나 끊기
            
            int a= wires[i][0];
            int b= wires[i][1];
            
            arr[a-1].add(b);
            arr[b-1].add(a);
            
        }
        
        visited= new boolean[n];
        Arrays.fill(visited, false);
        
    }
    
    public void bfs(){
        Queue<Integer> queue= new LinkedList<>();
        int cnt=1;
        
        // 젤 첫 노드가 속한 집합의 개수를 cnt로 하고 나머진 n-cnt로 계산
        queue.add(1);
        visited[0]= true;
        
        while(!queue.isEmpty()){
            
            int key= queue.remove();
            
            List<Integer> tmp= arr[key-1];
            for(int adj: tmp) {
                if(! visited[adj-1]){
                    visited[adj-1]= true;
                    queue.add(adj);
                    cnt++;
                }
                
                }
        }
        min= Math.min(min, Math.abs(visited.length-2*cnt));
    }
    
    
}