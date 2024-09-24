import java.io.*;

public class Main  {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        int sum=0;
        int bous=0;
        String s= br.readLine();
        for(int i=0; i<n;i++){
            if (s.charAt(i)==79) {
                sum += i+1+bous;
                bous += 1;
            }
            else {
                bous=0;
            }
        }
        System.out.println(sum);
    }
}