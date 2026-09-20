import java.io.*;
import java.util.*;

class Solution
{
    static class Atom{
        int x;
        int y;
        int K;
        int dir;
        boolean alive;

        Atom(int x, int y, int K, int dir){
            this.x= x;
            this.y= y;
            this.K= K;
            this.dir= dir;
            this.alive= true;
        }


    }
    public static void main(String args[]) throws Exception
    {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

        int[] dx= {0, 0, -1, 1}; // 상하좌우
        int[] dy= {1, -1, 0, 0};

        int T= Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb= new StringBuilder();

        // 현재 map에 상태
        int[][] map= new int[4001][4001];

        for(int test_case = 1; test_case <= T; test_case++) {
            int N= Integer.parseInt(br.readLine());
            int sum=0;

            // 특정 방향인 점들
            Atom [] atoms= new Atom[N];

            for (int i = 0; i < N; i++) {
                st= new StringTokenizer(br.readLine());
                int x = (Integer.parseInt(st.nextToken())+1000)*2;
                int y= (Integer.parseInt(st.nextToken())+1000)*2;
                int dir= Integer.parseInt(st.nextToken());
                int K= Integer.parseInt(st.nextToken());

                atoms[i]= new Atom(x, y, K,dir);
            }

            // 배열을 넘어갔거나 충돌해서 없앤 원소들
            int cnt= 0;

            // 원소 다 없앨 때까지
            while (cnt <N){

                // 모든 원소 이동 시키기
                for (int i = 0; i < N; i++) {
                    Atom atom = atoms[i];

                    // 이미 없는 원소는 패스
                    if (!atom.alive) continue;

                    // 이동
                    atom.x += dx[atom.dir];
                    atom.y += dy[atom.dir];

                    // 배열을 넘어가면 충돌 가능성이 없는 것
                    if(atom.x <0 || atom.y<0 || atom.x > 4000 || atom.y> 4000) {
                        cnt++;
                        atom.alive= false;
                        continue;
                    }

                    // 맵에 기록
                    map[atom.x][atom.y]+= atom.K;
                }

                // 충돌 원소들 에너지 더해주기
                for (int i = 0; i < N; i++) {
                    Atom atom = atoms[i];

                    // 충돌 에너지 저장
                    if(atom.alive && map[atom.x][atom.y]> atom.K) {
                        cnt++;
                        sum+= atom.K;
                        atom.alive= false;
                    }

                }

                for (int i = 0; i < N; i++) {
                    Atom atom = atoms[i];

                    // 맵 초기화 시켜줄건데 배열 넘어가는 애들 빼고 0으로 초기화
                    if(atom.x <0 || atom.y<0 || atom.x > 4000 || atom.y> 4000) continue;
                    map[atom.x][atom.y]= 0;
                }

            }

            sb.append("#").append(test_case).append(" ").append(sum).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}