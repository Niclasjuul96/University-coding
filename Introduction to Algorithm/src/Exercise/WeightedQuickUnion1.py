import sys
sys.setrecursionlimit(50000)

N = int(input())
M = int(input())




def init(N):
    u = [i for i in range(N)]
    s = [1 for _ in range(N)]
    return u,s


def find(i,u):
    while i != u[i]:
        i = u[i]
    return i

def union(i,j,u,s):
    ri,rj = find(i,u),find(j,u)
    if ri == rj: 
        return 
    if s[ri] < s[rj]:
        u[ri] = rj
        s[rj] += s[ri]
    else:
        u[rj] = ri
        s[ri] += s[rj]

u,s = init(N)

for _ in range(M):
    inp = input().split()
    if inp[0] == "F":
        print(find(int(inp[1]),u))
    else:
        union(int(inp[1]),int(inp[2]),u,s)

    
