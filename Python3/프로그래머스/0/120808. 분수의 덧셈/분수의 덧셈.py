def solution(numer1, denom1, numer2, denom2):
    numer3= (numer1 * denom2)+ (numer2 * denom1)
    denom3= denom1 * denom2
    for i in range(numer3+1 if numer3 < denom3 else denom3+1,1,-1):
        if (numer3%i==0 and denom3%i==0):
            numer3 //= i
            denom3 //= i
    answer = [numer3, denom3]
    return answer