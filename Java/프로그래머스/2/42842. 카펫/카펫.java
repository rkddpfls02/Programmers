class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int [2];
        for(int w= 3; w<= (brown-2)/2; w++){ // 가로
            for(int h= 3; h<= w; h++) { // 세로
                int tmp= 2*(w+h)-4;
                if( tmp == brown && brown+yellow == w*h) {
                    answer[0]= w;
                    answer[1]= h;
                    return answer;
                }
            }
        }
        
        return answer;
    }
}