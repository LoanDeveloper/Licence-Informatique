from tp1 import plusproche2,lev
from random import *

#ex1:

dico = []
with open('dico.txt', 'r') as f:
    for ligne in f:
        dico.append(ligne.rstrip('\n'))

"""
while True:
    mot = input("Mot ?")
    indice = plusproche2(dico,mot,lev)
    print(indice,dico[indice])
"""
C = dico

dico50 = []
for i in range(50):
    idx=randint(0,len(C)-1)
    dico50.append(C[idx])

#ex2

T = [1, 2, 5, 3, 8]
def DichoRec(T,x,g=0,d=len(T)-1):
    if g<=d:
        m = (g+d)//2
        if T[m]==x:
            return m
        elif T[m]>x:
            return DichoRec(T,x,g,m-1)
        elif T[m]<x:
            return DichoRec(T,x,m+1,d)
    else:
        return None

#print(DichoRec(dico,'abasourdis',0,len(dico)-1))
print(DichoRec(T,3))

def longss1(C,x):
    for i in range(len(C)-1):
        cpt=0
        if C[i]==C[i+1] and C[i]==x:
            cpt=+1
        else:
            return 1
        return cpt
#print(longss1('aabbccc','a'))