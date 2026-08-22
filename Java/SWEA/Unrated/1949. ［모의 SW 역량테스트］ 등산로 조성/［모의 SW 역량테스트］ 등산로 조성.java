import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    private static boolean[][] visited;
    private static int k;
    private static int[][] mountains;
    private static int [] dx= {0, 0, 1, -1};
    private static int [] dy= {1, -1, 0, -0};
    private static int max;

    private static void findRoute(int x, int y, int length, boolean used){
        max= Math.max(max, length);

        for (int i = 0; i < dx.length; i++) {
            int nx= x+ dx[i];
            int ny= y+ dy[i];

            if(nx>=0 && ny>=0 && nx< mountains.length && ny< mountains.length && !visited[nx][ny]){

                if (mountains[nx][ny]< mountains[x][y]){
                    visited[nx][ny]= true;
                    findRoute(nx, ny, length+1, used);
                    visited[nx][ny]= false;
                }
                else if(!used && (mountains[nx][ny]- mountains[x][y]+1)<= k){
                    visited[nx][ny]= true;
                    int tmp= mountains[nx][ny];
                    mountains[nx][ny]= mountains[x][y]-1;
                    findRoute(nx, ny, length+1, true);
                    mountains[nx][ny]= tmp;
                    visited[nx][ny]= false;

                }



            }
        }
    }

    public static void main(String[] args) throws Exception
    {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

        int T;
        T=Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            StringTokenizer st= new StringTokenizer(br.readLine());
            int startValue=0;
            int n= Integer.parseInt(st.nextToken());
            k= Integer.parseInt(st.nextToken());
            visited= new boolean[n][n];
            mountains= new int[n][n];
            max= Integer.MIN_VALUE;

            for (int i = 0; i <n ; i++) {
                st= new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    mountains[i][j]= Integer.parseInt(st.nextToken());
                    startValue= Math.max(startValue, mountains[i][j]);
                }

            }

            for (int i = 0; i <n ; i++) {
                for (int j = 0; j < n; j++) {
                    if(mountains[i][j]== startValue){
                        visited[i][j]= true;
                        findRoute(i,j,1,false);
                        visited[i][j]=false;
                    }
                }

            }

            bw.write("#"+test_case+" "+max);
            bw.newLine();
        }
        bw.flush();
    }
}
