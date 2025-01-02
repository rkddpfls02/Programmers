import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public int binarySearch(List<Integer> A, int b){
        int mid= A.size()/2;
        if(A.get(mid)<b) {
            if(mid+1>A.size()-1) return 0;
            return binarySearch(A.subList(mid+1,A.size()),b);}
        else if (A.get(mid)>b) {
            if(mid==0) return 0;
            return binarySearch(A.subList(0,mid),b);}
        else return 1;
    }

    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

        int n= Integer.parseInt(br.readLine());
        String[] s= br.readLine().split(" ");

        List<Integer> A= new ArrayList<>();

        for(int i=0; i<n; i++) A.add(Integer.parseInt(s[i]));

        Collections.sort(A);

        n= Integer.parseInt(br.readLine());
        s= br.readLine().split(" ");

        //이진 탐색
        for(int i=0; i<n; i++) bw.write(binarySearch(A,Integer.parseInt(s[i]))+"\n");

        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
