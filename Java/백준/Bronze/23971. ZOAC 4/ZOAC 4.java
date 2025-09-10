import java.io.*;
import java.util.*;

public class Main {

    static class Solution{
        public int solution(String[] input){
            int h= Integer.parseInt(input[0]), w= Integer.parseInt(input[1]);
            int n= Integer.parseInt(input[2]), m= Integer.parseInt(input[3]);
            return (h%(n+1)==0? h/(n+1): h/(n+1)+1)*(w%(m+1)==0? w/(m+1): w/(m+1)+1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String answer= Integer.toString(new Solution().solution(br.readLine().split(" ")));
        bw.write(answer);
        bw.flush();
        bw.close();
        br.close();

    }
}
