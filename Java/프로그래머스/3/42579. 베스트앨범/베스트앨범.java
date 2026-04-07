import java.util.*;
class Solution {

    
    public int[] solution(String[] genres, int[] plays) {
        
        
        Map <String, Integer> genreMap = new HashMap<>();
        Map<String, List<Integer>> map= new HashMap<>();
        
        for(int i=0; i< genres.length; i++) {
            genreMap.put(genres[i], genreMap.getOrDefault(genres[i], 0)+ plays[i]);
            if(!map.containsKey(genres[i])) map.put(genres[i], new ArrayList<Integer>());
            map.get(genres[i]).add(i);
        }
        
        List<String> keyset= new ArrayList<>(map.keySet());
        Collections.sort(keyset, (k1,k2)-> {return genreMap.get(k2)- genreMap.get(k1); });
        
        
        List<Integer> answer= new ArrayList<>();
        for(String genre: keyset){
            List<Integer> tmp = map.get(genre);
            Collections.sort(tmp, (o1,o2)-> {
                if(plays[o1] == plays[o2]) return o1-o2;
                return plays[o2] - plays[o1];
            } );
            answer.add(tmp.get(0));
            if(tmp.size()> 1) answer.add(tmp.get(1));
        }
            
        int[] arr = new int [answer.size()];
        for(int i=0; i< answer.size(); i++) arr[i]= answer.get(i);
        
        return arr;
    }

}

