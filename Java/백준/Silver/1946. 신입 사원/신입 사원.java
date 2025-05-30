import java.io.*;
import java.util.*;


public class Main {
    //지원자 점수 관련 클래스
    static class score implements Comparable<score>{
        int documentScore, interviewScore;
        public score(int dScore, int iScore){
            documentScore = dScore;
            interviewScore = iScore;
        }
        //지원자 정렬 시 서류 점수로 오름차순 정렬 정의
        @Override
        public int compareTo(score o) {
            return this.documentScore - o.documentScore;
        }
    }
    public static void main(String[] args) throws IOException{
        //입력값 처리하는 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //결과값 출력하는 BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        //각 테스트 케이스 진행
        for(int i=0;i<T;i++){
            int N = Integer.parseInt(br.readLine());
            ArrayList<score> list = new ArrayList<>();
            //지원자들 점수 저장
            for(int j=0;j<N;j++){
                st = new StringTokenizer(br.readLine()," ");
                int score1 = Integer.parseInt(st.nextToken());
                int score2 = Integer.parseInt(st.nextToken());
                list.add(new score(score1, score2));
            }
            //지원자 서류 순위로 오름차순 정렬
            Collections.sort(list);
            int answer = 1;
            //서류 순위 오름차순에서 면접 순위가 높은 값 저장
            int min = list.get(0).interviewScore;
            //각 지원자들 서류 순위 더 높은 지원자들 면접 순위 비교
            for(int j=1;j<N;j++){
                //면접 순위가 현재 최소 순위보다 높을 때
                if(list.get(j).interviewScore < min){
                    min = list.get(j).interviewScore;
                    answer++;
                }
            }
            bw.write(answer + "\n");	//합격 인원 BufferedWriter 저장
        }
        bw.flush();		//결과 출력
        bw.close();	
        br.close();
    }
}