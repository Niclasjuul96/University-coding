from matplotlib import pyplot as plt
import numpy as np

def f(x,y):
    return 2*x**2 - 2*x*y + 2*y**2 + 2*x - 4*y - 4

x = np.linspace(-5,5,500)
y = np.linspace(-5,5,500)
X, Y = np.meshgrid(x,y)
Z = f(X,Y)

fig, ax = plt.subplots()
ax.contour(X,Y,Z,levels=[8,16,24,32,40,48,56],colors='black')
ax.add_patch(plt.Circle((1,0),
