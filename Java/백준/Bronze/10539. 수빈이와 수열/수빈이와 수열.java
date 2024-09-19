import java.io.*;

public class Main  {

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int [] a = new int[n];
        for (int i= 0; i< n; i++){
            a[i] = Integer.parseInt(s[i]);
        }
        int sum= a[0];
        System.out.print(sum +" ");
        for (int i= 1; i< n; i++){
            a[i]= a[i]* (i+1) - sum;
            sum += a[i];
            System.out.print(a[i]+" ");
        }
}
}