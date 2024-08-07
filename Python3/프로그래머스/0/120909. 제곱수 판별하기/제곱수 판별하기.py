# is_integer() 10.0 은 True 10.5는 False
def solution(n):
    return 1 if (n**0.5).is_integer() else 2