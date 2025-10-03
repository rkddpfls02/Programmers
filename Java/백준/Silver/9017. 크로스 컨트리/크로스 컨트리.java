import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static class Team implements Comparable<Team>{
        int count;
        int nowcnt;
        int score;
        int fiveScore;
        // 개수, 점수, 5등 점수

        @Override
        public int compareTo(Team o) {
            if(this.score== o.score){
                return this.fiveScore- o.fiveScore;
            } else return this.score- o.score;
        }

    }


        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int t= Integer.parseInt(br.readLine());


            for(int i=0; i<t; i++) {

                Map<Integer, Team> map= new HashMap<>();

                int n= Integer.parseInt(br.readLine());

                int[] ids= Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

                for(int j=0; j<n; j++){
                    int id= ids[j];
                    if(!map.containsKey(id)) map.put(id, new Team());
                    Team now= map.get(id);
                    now.count++; // 개수
                }

                map.values().removeIf(team -> team.count < 6);

                int rank=1;

                for(int j=0; j<n; j++){
                    int id= ids[j];
                    if(!map.containsKey(id)) continue;
                    Team now= map.get(id);
                    now.nowcnt++;
                    if(now.nowcnt<5) now.score += rank; // 점수
                    if(now.nowcnt==5) now.fiveScore= rank;
                    rank++;
                }


                List<Map.Entry<Integer,Team>> sortedMap =map.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue())
                                .collect(Collectors.toList());

                bw.write(sortedMap.get(0).getKey()+"\n");

            }
            
            bw.flush();
            bw.close();
            br.close();
        }
    }