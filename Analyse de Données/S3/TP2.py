from random import *
from scipy import stats

def nbSimu(n):
    Bb_Un, Bn_Un, Bn_Ub, Bb_Ub = 0,0,0,0
    ub,un = 0,0
    for _ in range(n): 
        urne = randint(0,1)
        if urne == 0:
            boule = randint(1,10)
            if boule<=2:
                print("boule blanche, urne noire")
                Bb_Un+=1
            else:
                print("boule noire, urne noire")
                Bn_Un+=1
            un+=1
        else:
            boule = randint(1,10)
            if boule<=2:
                print("boule noire, urne blanche")
                Bn_Ub+=1
            else:
                print("boule blanche, urne blanche")
                Bb_Ub+=1
            ub+=1
    return("P(Bb|Un) : "+ str((Bb_Un/n)/(un/n)) + ", P(Bn|Un) : " + str((Bn_Un/n)/(un/n)) + ", P(Bn|Ub) : " + str((Bn_Ub/n)/(ub/n)) + ", P(Bb|Ub) : " + str((Bb_Ub/n)/(ub/n)) + ", P(Bn|Un) : " + str((un/n)*(Bn_Un/n)) + ", P(Un) : " + str((Bb_Un + Bn_Un)/n) + ", P(Ub) : " + str((Bn_Ub + Bb_Ub)/n) + ", P(Bb) : " + str((Bb_Ub + Bb_Un)/n) + ", P(Bn) : " + str((Bn_Ub + Bn_Un)/n))

#print(nbSimu(1000))

def urnes2(BbInUb):
    result = ""
    nb, Ub = 10, BbInUb
    Un = nb - Ub
    if (choice(["Ub","Un"]) == "Ub"):
        if (randint(0,10) <= Ub):
            result += "Boule blanche"
            result += " urne blanche"
        else :
            result += "Boule noire"
            result += " urne blanche"
    else :
        if (randint(0,10) <= Un):
            result += "Boule noire"
            result += " urne noire"
        else :
            result += "Boule blanche"
            result += " urne noire"
    return result

def jeuUrnes2(nb1,nb2 = 5):
    cptRa, ratioWin, cpt = 0, 0, 0
    for i in range (nb1):
        change = choice(["y","n"])

        if (change == "y"):
            BbInUb=2
        else:
            BbInUb=8
        for i in range(nb2):
            print(urnes2(BbInUb))

        x = str(input("échange ? y/n "))

        if(x == change):
            cptRa += 1
            cpt += 1
            ratioWin = (cptRa/cpt) * 100

            print('Bravo !\n')
            print('Nbre de jeu : '+ str(cpt))
            print('Pourcentage de victoire : '+ str(ratioWin) + "%")
        else :
            cpt += 1
            ratioWin = (cptRa/cpt) * 100

            print('Dommage !\n')
            print('Nbre de jeu : '+ str(cpt))
            print('Pourcentage de victoire : '+ str(ratioWin) + "%")
    return "Partie terminée !"

#print(jeuUrnes2(5))

t = [4,2,8,9,5,13,1]
def triBulle(t): 
    n = len(t)
    for i in range(n-1): 
        for j in range(0, n-i-1): 
             if t[j] > t[j+1] : 
                t[j], t[j+1] = t[j+1], t[j] 
    return t

#print(triBulle(t))

print(f"P(N > 1) : {stats.norm.sf(1)}")
print(f"P(N > 2) : {stats.norm.sf(2)}")
print(f"P(N < -2) : {stats.norm.cdf(-2)}")
print(f"P(N < -1) : {stats.norm.cdf(-1)}")
print(f"P(|N| < 1) : {stats.norm.cdf(1) - stats.norm.cdf(-1)}")
print(f"P(|N| < 2) : {stats.norm.cdf(2) - stats.norm.cdf(-2)}")
print(f"P(|N| < x) = 0.90 : {stats.norm.ppf(0.90)}")
print(f"P(|N| < x) = 0.95 : {stats.norm.ppf(0.95)}")
print(f"P(|N| < x) = 0.99 : {stats.norm.ppf(0.99)}")

""" arrondi à 10^-2 près
>1 : 0.16
>2 : 0.02
<-2 : 0.02
<-1 : 0.16
<1 : 0.68
<2 : 0.95
0.90 : 1.28
0.95 : 1.64
0.99 : 2.33
"""

"""
espérence stratégie 1 : 1/2 * 1 - 1/2 * 1 = 0
espérence stratégie 2 : 1/2 * 1 - 1/2 * 1 = 0
"""