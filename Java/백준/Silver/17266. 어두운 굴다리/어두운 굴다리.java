import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n= Integer.parseInt(br.readLine()); // 총 길이
        int m= Integer.parseInt(br.readLine()); // 총 개수
        StringTokenizer st= new StringTokenizer(br.readLine());
        int prev= Integer.parseInt(st.nextToken());
        int max= prev;
        int now;

        for (int i=0; i<m-1; i++){
            now = Integer.parseInt(st.nextToken());
            max= Math.max(max,(now-prev+1)/2);
            prev= now;
        }
        max= Math.max(max,n-prev);

        bw.write(Integer.toString(max));
        bw.flush();
        bw.close();
        br.close();
    }
}