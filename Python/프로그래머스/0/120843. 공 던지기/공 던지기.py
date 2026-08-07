def solution(numbers, k):
    ans= (2*k-1)% len(numbers)
    return  len(numbers) if ans==0 else ans