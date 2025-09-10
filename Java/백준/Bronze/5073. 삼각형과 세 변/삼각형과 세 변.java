import java.io.*;
import java.util.*;

public class Main {
//    Equilateral :  세 변의 길이가 모두 같은 경우
//    Isosceles : 두 변의 길이만 같은 경우
//    Scalene : 세 변의 길이가 모두 다른 경우

    static class Solution{
        public String solution(String[] input){
            int a= Integer.parseInt(input[0]), b= Integer.parseInt(input[1]);
            int c= Integer.parseInt(input[2]);
            int[] lens= {a,b,c};
            Arrays.sort(lens);

            if(lens[2]>= lens[0]+lens[1]) return "Invalid";

            Set<Integer> set= new HashSet<>();
            set.add(a);
            set.add(b);
            set.add(c);

            int size= set.size();

            if (size==3) return "Scalene";
            if (size==2) return "Isosceles";
            return "Equilateral";
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb= new StringBuilder();

        while (true) {
            String s= br.readLine();
            if(s.charAt(0)=='0') break;
            sb.append(new Solution().solution(s.split(" "))).append("\n");
        }


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}
