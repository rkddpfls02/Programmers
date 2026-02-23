import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n= Integer.parseInt(br.readLine());
        int[] dp= new int[n];
        int[] arr = new int[n];
        int ans= 1;

        String[] s = br.readLine().split(" ");
        for(int i=0; i< n; i++) arr[i]= Integer.parseInt(s[i]);

        dp[0]=1;
        for(int i= 1; i< n; i++){
            dp[i]=1;
           for(int j= 0; j< i; j++) if(arr[j]> arr[i]) dp[i]= Math.max(dp[i], dp[j]+1);
        }

        for(int i=0; i<n; i++) ans= Math.max(ans, dp[i]);
        bw.write(Integer.toString(ans));
        bw.flush();

    }

}