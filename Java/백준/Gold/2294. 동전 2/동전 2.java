import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s= br.readLine().split(" ");
        int n= Integer.parseInt(s[0]);
        int t= Integer.parseInt(s[1]); // 타겟 가치합

        int[] v= new int[n]; // 동전 가치 배열
        int[] dp = new int[t+1]; // 특정 금액을 만드는데 필요한 동전의 개수, 1~ t
        Arrays.fill(dp, Integer.MAX_VALUE);

        for(int i=0; i< n; i++) {
            v[i]= Integer.parseInt(br.readLine());
            if(v[i]<=t) dp[v[i]]= 1;
        }
        //i는 현재가치
        for(int i= 1; i<= t; i++){
            for (int j=0; j<n; j++){
                if(i> v[j] && dp[i-v[j]] != Integer.MAX_VALUE) dp[i]= Math.min(dp[i-v[j]]+1, dp[i]);
            }
        }
        bw.write(Integer.toString(dp[t]== Integer.MAX_VALUE ? -1: dp[t]));
        bw.flush();

    }

}