import java.io.*;
import java.util.StringTokenizer;

public class Solution{
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

        int T= Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb= new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            st= new StringTokenizer(br.readLine());
            int n= Integer.parseInt(st.nextToken());
            int k= Integer.parseInt(st.nextToken());

            // 각각 물건의 부피와 가치
            int[][] vc= new int[n+1][2];

            for (int i = 1; i <= n; i++) {
                st= new StringTokenizer(br.readLine());
                int v= Integer.parseInt(st.nextToken());
                int c= Integer.parseInt(st.nextToken());

                vc[i][0]= v;
                vc[i][1]= c;

            }

            // i까지 살펴봤고 무게가 j일 때 최대 가치
            int[][] dp= new int [n+1][k+1];

            for (int i = 1; i <= n; i++) {
                int v= vc[i][0];
                int c= vc[i][1];
                for (int j = 1; j <= k; j++) {
                    // 현재 보고있는 물건의 무게보다 j가 작으면 못넣음 - j는 무게의 limit를 의미
                    // 넣지 못하면 안넣고 이 무게가 limit 였을 때의 가치와 같음
                    if (v> j) dp[i][j]= dp[i-1][j];
                    
                    // 넣을 수 있다면 안넣은 상태(i-1까지 선택 & j에서 최대 가능 무게가 i 무게만큼 적은 상태) 에서 
                    // i 가치 만큼 더한거 vs 지금꺼 안넣고도 최대 가능 무게가 j일 때 가치 중 더 큰거를 선택
                    else if (j-v>= 0)dp[i][j]= Math.max(dp[i-1][j-v]+c, dp[i-1][j]);
                }
            }

            sb.append("#").append(test_case).append(" ").append(dp[n][k]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    } //end of main
} // end of class