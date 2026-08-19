class Solution {
    private static String target;
    private static String[] words;
    private static int min;
    private static boolean [] visited;
    
    private static boolean changeChar(String before, String after){
        
        if(before.length() != after.length()) return false;
        int cnt=0;
        for(int i=0; i< before.length(); i++) {
            if(before.charAt(i)!= after.charAt(i)) {
                if(cnt <1) cnt ++;
                else return false;
            }
        }
        
        return true;
    }
    
    private static void searchWords(int cnt, String now){
                
         if(now.equals(target)) {
            System.out.print(now);
            min= Math.min(cnt, min);
            return;
        }
        
        for(int i=0; i< words.length; i++) {
            if(!visited[i] && changeChar(now, words[i])) {
                visited[i]= true;
                searchWords(cnt+1, words[i]);
                visited[i]= false;
            }
        }
        
    }
    
    public int solution(String begin, String target, String[] words) {
        this.words= words;
        this.target= target;
        min= Integer.MAX_VALUE;
        visited= new boolean[words.length];
        
        boolean isTarget= false;
        for(String word: words) if(target.equals(word)) isTarget= true;
        
        if(!isTarget) return 0;
        
        searchWords(0, begin);
        
        return min;
    }
}

