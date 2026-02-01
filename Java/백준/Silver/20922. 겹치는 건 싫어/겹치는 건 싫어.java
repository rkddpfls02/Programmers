import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int n= Integer.parseInt(st.nextToken());
        int k= Integer.parseInt(st.nextToken());

        int [] nums= new int [n];
        int [] frequency= new int [100001];

        int start= 0;
        int end= 0;
        int cnt= 0;
        int maxlen= Integer.MIN_VALUE;

        st= new StringTokenizer(br.readLine());
        for(int i=0; i< n; i++) nums[i]= Integer.parseInt(st.nextToken());

        while(end<n && start<= end){

            frequency[nums[end]]++;

            while (frequency[nums[end]]> k) {
                frequency[nums[start]]--;
                start++;
                cnt--;
            }

            cnt++;
            maxlen= Math.max(maxlen, cnt);
            end ++;

        }

        bw.write(Integer.toString(maxlen));
        bw.flush();
        bw.close();
        br.close();

    }

    }
