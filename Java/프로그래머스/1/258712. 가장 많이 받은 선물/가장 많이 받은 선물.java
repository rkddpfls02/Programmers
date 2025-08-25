import java.util.*;
class Solution {
    
    public int solution(String[] friends, String[] gifts) {
        int n= friends.length;
        int[] answer = new int[n];
        int[][] gift= new int [n][n];
        int [] receive= new int[n];
        int [] give= new int[n];
        
        Map<String, Integer> friend= new HashMap<>();
        for(int i=0; i<n;i++) friend.put(friends[i],i);
        
        for(String tmp: gifts){
            String[] s= tmp.split(" ");
            int a= friend.get(s[0]);
            int b= friend.get(s[1]);
            gift[a][b] ++;
            receive[b] ++;
            give[a]++;
        }
        
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                if(gift[i][j]>gift[j][i]) answer[i]++;
                else if(gift[i][j]<gift[j][i]) answer[j]++;
                else {
                    int aScore= give[i]- receive[i];
                    int bScore= give[j]- receive[j];
                    if(aScore> bScore) answer[i]++;
                    else if(aScore< bScore) answer[j]++;
                }
                
            }
        
        }
        
        Arrays.sort(answer);
        return answer[n-1];
    }
}