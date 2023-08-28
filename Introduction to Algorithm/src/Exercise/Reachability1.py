
N,M,a,b = [int(i) for i in input().split()]

N += 1

adjacency_list = [[] for _ in range(N)]

for _ in range(M):
    x,y = [int(i) for i in input().split()]
    adjacency_list[x].append(y)
    adjacency_list[y].append(x)

def dfs(adjancency_list,a,b):
    stack = []
    visited = [False] * N
    stack.append(a)
    visited[a] = True

    while stack:
        current = stack.pop()
        for v in adjacency_list[current]:
            if v == b:
                return True
            if not visited[v]:
                stack.append(v)
                visited[v] = True
    return False


if dfs(adjacency_list,a,b):
    print("YES")
else:
    print("NO")
