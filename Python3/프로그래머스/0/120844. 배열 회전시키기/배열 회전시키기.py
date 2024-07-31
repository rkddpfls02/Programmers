# index로 요소 삭제 del arr[index]
def solution(numbers, direction):
    last= numbers[len(numbers)-1]
    start= numbers[0]
    if direction == "right":
        del numbers[len(numbers)-1]
        numbers= [last]+numbers
    else:
        del numbers[0]
        numbers= numbers+[start]
    return numbers