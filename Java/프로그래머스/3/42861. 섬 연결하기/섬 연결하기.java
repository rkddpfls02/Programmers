import java.util.*;
class Solution {
    private static boolean[] visited;
    static class Node {
        // 도착 정점
        int vertex;
        
        // 간선비용
        int cost;

        Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }
    }
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        visited= new boolean[n];
        List<Node>[] adj= new List[n];
        
        for(int i=0; i< n; i++) adj[i]= new ArrayList<>();
        
        for(int[] cost: costs){
            adj[cost[0]].add(new Node(cost[1],cost[2]));
            adj[cost[1]].add(new Node(cost[0],cost[2]));
        }
        
        visited[0]= true;
        Queue<Node> q= new PriorityQueue<>((n1, n2)-> n1.cost-n2.cost);
        
        // 첫 시작 노드의 인접노드 다 넣음
        for(Node node: adj[0]) q.offer(node);
        
        // q가 빌때까지 수행 왜냐면 최소값만 answer에 추가되고 더 큰값음 무시됨
        while(!q.isEmpty()) {
            Node now= q.poll();
            
            // 이미 방문했으면 무시
            // cost가 큰 노드가 먼저 들어와서 계속 남아있어서 중단 안되는 상황 방지
            if(visited[now.vertex]) continue;
            
            answer += now.cost;
            visited[now.vertex]= true;
            
            for(Node next: adj[now.vertex]) {
                // 방문안한 노드만 큐에 넣음
                if(!visited[next.vertex]) q.offer(next);
            }
        }
        
        return answer;
    }
}