def solution(spell, dic):
    for word in dic:
        test= spell[:]
        for c in word:
            if len(word)!=len(spell):
                continue
            elif c in test:
                test.remove(c)
                if len(test)==0:
                    return 1
    return 2