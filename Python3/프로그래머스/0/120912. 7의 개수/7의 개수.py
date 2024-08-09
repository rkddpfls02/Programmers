def solution(array):
    cnt=0
    for n in array:
        while n%10 !=0:
            if n%10 == 7:
                cnt+=1
            n //=10
    return cnt