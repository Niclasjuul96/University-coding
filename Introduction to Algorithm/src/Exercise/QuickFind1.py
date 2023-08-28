N = int(input())
M = int(input())


def init(N):
    return [i for i in range(N)]

def find(i,u):
    return u[i]

def union(i,j,u):
    ri,rj = find(i,u),find(j,u)

    for i in range(len(u)):
        if u[i] == ri:
            u[i] = rj

u = init(N)

for _ in range(M):
    inp = input().split()
    if inp[0] == "F":
        print(find(int(inp[1]),u))
    else:
        union(int(inp[1]),int(inp[2]),u)

    
