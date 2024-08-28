class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int numer3= numer1 * denom2 + numer2 * denom1;
        int denom3= denom1 * denom2;
        for(int i=Math.min(numer3, denom3); i >=2 ; i-- ){
            if (numer3 % i ==0 && denom3 % i ==0) {
                numer3 /= i;
                denom3 /= i;
            }
        }
        int[] answer = {numer3, denom3};
        return answer;
    }
}