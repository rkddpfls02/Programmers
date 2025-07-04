import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N= Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 여러 값을 저장할때는 그냥 이렇게 클래스 하나 만들기
        Deque<Ballon> balloons= new ArrayDeque<>();

        for(int i=0; i<N ; i++) {
            Ballon ballon= new Ballon(i, Integer.parseInt(st.nextToken()));
            balloons.add(ballon);
        }

        while(!balloons.isEmpty()){
            Ballon ballon= balloons.pollFirst();
            sb.append(ballon.idx + 1).append(" ");

            if (balloons.isEmpty()) break;

            int move= ballon.value;
            if(move>0){
                // 오른쪽으로 이동할 땐 앞에꺼 꺼내서 뒤로 넣기
                //앞에서 꺼내고 시작하기 때문에 move-1 !!
                for(int i=0; i< move-1; i++) balloons.offerLast(balloons.pollFirst());
            }
            else {
                //왼쪽으로 갈 때는 이미 하나 꺼냈더라도 뒤의 개수가 달라지는거지 앞은 안바뀌니까 ㄱㅊ
                for(int i=0; i< Math.abs(move); i++) balloons.offerFirst(balloons.pollLast());
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static class Ballon{
        int idx;
        int value;

        Ballon(int idx, int value){
            this.idx= idx;
            this.value= value;
        }

    }
}
