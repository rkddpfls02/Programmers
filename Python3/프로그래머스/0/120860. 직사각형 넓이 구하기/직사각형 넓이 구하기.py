def solution(dots):
    x1= dots[0][0]
    y1= dots[0][1]
    for dot in dots:
        if x1== dot[0]:
            height= abs(dot[1]- y1)
        else:
            base= abs(dot[0]-x1)
    
    return height*base