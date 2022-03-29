T = [2,1,7,5,6]
L2 = ['m','e','t']

def tri_selection(T):
    for i in range(len(T)-1):
        i_min = i
        for j in range(i+1,len(T)):
            if T[j] < T[i_min]: i_min = j
        T[i],T[i_min] = T[i_min],T[i]
    return T

def tri_insertion(T):
    n = len(T)
    for i in range(1,n):
        cle = T[i]
        j = i-1
        while j>=0 and cle < T[j]:
            T[j+1] = T[j]
            j = j - 1 
        T[j+1] = cle
    return T

def tri1(T):
    for i in range(len(T)-1):
        i_min = 0
        for j in range(i+1,len(T)):
            print(i,j)

print(tri1(T))
