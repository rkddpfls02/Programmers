import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st= new StringTokenizer(br.readLine());
        StringBuilder sb =  new StringBuilder();
        int a= Integer.parseInt(st.nextToken());
        int b= Integer.parseInt(st.nextToken());

        for (int i=a; i<= b; i++) if(i !=1 && checkPrime(i)) sb.append(i).append("\n");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

    private static boolean checkPrime(int n) {
        for(int i=2; i<= Math.sqrt(n); i++){  //1부터 시작하면 항상 false, 2부터 시작
            if(n%i==0) return false;
        }
        return true;
    }
}
