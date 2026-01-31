import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[] h= new int[20];

    public static void main(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        int t= Integer.parseInt(br.readLine());

        for(int i=1; i<=t; i++){
            st= new StringTokenizer(br.readLine());
            st.nextToken();

            for(int j=0; j< 20; j++) h[j]= Integer.parseInt(st.nextToken());


            bw.write(i+" "+insertSort()+"\n");
            bw.flush();
        }



    }

    private static int insertSort() {
        int cnt=0;
        for (int i = 1; i < 20; i++) {
            int now= h[i];
            int j = i - 1;
            while ( j >= 0 &&  now<= h[j]) {
                cnt++;
                h[j+1]= h[j];
                j--;
            }
            h[j+1]=now;
        }

        return cnt;
    }
}