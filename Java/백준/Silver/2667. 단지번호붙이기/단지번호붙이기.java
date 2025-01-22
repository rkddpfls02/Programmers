import java.io.*;
import java.util.*;

public class Main {

    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        String [] s;

        int n= Integer.parseInt(br.readLine()); // n X n
        int [][] map= new int[n][n];
        boolean [][] visited= new boolean[n][n];
        int total=0;
        List<Integer> ans= new ArrayList<>();

        for(int i=0; i<n; i++) {
            Arrays.fill(visited[i],false);
            s= br.readLine().split("");
            for(int j=0; j<n; j++) map[i][j]= Integer.parseInt(s[j]);
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(map[i][j]==1 && !visited[i][j]){
                    total++;
                    visited[i][j]= true;
                    cnt=1;
                    dfs(map, visited, i, j);
                    ans.add(cnt);
                }

            }
        }

        Collections.sort(ans);
        bw.write(total+"\n");
        for(int m: ans) bw.write(m+"\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static int cnt=1;

    private void dfs(int[][] map, boolean[][] visited, int i, int j) {
        int[] highs= {i+1,i-1};
        int[] widths= {j+1, j-1};

        for(int high : highs){
            if(high<0 || high>map.length-1) continue;
            if(!visited[high][j] && map[high][j]==1)  {
                visited[high][j]= true;
                cnt++;
                dfs(map, visited, high,j);
            }
        }

        for(int width: widths){
            if(width<0 || width>map.length-1) continue;
            if(!visited[i][width]&& map[i][width]==1) {
                visited[i][width]= true;
                cnt++;
                dfs(map, visited, i, width);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
