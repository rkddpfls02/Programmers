import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        int [] students= new int [n];
        Arrays.fill(students, 1);
        
        for(int idx: lost) {
            students[idx-1] --;
        }
        
        for(int idx: reserve) {
            students[idx-1] ++;
        }
        
        for (int i= n-1; i >=0; i--) {
            
            if(students[i]==0) {
                
                if(i == n-1 && students[i-1] == 2) {
                    students[i] = 1;
                    students[i-1] =1;
                }
                
                else if(i == 0 && students[i+1] == 2){
                    students[i] =1;
                    students[i+1] =1;
                }
                
                else if (students[i+1] == 2){
                    students[i]= 1;
                    students[i+1]= 1;
                }
                
                else if (students[i-1] == 2){
                    students[i]= 1;
                    students[i-1]= 1;
                }
                
            } 
            
        }
        
        int answer = 0;
        
        for(int i=0 ; i< n ; i++){
            if(students[i]== 1 || students[i]== 2) answer ++;
        }
        
        return answer;
    }
}