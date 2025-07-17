import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st= new StringTokenizer(br.readLine());
        int a= Integer.parseInt(st.nextToken());
        int b= Integer.parseInt(st.nextToken());
        int[] result= {1,1}; // 순서대로 최대, 최소

        // 최대 공약수
        for(int i=1; i<= Math.min(a,b); i++) if(a%i==0 && b%i==0) result[0]=i;

        // 최소 공배수
        result[1]= a*b/result[0];

        bw.write(result[0]+"\n"+result[1]);
        bw.flush();
        bw.close();
        br.close();
    }
}