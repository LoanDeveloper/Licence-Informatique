from tkinter import *


T = [3, 5, 1, 0, 5, 3, 8, 8, 0, 3, 5, 2]

def tri1(T):
    Cpt = [0 for x in range(10)]
    
    for v in range(len(Cpt)):
        for n in T:
            if v == n:
                Cpt[v]+=1

    T=[]
    for v in range(len(Cpt)):
        for i in range(Cpt[v]):
            T.append(v)
    return T

def tri2(T):
    v_min = min(T)
    v_max = max(T)
    Cpt = [0 for x in range(len(T))]
    
    for v in range(len(Cpt)):
        for n in T:
            if v == n:
                Cpt[v]+=1

    T=[]
    for v in range(len(Cpt)):
        for i in range(Cpt[v]):
            T.append(v)
    return T

print(tri1([3, 5, 1, 0, 5, 3, 8, 8, 0, 3, 5, 2]))
