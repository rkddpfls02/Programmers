import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    private static int[][] map;
    private static int maxHouse;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T= Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb= new StringBuilder();


        for(int test_case = 1; test_case <= T; test_case++) {
            maxHouse= 0;

            st= new StringTokenizer(br.readLine());

            int n= Integer.parseInt(st.nextToken());
            int m= Integer.parseInt(st.nextToken());

            map= new int[n][n];
            for (int i = 0; i < n; i++) {
                st= new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j]= Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    makeService(i, j, 2*n, m);
                }
            }

            sb.append("#").append(test_case).append(" ").append(maxHouse).append("\n");

        } // end of testcases

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    } // end of main

    private static void makeService(int i, int j, int k, int m) {

        int cost= k*k+(k-1)*(k-1);
        int cnt= cntHouse(i,j,k);
        int profit= cnt*m - cost;

        while(profit < 0){
            k--;
            cost= k*k+(k-1)*(k-1);
            cnt= cntHouse(i,j,k);
            profit= cnt*m - cost;
        }

        maxHouse = Math.max(maxHouse, cnt);

    }

    private static int cntHouse(int i, int j, int k) {
        int n= map.length;

        int starti = Math.max(i-k, 0);
        int startj = Math.max(j-k, 0);

        int endi= Math.min(i+k, n-1);
        int endj= Math.min(j+k, n-1);

        int cnt=0;

        for (int l = starti; l <= endi; l++) {
            for (int m = startj; m <= endj; m++) {
                if (Math.abs(i-l)+ Math.abs(j-m)<= k-1 && map[l][m]==1) cnt++;
            }
        }

        return cnt;

    }
}// end of class
