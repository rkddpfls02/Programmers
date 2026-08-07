def solution(keyinput, board):
    xlim= board[0]//2
    ylim= board[1]//2
    x,y=0,0
    for key in keyinput:
        if key == 'up':
            if y< ylim:
                y +=1 
        elif key == 'down':
            if y> -ylim:
                y -=1 
        elif key == 'left':
            if x> -xlim:
                x -=1 
        else:
            if x< xlim:
                x +=1 
    return [x, y]