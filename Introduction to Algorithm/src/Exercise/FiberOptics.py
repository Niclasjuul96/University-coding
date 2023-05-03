
def init(N):
    u = [i for i in range(N)]
    s = [1 for _ in range(N)]
    return u,s

def find(i,u):
    if u[i] != i: return find(u[i],u)
    return i


def union(i,j,u,s):
    ri = find(i,u)
    rj = find(j,u)

    if s[ri] < s[rj]:
        u[ri] = rj
        s[rj] += s[ri]
    else:
        u[rj] = ri
        s[ri] += s[rj]

def connected(i,j,u):
    return find(i,u) == find(j,u)

N,M = [int(i) for i in input().split()]

u,s = init(N+1)

edges = []

for _ in range(M):
    Bi,Bj,price = [int(i) for i in input().split()]
    edges.append((price,Bi,Bj))

edges.sort()

edges_added = 0
mst_cost = 0
index = 0

while edges_added < N-1:
    price,Bi,Bj = edges[index]
    if not connected(Bi,Bj,u):
        union(Bi,Bj,u,s)
        mst_cost += price
        edges_added += 1
    index += 1

print(mst_cost)





