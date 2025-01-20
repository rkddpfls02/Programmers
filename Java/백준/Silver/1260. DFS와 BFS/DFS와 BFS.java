import java.io.*;
import java.util.*;

public class Main {

    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int n= Integer.parseInt(st.nextToken()); // 정점 수
        int m= Integer.parseInt(st.nextToken()); // 간선 수
        int v= Integer.parseInt(st.nextToken()); // 시작 정점

        boolean [] visited= new boolean[n];

        List<Integer> [] lists= new List[n];

        for (int i=0; i<n; i++){
            visited[i]= false;
            lists[i]= new ArrayList<>();
        }
        int a,b;

        for (int i=0; i<m; i++) {
            st= new StringTokenizer(br.readLine());
            a= Integer.parseInt(st.nextToken());
            b= Integer.parseInt(st.nextToken());
            lists[a-1].add(b);
            lists[b-1].add(a);
        }

        for (int i=0; i<n; i++) Collections.sort(lists[i]);

        //dfs
        dfs(visited,lists,v);
        System.out.println();
        Arrays.fill(visited, false);

        //bfs
        bfs(visited,lists,v);
    }

    private void dfs(boolean[] visited, List<Integer>[] lists, int v) {
        Iterator<Integer> it= lists[v-1].iterator();
        System.out.print(v+" ");
        visited[v-1]= true;
        while (it.hasNext()){
            int next= it.next();
            if (!visited[next-1]) dfs(visited,lists,next);
        }
    }

    public void bfs(boolean[] visited, List<Integer> [] lists, int v){
        Queue<Integer> q= new LinkedList<>();
        Iterator<Integer> it;
        q.add(v);
        System.out.print(v+" ");
        visited[v-1]= true;
        while(!q.isEmpty()){
            int now= q.remove();
            it= lists[now-1].iterator();
            while(it.hasNext()){
                int next= it.next();
                if (!visited[next-1]){
                    q.add(next);
                    System.out.print(next+" ");
                    visited[next-1]= true;
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
