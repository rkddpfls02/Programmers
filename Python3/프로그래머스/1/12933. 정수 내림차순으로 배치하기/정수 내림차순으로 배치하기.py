def solution(n):
    arr= [i for i in str(n)]
    arr.sort(reverse= True)
    answer= ''.join(arr)
    return int(answer)
