import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n= Integer.parseInt(br.readLine());
        int m= Integer.parseInt(br.readLine());

        List<Integer>[] adjList= new ArrayList[n+1];
        for (int i=1; i<=n; i++) adjList[i]= new ArrayList<>();

        boolean[] visited= new boolean[n+1];
        Arrays.fill(visited, false);

        for(int i=0; i<m; i++) {
            String[] s= br.readLine().split(" ");
            adjList[Integer.parseInt(s[0])].add(Integer.parseInt(s[1]));
            adjList[Integer.parseInt(s[1])].add(Integer.parseInt(s[0]));
        }

        int cnt= bfs(adjList, visited);

        bw.write(Integer.toString(cnt));
        bw.flush();
        bw.close();
        br.close();
    }

    private static int bfs(List<Integer>[] adjList, boolean[] visited) {
        int cnt=0;
        Queue<Integer> queue= new LinkedList<>();

        queue.add(1);
        visited[1]= true;

        while(!queue.isEmpty()){
            int now= queue.poll();

            for(int computer: adjList[now]){
                if (!visited[computer]) {
                    visited[computer]= true;
                    queue.add(computer);
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
