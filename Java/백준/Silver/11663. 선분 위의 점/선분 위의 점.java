import java.io.*;
import java.util.*;

public class Main {

    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int n= Integer.parseInt(st.nextToken());
        int m= Integer.parseInt(st.nextToken());

        st= new StringTokenizer(br.readLine());

        List<Long> dots= new ArrayList<>();
        for (int i=0; i<n; i++) dots.add(Long.parseLong(st.nextToken()));

        Collections.sort(dots);

        for (int i=0; i<m; i++){
            st= new StringTokenizer(br.readLine());
            int start_index= lower(dots, Long.parseLong(st.nextToken()));
            int end_index= upper(dots, Long.parseLong(st.nextToken()));
            bw.write(Long.toString(end_index - start_index)+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private int lower(List<Long> dots, long l) {
        int mid;
        int left=0;
        int right= dots.size()-1;
        while (left<= right) {
            mid= (left+right)/2;
            if(dots.get(mid)>= l){
                right= mid-1;
            }
            else {
                left= mid+1;
            }
        }
        return left;
    }

    private int upper(List<Long> dots, long l) {
        int mid;
        int left=0;
        int right= dots.size()-1;

        while (left<= right) {
            mid= (left+ right)/2;
            if(dots.get(mid)<= l) {
                left= mid+1;
            }
            else {
                right= mid-1;
            }
        }
        return left;
    }


    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
