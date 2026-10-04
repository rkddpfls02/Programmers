import java.io.*;

public class  Solution {
    private static int[] cards;
    private static boolean[] complete;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

        int T= Integer.parseInt(br.readLine());
        StringBuilder sb= new StringBuilder();

        for (int i = 1; i <= T; i++) {
            sb.append("#").append(i).append(" ");
            String s= br.readLine();
            cards= new int[10]; // 0~9
            for (int j = 0; j < 6; j++) cards[s.charAt(j)-'0'] ++;

            sb.append(babyJin()).append("\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    private static boolean babyJin() {
        for (int i = 0; i < cards.length; i++) {
            if (cards[i]== 6) return true;
            if (cards[i]>=3) cards[i] -=3;

            if(cards[i]< 3 && i< cards.length -2){
                if(cards[i+1] == cards[i+2] && cards[i] == cards[i+1]) {
                    cards[i]= 0;
                    cards[i+1]= 0;
                    cards[i+2]= 0;
                }
            }

        }

        for (int card : cards) if (card != 0) return false;
        return true;
    }

}
