N,M = [int(i) for i in input().split()]


def init(N):
    u = [i for i in range(N)]
    s = [1 for _ in range(N)]
    return u,s


def find(i,u):
    start = i
    while i != u[i]:
        i = u[i]
    while start != u[i]:
        tmp = u[start]
        u[start] = i
        start = tmp
    return i


    '''
    if i != u[i]:
        u[i] = find(u[i],u)
    return u[i]
    '''

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
    if inp[0] == "A":
        union(int(inp[1]),int(inp[2]),u,s)
    else:
        if find(int(inp[1]),u) == find(int(inp[2]),u):
            print("YES")
        else:
            print("NO")
