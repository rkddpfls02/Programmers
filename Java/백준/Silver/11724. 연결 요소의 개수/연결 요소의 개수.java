import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    static List<Integer>[] edges;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        String[] s= br.readLine().split(" ");
        int n= Integer.parseInt(s[0]);
        int m= Integer.parseInt(s[1]);
        int cnt= 0;

        edges= new List[n+1];
        visited= new boolean[n+1];

        Arrays.fill(visited, false);

        for(int i=1; i<= n; i++) edges[i]= new ArrayList<>();

        for (int i=0; i< m; i++){
            s= br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);

            edges[a].add(b);
            edges[b].add(a);
        }

        for(int i=1; i<=n; i++){
            if(!visited[i]){
                cnt++;
                dfs(i);
                visited[i]= true;
            }
        }

        bw.write(Integer.toString(cnt));
        bw.flush();
        bw.close();
        br.close();

    }

    private static void dfs(int i) {
        for(int adj: edges[i]){
            if(!visited[adj]){
                visited[adj]= true;
                dfs(adj);
            }
        }
    }


}
