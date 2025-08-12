import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        public static void main(String[] args) throws IOException {
            StringTokenizer st= new StringTokenizer(br.readLine());
            int n= Integer.parseInt(st.nextToken());
            int m= Integer.parseInt(st.nextToken());
            int [] num= new int[n];

            st= new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++) num[i]= Integer.parseInt(st.nextToken());

            int max= findMaxValue(num,n,m);

            bw.write(Integer.toString(max));
            bw.flush();
            bw.close();
            br.close();

        }

    private static int findMaxValue(int[] num, int n, int m) {
        int max= Integer.MIN_VALUE;
        for(int left= 0; left<n-2; left++){
            for (int mid=left+1; mid<n-1; mid++){
                for(int right= mid+1; right< n; right++){
                    int sum= num[left] +num[mid]+ num[right];
                    if (sum==m) return m;
                    if(sum<m) max= Math.max(sum, max);
                }
            }
        }

        return max;
    }

}
