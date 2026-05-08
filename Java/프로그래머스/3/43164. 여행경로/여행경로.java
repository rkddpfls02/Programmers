import java.util.*;
class Solution {
    
    static String[][] tickets;
    static List<String> routes= new ArrayList<>();
    static boolean[] used;
    
    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (s1, s2) -> s1[1].compareTo(s2[1]));
        
        used = new boolean[tickets.length];
        this.tickets= tickets;
        dfs("ICN","ICN",0);
        
        return routes.get(0).split(" ");
    }
    
    public void dfs(String dep, String route, int depth){
        
        if(depth>= tickets.length) {
            routes.add(route);
            return;
        }
        
        for(int i=0; i< tickets.length; i++){
            if(!used[i] && tickets[i][0].equals(dep)){
                used[i]= true;
                dfs(tickets[i][1], route+" " +tickets[i][1],depth+1);
                used[i]= false;
            } 
        }
    }
}