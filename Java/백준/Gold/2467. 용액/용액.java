import java.io.*;
import java.util.*;

public class Main {


        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int n= Integer.parseInt(br.readLine());
            int [] liquids= new int [n];
            String[] s= br.readLine().split(" ");

            for(int i=0; i<n; i++) liquids[i]= Integer.parseInt(s[i]);

            Arrays.sort(liquids);

            int left= 0;
            int right= n-1;

            int abs= Integer.MAX_VALUE;
            int[] answer= new int [2];

            while (left< right){

                int sum= liquids[left]+ liquids[right];

                if(abs >= Math.abs(sum)) {

                    answer[0]= liquids[left];
                    answer[1]= liquids[right];

                    abs= Math.abs(sum);

                }

                if(sum<0) left++;
                else if (sum>0) right --;
                else break;

            }


            bw.write(answer[0]+" "+ answer[1]);
            bw.flush();
            bw.close();
            br.close();
        }
    }