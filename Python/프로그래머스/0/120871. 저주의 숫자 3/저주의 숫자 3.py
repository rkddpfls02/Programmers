def solution(n):
    real=1
    for i in range(1,n):
        real+=1
        while real %3==0 or '3' in str(real):
            real+=1
    return real