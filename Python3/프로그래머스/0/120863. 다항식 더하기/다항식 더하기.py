def solution(polynomial):
    temp= polynomial.split(' ')
    nsum, xsum= 0,0
    for s in temp:
        if s =='+':
            continue
        elif s.isdigit():
            nsum += int(s)
        elif s == 'x':
            xsum +=1
        else:
            xsum += int(s[:len(s)-1])
    
    if nsum !=0 and xsum !=0:
        return ('x'if xsum==1 else str(xsum)+'x')+' + '+str(nsum)
    elif xsum !=0:
        return 'x'if xsum==1 else str(xsum)+'x'
    else :
        return(str(nsum))

