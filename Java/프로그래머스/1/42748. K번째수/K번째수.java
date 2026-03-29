import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] result = new int[commands.length];
        int[] tmp;
        int i;
        int j;
        int k;
        
        for(int l=0; l< commands.length; l++){
            i= commands[l][0]-1;
            j= commands[l][1]-1;
            k= commands[l][2]-1;
            
            tmp= new int[j-i+1];
            
            
            for (int n= 0; n<j-i+1; n++) {
                tmp[n]= array[i+n];
            }
            
            Arrays.sort(tmp);
            result[l]= tmp[k];
        }
        
        return result;

    }
}
