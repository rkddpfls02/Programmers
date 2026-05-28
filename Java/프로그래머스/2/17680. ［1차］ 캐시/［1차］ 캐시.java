import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        Queue<String> cache= new LinkedList <>(); 
        int time=0;
        
        for(int i=0; i< cities.length; i++) cities[i]= cities[i].toLowerCase();  
        
        for(String city: cities){
            
            if(cache.contains(city)) {
                time+= 1;
                cache.remove(city);
                cache.offer(city);
                continue;
            }
            else if(cache.size()< cacheSize) cache.add(city);
            else if(cache.size()> 0){
                cache.poll();
                cache.offer(city);
            }
            
            time += 5;

        }
        
        return time;
    }
}