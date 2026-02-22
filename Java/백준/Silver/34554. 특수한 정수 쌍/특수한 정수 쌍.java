import java.io.*;

public class Main {

    static StringBuilder sb= new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t= Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            int n= Integer.parseInt(br.readLine());
            if(isPrime(1+n)) sb.append(1).append("\n").append(1).append(" ").append(n+1);
            else sb.append(0);
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();

    }

    private static boolean isPrime(int a) {
        if (a < 2) return false;
        for(int i=2; i*i <= a; i++) if(a%i==0) return false;
        return true;
    }
}