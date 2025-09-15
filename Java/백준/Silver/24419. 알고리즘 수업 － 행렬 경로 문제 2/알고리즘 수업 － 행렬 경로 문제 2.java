import java.io.*;

public class Main {


        // 올바른 DP 점화식은 매 단계마다 MOD 연산을 적용하여 값이 항상 MOD 범위 안에 있도록 하는 것

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int n = Integer.parseInt(br.readLine());
            int mod= 1000000007;
            long [][] dp= new long [n][n];

            // 첫번째 열이나 행이면 각자의 왼쪽이나 윗쪽만 신경쓰면 되니까 초기값 전에꺼 +1씩
            dp[0][0]=1;
            for(int i=1; i<n; i++) {
                dp[0][i]= i+1;
                dp[i][0]= i+1;
            }

            for(int i=1; i< n; i++){
                for(int j=1; j< n; j++){
                    dp[i][j]= (dp[i-1][j]+ dp[i][j-1] +1) % mod;
                }
            }




            bw.write((dp[n-1][n-1]+1)% mod+" "+(n*n)%mod);
            bw.flush();
            bw.close();
            br.close();
        }
    }