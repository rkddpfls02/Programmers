import java.util.*;
class Solution {
    static class Bridge implements Comparable<Bridge>{
        
        int start;
        int end;
        int cost;
        
        Bridge(int start, int end, int cost){
            this.start= start;
            this.end= end;
            this.cost= cost;
        }
        
        @Override
        public int compareTo(Bridge o){
            return this.cost- o.cost;
        }
        
    }
    
    static int find (int x){
        if(parent[x]==x) return x;
        return parent[x]= find(parent[x]);
    }
    
    static void union(int a, int b){
        a= find(a);
        b= find(b); // 각자의 최상위부모
        
        if(a != b) parent[a]= b; // 한쪽에 흡수
    }
        
    static int [] parent;
    
    public int solution(int n, int[][] costs) {
        
        parent= new int [n];
        Queue<Bridge> bridges= new PriorityQueue<>();
        
        for(int i=0; i< n; i++){
            parent[i]= i; // 부모 자기자신
        }
        
        for(int[] cost: costs) {
            bridges.offer(new Bridge(cost[0], cost[1], cost[2]));
        }
        
        int cnt=0;
        int total=0;
        
        while(cnt< n-1 && !bridges.isEmpty()){
            Bridge min= bridges.poll();
            int a= min.start;
            int b= min.end;
            if(find(a)!= find(b)){
                total += min.cost;
                union(a,b);
                cnt ++;
            }
        }
        
        return total;
    }
}