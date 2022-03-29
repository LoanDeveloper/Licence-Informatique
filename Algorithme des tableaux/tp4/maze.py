import random
import itertools as it
from turtle import *
from my_set import *

"""
Algorithm:
Create a list of all walls
Create a set for each cell, each containing just that one cell.
For each wall, in some random order:
If the cells divided by this wall belong to distinct sets:
Remove the current wall.
Join the sets of the formerly divided cells.
Test end of generation.
"""

def draw_walls(walls, N, scale):
    def draw_wall_0(i, j):
        penup()
        setpos(int(scale * (i + 0.5)), int(scale * (j + 0.5)))
        setheading(270)
        pendown()
        forward(scale)

    def draw_wall_1(i, j):
        penup()
        setpos(int(scale * (i - 0.5)), int(scale * (j + 0.5)))
        setheading(0)
        pendown()
        forward(scale)

    speed("fastest")
    penup()
    setpos(int(scale * (0 - 0.5)), int(scale * (0 - 0.5)))
    setheading(0)
    pendown()
    forward(scale * N)
    left(90)
    forward(scale * N)
    left(90)
    forward(scale * N)
    left(90)
    forward(scale * N)

    for wall in walls:
        i, j, o = wall
        if o == 0:
            draw_wall_0(i, j)
        elif o == 1:
            draw_wall_1(i, j)

def find_set(cells, ij):
    for idx, cell in enumerate(cells):
        if set_in(cell, ij):
            return idx
        return None

if __name__ == "__main__":
    N = 50
    walls = [(i, j, o) for i, j, o in it.product(range(N), range(N), [0, 1])]
    cells = [[(i, j)] for i, j in it.product(range(N), range(N))]
    start = (0, 0)
    end = (N - 1, N - 1)
    while walls:
        i_wall = random.randint(0, len(walls) - 1)
        i, j, o = walls[i_wall]
        i_set1 = find_set(cells, (i, j))
    if o == 0 and i < N - 1:  # mur à l'est ?
        i_set2 = find_set(cells, (i + 1, j))
    elif o == 1 and j < N - 1:  # mur au nord ?
        i_set2 = find_set(cells, (i, j + 1))
    else:
        continue
    if i_set1 != i_set2:  # pourquoi 0 ?
        # A faire:
        # Réunir set1 et set2
        union = set_union(cells[i_set1],cells[i_set2])
        cells[i_set1] = union
        # MAJ cells
        del cells[i_set2]
        # MAJ walls
        del walls[i_wall]
        # Faire ici terminer le while si nécessaire
        if set_in(union, start) and set_in(union, end):
            break
    print(walls)
    draw_walls(walls, N, scale=5)
