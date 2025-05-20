import java.io.*;
import java.util.Arrays;

public class Main {

    static int m;
    static boolean[] visited;
    static int[] ans;
    static StringBuilder sb= new StringBuilder();
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s= br.readLine().split(" ");
        int n= Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        visited= new boolean[n];
        ans=new int[m];
        Arrays.fill(visited, false);

        dfs(n,0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int n, int depth){
        if (depth==m) {
            printAns();
            return;
        }
        // 자식들 돌기
        for (int i=1; i<=n; i++){
            if(!visited[i-1]) {
                visited[i-1]= true;
                ans[depth]= i;
                dfs(n,depth+1);
                // 자식 다 돌면 false로 바꾸기
                visited[i-1]=false;
            }
        }

    }

    private static void printAns() {
        for (int num: ans) sb.append(num).append(" ");
        sb.append("\n");
    }


    public static void main (String[]args) throws IOException {
            new Main().solution();

    }
}