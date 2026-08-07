def solution(s):
    alp= 'abcdefghijklmnopqrstuvwxyz'
    pre= set(s)
    for a in alp:
        if a in s:
            s= s.replace(a, '',1)
    now= set(s)
    # set도 sorted 로 정렬해줌
    answer= sorted(pre-now)
    return ''.join(answer)