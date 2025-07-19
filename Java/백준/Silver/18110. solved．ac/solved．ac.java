import java.io.*;
import java.util.Arrays;

public class Main {
    static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n= Integer.parseInt(br.readLine());
        int remove= (int) Math.round(n*0.15);
        int[] score= new int[n];

        for(int i= 0; i<n; i++) {
            score[i]= Integer.parseInt(br.readLine());
        }

        Arrays.sort(score);

        int sum=0;
        for(int i= remove; i<n-remove; i++)  sum += score[i];


        bw.write(Integer.toString(Math.round((float) sum /(n-2*remove))));
        bw.flush();
        bw.close();
        br.close();


    }



}
