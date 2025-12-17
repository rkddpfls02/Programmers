from collections import Counter
def solution(s):
    cnt= Counter(list(s.lower()))
    
    return cnt.get('p',0)== cnt.get('y',0)