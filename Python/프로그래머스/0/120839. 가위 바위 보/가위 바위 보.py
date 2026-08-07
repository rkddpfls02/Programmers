def solution(rsp):
    game = {
        "2":"0",
        "0":"5",
        "5":"2"
    }
    return ''.join(game[c] for c in rsp)