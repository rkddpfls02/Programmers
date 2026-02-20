import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s;
        s= br.readLine().split(" ");
        int n= Integer.parseInt(s[0]);
        int m= Integer.parseInt(s[1]);

        Set<Integer> set= new HashSet<>();
        for(String num: br.readLine().split(" ")) set.add(Integer.parseInt(num));
        for(String num: br.readLine().split(" ")) set.add(Integer.parseInt(num));


        bw.write(Integer.toString(2*set.size()-(n+m)));
        bw.flush();
        bw.close();
        br.close();

    }

    }
