def solution(a, b):
    start= min(a,b)
    end= max(a,b) +1
    return sum(i for i in range(start, end))