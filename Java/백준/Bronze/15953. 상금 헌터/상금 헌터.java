import java.io.*;

public class Main  {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        int sum =0;
        String s;
        int rank1;
        int rank2;
        for (int i=0; i< n; i++){
            s= br.readLine();
            rank1 = Integer.parseInt(s.split(" ")[0]);
            rank2 = Integer.parseInt(s.split(" ")[1]);
            if (rank1==0) sum += 0;
            else if (rank1==1) sum += 500;
            else if (rank1 <= 3) sum += 300;
            else if (rank1 <= 6) sum += 200;
            else if (rank1 <= 10) sum += 50;
            else if (rank1 <= 15) sum += 30;
            else if (rank1 <= 21) sum += 10;

            if (rank2==0) sum += 0;
            else if (rank2==1) sum += 512;
            else if (rank2 <= 3) sum += 256;
            else if (rank2 <= 7) sum += 128;
            else if (rank2 <= 15) sum +=64;
            else if (rank2 <= 31) sum += 32;

            System.out.println(sum * 10000);
            sum=0;
        }
    }
}