def solution(sizes):
    arr=[]
    for a,b in sizes:
        arr.append([a,b] if a>b else [b,a])
    
    return max([a for a,_ in arr]) * max([b for _,b in arr])