import numpy as np
import matplotlib.pyplot as plt
import scipy.stats
import math

#2.1
def PF(n):
    return np.random.randint(2, size=n)

#print(PF(5))

#2.2
def DeDe(n):
    return np.random.randint(1, high=7, size=n)
#print(DeDe(10))

#3.1
def compte(t,f):
    cpt = 0
    for i in t:
        if i==f:
            cpt+=1
    return cpt
#print(compte(DeDe(50),6))


def graph(n):
    abcisse = [i for i in range(n)]
    ordonne = []
    for i in range(n):
        experience = DeDe(100)
        frequence = compte(experience,6)/100
        ordonne.append(frequence)
    plt.axis([0,50,0,1])
    plt.plot(abcisse,ordonne, "ob", color="r")
    plt.show()
        
#graph(50)

#3.2
def dixsept_tirages(n):
    cpt = 0
    for i in range(n):
        if (compte(DeDe(17),1) == 0):
            cpt+=1
    return cpt


#3.3
def moyenne(n):
    return (dixsept_tirages(n)/n)


def graph2():
    echantillon = []
    for i in range(100):
        m = moyenne(300)
        echantillon.append(m)

    ecart_type = scipy.stats.tstd(echantillon)
    moyenne_echantillon = sum(echantillon)/len(echantillon)
    
    
    plt.hist(echantillon, 5, color='b', alpha=0.5)
    plt.title('Histogramme de basé sur l\'échantillon')
    
    densite_proba_norm = scipy.stats.norm.pdf([x for x in range(len(echantillon))],loc = moyenne_echantillon,scale = ecart_type)
    plt.plot([x for x in range(len(echantillon))],densite_proba_norm)
    
    plt.show()

graph2()

def loibinomiale(n, p):
    result = []
    for k in range(n+1):
        cb = math.factorial(n)/(math.factorial(k) * math.factorial(n-k))
        h = cb * math.pow(p, k) * math.pow(1-p, n-k)
        result.append(h)
    return result