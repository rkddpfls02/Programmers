def solution(a, b):
    start= min(a,b)
    end= max(a,b) +1
    return sum(range(start, end))