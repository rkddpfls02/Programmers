import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main  {

    public static void main(String[] args) throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        String s= bf.readLine();
        String[] suffix= new String[s.length()];
        for (int i=0; i<s.length(); i++){
            suffix[i]= s.substring(i);
        }
        Arrays.sort(suffix);

        for (int i=0; i<suffix.length; i++){
            System.out.println(suffix[i]);
        }
    }
}