def solution(sides):
    maxside= max(sides)
    sides.remove(maxside)
    return 1 if maxside < sum(sides) else 2