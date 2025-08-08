import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int n= Integer.parseInt(br.readLine());

        StringTokenizer st= new StringTokenizer(br.readLine());
        int[] fruits= new int[n];
        Map<Integer,Integer> cnt= new HashMap<>();

        for (int i=0; i<n; i++){
             fruits[i]= Integer.parseInt(st.nextToken());
        }

        int left= 0;
        int max=0;

        for(int right=0; right<n; right++){
            cnt.put(fruits[right], cnt.getOrDefault(fruits[right],0)+1);

            while(cnt.size()>2){
                int tmp= fruits[left];
                cnt.put(tmp, cnt.get(tmp)-1);
                if (cnt.get(tmp)==0) cnt.remove(tmp);
                left++;
            }

            max= Math.max(max, right-left+1);

        }

        bw.write(Integer.toString(max));
        bw.flush();
        bw.close();
        br.close();

    }


}
