import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s=br.readLine();
        Set<String> subString= new HashSet<>();

        for (int i=0; i<s.length(); i++){
            for(int j=i; j<s.length(); j++){
                // substring 인자 (시작, 끝+1)이여야 시작부터 끝 인덱스까지 
                subString.add(s.substring(i,j+1));
            }
        }

        System.out.println(subString.size());

    }

}
