class Solution {
    public int[] solution(int brown, int yellow) {
        int max= Math.max(brown,yellow);
        for(int i=3; i<= max; i++){
            for(int j=3; j<= max; j++){
                if((i+j== brown/2+2) && (i-2)*(j-2)== yellow) 
                    return new int[]{ Math.max(i,j) , Math.min(i,j) };
            }
        }
        
        return null;
    }
}