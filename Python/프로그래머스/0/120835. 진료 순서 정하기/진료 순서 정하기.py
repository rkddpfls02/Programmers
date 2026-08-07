# sort함수의 reverse= True 내림차순 정렬
def solution(emergency):
    answer = []
    temp= emergency[:]
    temp.sort(reverse= True)
    for n in emergency:
        answer.append(temp.index(n)+1)
    return answer