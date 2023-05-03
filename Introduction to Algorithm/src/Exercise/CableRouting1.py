import random

class Heap:
    def __init__(self) -> None:
        self.heap = [0]

    def parent(self,i):
        return None if i < 2 else i // 2

    def left_child(self,i):
        return None if i * 2 >= len(self.heap) else i * 2

    def right_child(self,i):
        return None if i * 2 + 1 >= len(self.heap) else i * 2 + 1

    def swap(self,i,j):
        tmp = self.heap[i]
        self.heap[i] = self.heap[j]
        self.heap[j] = tmp

    def bubble_up(self,i):
        while True:
            parent = self.parent(i)
            if parent is None: return 
            if self.heap[parent] > self.heap[i]:
                self.swap(parent,i)
                i = parent
            else:
                return

    
    def bubble_down(self,i):
        while True:
            lc,rc = self.left_child(i),self.right_child(i)
            if lc is None and rc is None: return
            child = lc if rc is None or self.heap[lc] < self.heap[rc] else rc
            if self.heap[child] < self.heap[i]:
                self.swap(child,i)
                i = child 
            else:
                return

    def insert(self,val):
        self.heap.append(val)
        self.bubble_up(len(self.heap)-1)

    def extract_min(self):
        result = self.heap[1]
        tmp = self.heap.pop()
        if len(self.heap) < 2: return result
        self.heap[1] = tmp
        self.bubble_down(1)
        return result

    def is_empty(self):
        return len(self.heap) <= 1


pq = Heap()

N,M = [int(i) for i in input().split()]

ad = [[] for _ in range(N+1)]
visited = [False for _ in range(N+1)]
price = [float("inf") for _ in range(N+1)]

for _ in range(M):
    u,v,w = [int(i) for i in input().split()]
    ad[u].append((v,w))
    ad[v].append((u,w))

pq.insert((0,1))
visited_count = 0

while not pq.is_empty() or visited_count < N:
    cost,current = pq.extract_min()
    while visited[current] and not pq.is_empty():
        cost,current = pq.extract_min()
    visited[current] = True
    visited_count += 1
    price[current] = min(cost,price[current])
    for neighbour,weight in ad[current]:
        if not visited[neighbour] and cost + weight < price[neighbour]:
            pq.insert((cost+weight,neighbour))


for i in price[1:]:
    print(i,end=" ")
print()