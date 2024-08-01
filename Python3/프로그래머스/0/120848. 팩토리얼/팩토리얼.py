def solution(n):
    i, fac= 1,1
    while fac <= n:
        i+= 1
        fac*= i
    return i-1