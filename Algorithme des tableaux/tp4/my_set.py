import bisect

E = [1, 2, 3]
L = [3,4,8,9,0,0]


def set_len(E):
    cpt=0
    for c in E:
        cpt += 1
    return cpt

def set_in(E,x):
    for i in E:
        if i == x:
            return True
    return False

def set_in2(E,x): #correction avec bisect
    index_x = bisect_left(E,x)
    if index_x < len(E) and E[index_x] == x:
        return True
    return False

def set_not_in(E,x):
    for i in E:
        if i == x:
            return False
    return True

def set_add(E,x):
    if set_not_in(E,x) == True:
        E.append(x)

def set_add2(E,x):
    index_x = bisect_left(E,x)
    if index_x == len(E) or E[index_x] != x:
        E.insert(index_x, x)
    return E

def set_rm(E,x):
    if set_in(E,x) == True:
        i = 0
        for a in E:
            if a == x:
                del(E[i])
            i+=1

def set_rm2(E,x):
    index_x = bisect_left(E, x)
    if index_x < len(E) and E[index_x] == x:
        del E[index_x]
    return E

def set_create(L):
    E = []
    T = sorted(L)
    for a in T:
        set_add(E,a)
    return E
print(set_create(L))

def set_union(E1,E2):
    U = []
    i_1,i_2 = 0,0
    while i_1 < len(E1) and i_2 < len(E2):
        if E1[i_1] == E2[i_2]:
            U.append(E1[i_1])
            i_1 += 1
            i_2 += 1
        elif E1[i_1] < E2[i_2]:
            U.append(E1[i_1])
            i_1+= 1
        else:       # E2[i_2] < E1[i_1]
            U.append(E2[i_2])
        while i_1 < len(E1): # ou U.extend(E1[i_1:]) pour terminer E1
            U.append(E1[i_1])
            i_1 += 1
        while i_2 < len(E2): # ou U.extend(E2[i_2:]) pour terminer E2
            U.append(E2[i_2])
            i_2 += 1
        return U

def set_union2(E1,E2):
    U = []
    for e in E1:
        set_add(U,e)
    for e in E2:
        set_add(U,e)
    return U

def set_diff(E1,E2):
    D = []
    i_1, i_2 = 0, 0
    while i_1<

def set_diff2(E1,E2): # n1 * log (n2)
    D = []
    for e1 in E1:
        if set_not_in(E2,e1):
            D.append(e1)
    return D

def set_isdisjoint(E1,E2):
    return len(set_inter(E1, E2)) == 0

def set_issub(E1,E2):
    return True #à faire