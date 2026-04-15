import java.util.*;
class Solution {
    static List<String> dic;
    static String[] s= { "A", "E", "I", "O", "U"};
    public int solution(String word) {

        dic= new ArrayList<>();
        dfs("",0);
        return dic.indexOf(word)+1;
    }
    
    private void dfs(String now, int depth){
        if(depth== 5) return;
        
        for(int i=0; i< s.length; i++){
            dic.add(now+s[i]);
            dfs(now+s[i], depth+1);
        }
        
    }
}