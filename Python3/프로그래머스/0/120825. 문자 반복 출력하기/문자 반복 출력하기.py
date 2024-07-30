def solution(my_string, n):
    answer = ''
    for c in my_string:
        answer= answer+ c*n
    return answer