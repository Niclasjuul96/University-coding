

def parent(i,heap):
    return None if i <= 1 else i // 2

def left_child(i, heap):
    return None if i * 2 >= len(heap) else i * 2

def right_child(i, heap):
    return None if i * 2 + 1 >= len(heap) else i * 2 + 1


def bubble_up(i,heap):
    p =  parent(i,heap)
    if p is None or heap[p] >= heap[i]: 
        return
    temp = heap[p]
    heap[p] = heap[i]
    heap[i] = temp
    bubble_up(p,heap)

def bubble_down(i,heap):
    l,r = left_child(i,heap),right_child(i,heap)
    if l is None and r is None: return
    child = l if r is None or heap[r] < heap[l] else r

    if heap[child] > heap[i]:
        temp = heap[child]
        heap[child] = heap[i]
        heap[i] = temp
        bubble_down(child,heap)

def insert(key,heap):
    heap.append(key)
    bubble_up(len(heap)-1,heap)


def extract_max(heap):
    result = heap[1]
    heap[1] = heap.pop()
    bubble_down(1,heap)
    return result

heap = [0]

for i in range(10):
    insert(i,heap)
    print(heap)

for i in range(5):
    print(extract_max(heap))
    print(heap)
