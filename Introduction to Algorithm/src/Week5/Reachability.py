N, M, a, b = map(int, input().split())

N+=1

adj = [[] for _ in range(N)]

for _ in range(M):
    x,y = map(int, input().split())
    adj[x].append(y)
    adj[y].append(x)

from collections import deque
def bfs(adj, s, t):
    q = deque()

    visited = [False for _ in range(N)]

    visited[s] = True
    q.append(s)

    while(q):
        current = q.popleft()

        for neighbor in adj[current]:
            if(visited[neighbor]):
                continue
            if(neighbor == t):
                return True
            visited[neighbor] = True
            q.append(neighbor)
        return False

if(bfs(adj, a, b)):
    print("YES")
else:
    print("NO")


