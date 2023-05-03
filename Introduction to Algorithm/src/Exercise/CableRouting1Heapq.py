import heapq

pq = [(0,1)]


N,M = [int(i) for i in input().split()]

ad = [[] for _ in range(N+1)]
visited = [False for _ in range(N+1)]
price = [float("inf") for _ in range(N+1)]
visited_count = 0

for _ in range(M):
    u,v,w = [int(i) for i in input().split()]
    ad[u].append((v,w))
    ad[v].append((u,w))

while pq:
    cost,current = heapq.heappop(pq)
    while visited[current] and pq:
        cost,current = heapq.heappop(pq)
    visited[current] = True
    visited_count += 1
    price[current] = cost
    if visited_count >= N: break

    for neighbour,weigth in ad[current]:
        if not visited[neighbour] and cost + weigth < price[neighbour]:
            heapq.heappush(pq,(cost+weigth,neighbour))

for i in price[1:]:
    print(i,end=" ")
print()