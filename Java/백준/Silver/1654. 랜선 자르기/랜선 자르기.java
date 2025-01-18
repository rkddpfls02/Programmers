
import java.io.*;
import java.util.*;

public class Main {

    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int k= Integer.parseInt(st.nextToken());
        int n= Integer.parseInt(st.nextToken());

        long[] len= new long[k];

        for (int i=0; i<k; i++) len[i]= Long.parseLong(br.readLine());

        Arrays.sort(len);

        long min= 1; 
        long max= len[k-1];

        while(min<= max){
            long mid= (min+max)/2;
            long sum=0;
            for(long l: len) sum += l/mid;
            
            // 길이 늘려야할 경우
            if (sum >= n) min= mid+1;
            else max= mid-1;
        }



        bw.write(Long.toString(min-1));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
