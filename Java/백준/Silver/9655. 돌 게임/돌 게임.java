import java.io.*;
import java.util.*;

public class Main {


    static class Solution{


        public String solution(int n){
            if(n%2==0 || n%4==0 || n%6==0) return "CY";
            return "SK";
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n= Integer.parseInt(br.readLine());

        bw.write(new Solution().solution(n));
        bw.flush();
        bw.close();
        br.close();

    }
}
