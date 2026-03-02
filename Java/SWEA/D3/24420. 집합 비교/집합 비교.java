import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

        int T;
        T=Integer.parseInt(br.readLine());
        int a, b;
        String[] s;

        for(int test_case = 1; test_case <= T; test_case++)
        {
            s= br.readLine().split(" ");
            a = Integer.parseInt(s[0]);
            b = Integer.parseInt(s[1]);

            s= br.readLine().split(" ");
            Set<Integer> setA= new HashSet<>();
            for(String str: s) setA.add(Integer.parseInt(str));

            s= br.readLine().split(" ");
            Set<Integer> setB= new HashSet<>();
            for(String str: s) setB.add(Integer.parseInt(str));

            if(setA.equals(setB)) bw.write('=') ;
            else if (setB.containsAll(setA)) bw.write('<') ;
            else if (setA.containsAll(setB)) bw.write('>') ;
            else bw.write('?');
            bw.write('\n');
        }
        bw.flush();
    }
}