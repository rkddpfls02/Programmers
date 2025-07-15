import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for (int i=0; i<n; i++) {
            bw.write(checkScore(br.readLine())+"\n");
            bw.flush();

        }

        bw.close();
        br.close();
    }

    private static int checkScore(String s) {
        int total=0;
        int now=0;
        String[] ans= s.split("");

        for(String tmp: ans){
             if (tmp.equals("O")){
                 now++;
                 total+= now;
             }
             else now= 0;

             }
        return total;
        }

    }

