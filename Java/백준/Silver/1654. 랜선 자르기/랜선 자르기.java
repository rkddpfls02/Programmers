import java.io.*;
import java.util.*;

public class Main {

    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s;
        s= br.readLine().split(" ");
        int k= Integer.parseInt(s[0]);
        List<Long> len= new ArrayList<>();
        int n= Integer.parseInt(s[1]);

        for (int i=0; i<k; i++) len.add(Long.parseLong(br.readLine()));
        Collections.sort(len);

        long max= len.get(k-1);
        long min=1;
        long ans=0;

        while(min<= max){
            long mid= (min + max)/2;
            long sum= 0;
            for(Long num : len) sum += num/mid;

            if (sum<n) max= mid-1;
            else {
                ans= mid;
                min= mid+1;}
        }

        bw.write(Long.toString(ans));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
