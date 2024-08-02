def solution(array, n):
    array.sort()
    dif= [abs(n-num) for num in array]
    return array[dif.index(min(dif))]