#from GraphDrawing import *
from collections import deque

N,M = [int(i) for i in input().split()]

N = N + 1



a_list = [[] for _ in range(N)]
indegree = [0 for _ in range(N)]
q = deque()
sorting = [0 for _ in range(N)]
distance = [1 for _ in range(N)]
max_distance = 1


for _ in range(M):
    X,Y = [int(i) for i in input().split()]
    a_list[Y].append(X)
    indegree[X] += 1

for i in range(N):
    if indegree[i] == 0:
        q.append(i)
    
sorting_index = 0  
while q:
    current = q.popleft()
    sorting[sorting_index] = current
    sorting_index += 1

    for edge in a_list[current]:
        indegree[edge] -= 1
        if indegree[edge] == 0:
            q.append(edge)

for index in sorting:
    for edge in a_list[index]:
        distance[edge] = max(distance[index] + 1, distance[edge])
        max_distance = max(distance[edge],max_distance)

print(max_distance)



