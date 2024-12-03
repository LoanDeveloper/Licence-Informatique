W = 30
n = [[7,13],[4,12],[3,10]]

def backpack(n,W):
    result = []
    while len(n)!=0 and W>0:
        r_max = 0
        i_max = 0
        for i in range(len(n)):
            r = n[i][0]/n[i][1]
            if (r > r_max):
                r_max = r
                i_max = i
        if (n[i_max][1]<=W):
            result.append(n[i_max])
            W -= n[i_max][1]
        n.remove(n[i_max])
    return result

print(backpack(n,W))