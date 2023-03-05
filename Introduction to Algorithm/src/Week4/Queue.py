class node:
    def __init__(self,key):
        self.key = key
        self.next = None

class LinkedList:
    def __init__(self):
        self.head = None
        self.tail = None

def enqueue(LinkedList, key):
    new_node = node(key)
    if(LinkedList.head is None):
        LinkedList.head = new_node
    else:
        LinkedList.head.next = new_node

    LinkedList.tail.next = new_node
def dequeue(LinkedList):
    d_element = LinkedList.head
    LinkedList.head = LinkedList.head.next
    return d_element

N = int(input())
my_queue = LinkedList()

for i in range(N):
    inp = input().split()
    if inp[0] == 'E':
        enqueue(my_queue, int(input()))
    
    