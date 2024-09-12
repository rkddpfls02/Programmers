import java.io.*;
import java.util.*;

public class Main  {

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s= br.readLine();
        String[] suffix= new String[s.length()];
        for (int i=0; i<s.length(); i++){
            suffix[i]= s.substring(i);
        }
        Arrays.sort(suffix);

        for (int i=0; i<suffix.length; i++){
            bw.write(suffix[i]+'\n');
        }
        bw.flush();
    }
}