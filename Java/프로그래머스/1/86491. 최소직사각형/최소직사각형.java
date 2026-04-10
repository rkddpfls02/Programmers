import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int n= sizes.length;
        int bigger []= new int [n];
        int smaller []= new int [n];
        
        for(int i=0; i< n; i++){
            bigger[i]= Math.max(sizes[i][0], sizes[i][1]);
            smaller[i]= Math.min(sizes[i][0], sizes[i][1]);
        }
        
        Arrays.sort(smaller);
        Arrays.sort(bigger);
        
        return bigger[n-1] * smaller[n-1];
    }
}