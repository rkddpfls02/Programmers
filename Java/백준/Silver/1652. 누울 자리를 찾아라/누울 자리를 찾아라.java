import java.io.*;

public class Main  {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n= Integer.parseInt(s);
        int length=0;
        int width=0;
        int blank_cnt=0;
        String [][] arr= new String[n][n];

        for(int i=0; i< n; i++){
            s= br.readLine();
            arr[i]= s.split("");
        }


        for (int i=0; i< n; i++){
            for(int j=0; j< n; j++){
                if(arr[i][j].equals(".")){
                    blank_cnt ++;
                    if (blank_cnt==2) length++;
                }
                else blank_cnt=0;
            }
            blank_cnt=0;
        }

        for (int i=0; i< n; i++){
            for(int j=0; j< n; j++){
                if(arr[j][i].equals(".")){
                    blank_cnt ++;
                    if (blank_cnt==2) width++;
                }
                else blank_cnt=0;
            }
            blank_cnt=0;
        }

        System.out.println(length+" "+width);

    }


}