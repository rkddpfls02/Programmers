def solution(numbers):
    if len(numbers)==2:
        return numbers[0] * numbers[1]
    
    plus= [n for n in numbers if n>=0]
    minus= [n for n in numbers if n<0]
    
    plus.sort(reverse= True)
    minus.sort()
    
    if len(plus)>1 and len(minus)>1:
        return max(plus[0]*plus[1], minus[0]*minus[1])
    
    return plus[0]*plus[1] if len(plus)>1 else minus[0]*minus[1]
    