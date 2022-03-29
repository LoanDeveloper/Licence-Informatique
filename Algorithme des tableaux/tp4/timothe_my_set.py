def set_len(E):
    return len(E)

def set_in(E,x):
    c=0
    for a in E:
        if(x==a):
            c+=1
    return(c!=0)

def set_not_in(E,x):
    c=0
    for a in E:
        if (a!=x):
            c+=1
    return(c==0)

def set_add(E,x):
    if (set_in(E,x)!=True):
        E.append(x)
    return E

def set_rm(E,x):
    c=0
    for a in E:
        if (a==x):
            E.pop(c)
        c+=1

def set_create(L):
    E=[]
    for a in L:
        set_add(E,a)
    E.sort()
    L=E
    return L

def set_union(E1,E2):
    E=[]
    for e1 in E1:
        set_add(E,e1)
    for e2 in E2:
        set_add(E,e2)
    return E

def set_inter(E1,E2):
    E=[]
    for a in E1:
        if (set_in(E2,a)==True):
            E.append(a)
    return E

def set_diff(E1,E2):
    E4=set_inter(E1,E2)
    E=set_union(E1,E2)
    c=0
    for i in E:
        if (set_in(E4,i) == True):
            E.pop(c)
        c+=1
    return E

def set_isdisjoint(E1,E2):
    return(set_inter(E1,E2)==[])

def set_issub(E1,E2):
    return(E1==set_union(E1,E2))

def set_issup(E1,E2):
    return(E2==set_union(E1,E2))

def set_xor(E1,E2):
    E=[]
    E3=set_diff(E1,E2)
    E4=set_diff(E2,E1)
    E=set_union(E3,E4)
    return E