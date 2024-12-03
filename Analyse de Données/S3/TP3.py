from scipy.optimize import fsolve
from scipy import misc 
import numpy as np
import matplotlib.pyplot as plt
import math

def doudouble(f,a):
    return 2*f(2*a)

"""def f(x):       # f(1) = -1
    return 3*(x**5) - 5*(x**3) + 1"""

def puissance(n):
    return lambda x : x ** n

def operateur(f, n):
    return lambda x : f(x) ** n

#calcul = fsolve(f, [1]) #tangante horizontal -> iter à l'infini 

def dicho(f,a,b,e):
    while (b-a > e):
        m = (a+b)/2

        if (f(m) == 0):
            return m

        elif (f(a) * f(m) < 0):
            b = m
        elif (f(b) * f(m) < 0):
            a = m
    return a

def graphe_dicho(f, a, b, e):
    t = [0.0, 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1.0] # a modifier avec linspace (idem pour t2)
    t2 = [-1.0, -0.9, -0.8, -0.7, -0.6, -0.5, -0.4, -0.3, -0.2, -0.1, 0.0, 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1.0]
    plt.xlim(0, 1)
    plt.ylim(-1, 1)
    plt.plot([x for x in t2], [f(y) for y in t2])
    plt.plot([x for x in t2], [0 for y in t2])
    while b - a > e:
        m = (a+b)/2
        plt.plot([a, a], [-1, 1])
        plt.plot([b, b], [-1, 1])

        if f(m) == 0:
            return m
        elif f(a)*f(m) < 0:
            b = m
        else:
            a = m
    plt.show()
    return a

def f(x):
    return math.cos(x) - x

#print(graphe_dicho(f,0,1,0.1))

#3.4
def nbderive(f,a):
    h = 0.0001    #limite quand h tend vers 0
    return (f(a + h) - f(a - h)) / (2*h)

def derivee(f):
    h = 0.0001
    return lambda x : ((f(x + h) - f(x - h)) / (2*h))

def f_test(x): return x**2
def f_test2(x): return math.cos(x)

#print(nbderive(f_test,2.0), nbderive(f_test2, 1.0))
#print(misc.derivative(f_test, 2.0, dx=1e-6), misc.derivative(f_test2, 1.0, dx=1e-6))

def ddx(f):
    def result(x, y):
        def fonctionPartielX(t):
            return f(t, y)
        return misc.derivative(fonctionPartielX, x, 10**-5) #return dérivation partielle par rapport à x
    return result 

def ddy(f):
    def result(x, y):
        def fonctionPartielY(t):
            return f(x, t)
        return misc.derivative(fonctionPartielY, y, 10**-5) #return dérivation partielle par rapport à y
    return result 

def grad(f):
    def result(x, y):
        return np.array([ddx(f)(x,y), ddy(f)(x,y)])
    return result

def grad2(f):
    return lambda x,y : np.array([ddx(f)(x,y), ddy(f)(x,y)])

