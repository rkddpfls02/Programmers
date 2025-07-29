import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringBuilder sb= new StringBuilder();
        StringTokenizer st;

        int n= Integer.parseInt(br.readLine());
        st= new StringTokenizer(br.readLine());
        int[] dic= new int[n];

        for (int i=0; i<n; i++) dic[i]=Integer.parseInt(st.nextToken());
        Arrays.sort(dic);

        int m= Integer.parseInt(br.readLine());
        int[] cards= new int[m];
        st= new StringTokenizer(br.readLine());

        for (int i=0; i<m; i++) cards[i]=Integer.parseInt(st.nextToken());


        for (int i=0; i<m; i++) sb.append(uppwerBound(dic,cards[i])-lowerBound(dic, cards[i])).append(" ");


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();


    }

    private static int lowerBound(int[] dic, int target) {
        int start=0;
        int end= dic.length-1;
        // lowerbound 찾기
        while(start<= end){
            int mid= (start+end)/2;
            if(dic[mid]>=target) end= mid-1;
            else start= mid+1;
        }
        return start;
    }

    private static int uppwerBound(int[] dic, int target) {
        int start=0;
        int end= dic.length-1;
        // upperbound 찾기
        while(start<= end){
            int mid= (start+end)/2;
            if(dic[mid]> target) end= mid-1;
            else start= mid+1;
        }
        return start;
    }
}
