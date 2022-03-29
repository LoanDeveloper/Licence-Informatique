from tqdm import tqdm, tqdm_gui
from time import *
import random
import matplotlib.pyplot as plt
from supp_tp1 import levenshteinDistance

def ex1():
    L = [1,2,3,4,5,6,7,8,9,10]

    plt.plot(L)

    for i in tqdm_gui(range(len(L))):
        sleep(1)

#ex2
def diss(a,b):
    return abs(a-b)

def lev(a,b):
    d = levenshteinDistance(a,b)
    return d['distance']

def plusproche(T,req,diss):
    n = len(T)
    i_min = 0
    v_min = diss(T[0],req)
    for i in range(1,n):
        v_i = diss(T[i],req)
        if v_i < v_min:
            i_min = i
            v_min = v_i
    return i_min

#correction prof
def plusproche2(T,req,diss):
    imin , dmin = 0, diss(req, T[0])
    for i, x in enumerate(T):
        if diss(req,x) < dmin:
            imin, dmin = i, diss(req, x)
    return imin

T = []
for i in range(100):
    T.append(random.randint(1,50))

T2=['banane','pomme','poire','abricot']
#print(plusproche2(T2,'ab',lev))