def solution(order):
    order= str(order)
    cnt=0
    for num in order:
        if num in ['3','6','9']:
            cnt+=1
    return cnt