import java.io.*;
import java.util.Arrays;

public class Main {

    
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            String[] s= br.readLine().split(" ");
            int n= Integer.parseInt(s[0]);
            int k= Integer.parseInt(s[1]);

            int[] w= new int [n];
            int[] v= new int [n];
            int[] dp= new int [k+1]; // 현재 무게가 k인 경우 중 max


            for(int i=0; i<n; i++) {
                s= br.readLine().split(" ");
                w[i]= Integer.parseInt(s[0]);
                v[i]= Integer.parseInt(s[1]);
            }

            for(int i=0; i< n; i++){
                for(int total= k; total>= w[i]; total--){
                    dp[total]= Math.max(dp[total],dp[total-w[i]]+v[i]);
                    // 현재 이 무게의 최댓값 (dp[total]) 과 현재 무게가 들어갔을때 value + 남은 무게 최대 value(dp[total-현재무게])
                }
            }

            Arrays.sort(dp);


            bw.write(Integer.toString(dp[k]));
            bw.flush();
            bw.close();
            br.close();
        }
    }