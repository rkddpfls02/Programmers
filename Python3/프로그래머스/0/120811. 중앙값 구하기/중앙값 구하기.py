def solution(array):
    array.sort()
    answer = array[int((0+len(array))/2)]
    return answer