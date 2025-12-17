def solution(arr):
    minIndex= arr.index(min(arr))
    arr.pop(minIndex)
    return [-1] if len(arr)==0 else arr