import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        String[] s= br.readLine().split(" ");
        int num;
        // 해당 인덱스로 끝나는 것 중 가장 긴 수열 길이를 저장
        int [] maxlen= new int[n];
        int[] arr= new int[n];
        int ans=1;

        for (int i=0; i< n; i++) {
            arr[i]= Integer.parseInt(s[i]);
            maxlen[i]=1;
        }

        for (int i=0; i< n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j]< arr[i]) {
                    maxlen[i]= Math.max(maxlen[i],maxlen[j]+1);
                }
            }
            ans= Math.max(ans, maxlen[i]);
        }

        System.out.println(ans);

    }
}