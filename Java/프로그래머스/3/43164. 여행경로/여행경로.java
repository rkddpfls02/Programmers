import java.util.*;

class Solution {
    
    static boolean[] used;
    static List<String> tmp; 
    String[][] tickets;
    
    public String[] solution(String[][] tickets) {
        used= new boolean [tickets.length];
        Arrays.fill(used, false);
        
        this.tickets= tickets;
        Arrays.sort(tickets, (a1,a2)-> {return a1[1].compareTo(a2[1]);});
        
        tmp= new ArrayList<>();
        dfs("ICN", "ICN", 0);
        
        return tmp.get(0).split(" ");
    }
    
    
    public void dfs(String now, String route, int cnt){
        if(cnt == tickets.length) {
            tmp.add(route);
            return;
        }
        
        for(int i=0; i< tickets.length; i++) {
            if(!used[i] && tickets[i][0].equals(now)) {
                used[i]= true; 
                dfs(tickets[i][1], route +" "+ tickets[i][1], cnt+1);
                used[i]= false; // 이 순서로 티켓 쓰는게 잘못될 수도 있어서 
            }
        }
        
    }
}