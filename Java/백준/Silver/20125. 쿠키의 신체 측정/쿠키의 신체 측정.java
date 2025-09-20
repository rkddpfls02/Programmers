import java.io.*;

public class Main {


        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb= new StringBuilder();

            int n= Integer.parseInt(br.readLine());
            char[][] map= new char [n][n];
            boolean first= true;
            int[] heart= new int [2];

            for(int i=0; i<n; i++){
                String s= br.readLine();
                for(int j=0; j<n; j++){
                    char c= s.charAt(j);
                    if(first && c=='*'){
                        first= false;
                        heart[0]= i+1;
                        heart[1]= j;
                    }
                    map[i][j]= c;
                }
            }

            sb.append(heart[0]+1).append(" ").append(heart[1]+1).append("\n");

            char[] arms= map[heart[0]];
            int cnt= 0;

            // 왼팔
            for(int i=0; i< heart[1]; i++){
                if(arms[i]=='*') cnt ++;
            }

            sb.append(cnt).append(" ");
            cnt= 0;

            // 오른팔
            for(int i= heart[1]+1; i< n; i++){
                if(arms[i]=='*') cnt ++;
            }

            sb.append(cnt).append(" ");
            cnt= 0;

            // 허리
            for(int i=heart[0]+1; i< n; i++){
                if(map[i][heart[1]]=='*') cnt ++;
            }

            sb.append(cnt).append(" ");

            int start= heart[0]+ cnt;
            cnt=0;

            // 왼쪽 다리
            for(int i=start+1; i< n; i++){
                if(map[i][heart[1]-1]=='*') cnt ++;
            }

            sb.append(cnt).append(" ");

            cnt=0;
            // 오른쪽 다리
            for(int i=start+1; i< n; i++){
                if(map[i][heart[1]+1]=='*') cnt ++;
            }
            sb.append(cnt).append(" ");

            bw.write(sb.toString());
            bw.flush();
            bw.close();
            br.close();
        }
    }