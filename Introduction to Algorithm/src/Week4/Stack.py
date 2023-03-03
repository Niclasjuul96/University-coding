class node:
    def __init__(self,key):
        self.key = key
        self.next = None

class LinkedList:
    def __init__(self):
        self.head = None

def push(LinkedList, key):
    new_node = node(key)
    new_node.next = LinkedList.head
    LinkedList.head = new_node

def pop(linkedlist):
    pop_element = linkedlist.head.key
    linkedlist.head = linkedlist.head.next
    return pop_element

N = int(input())
my_stack = LinkedList()

for i in range(N):
    inp = input().split()
    if inp[0] == 'PU':
        push(my_stack)
    if inp[0] == 'Pop':
        print(pop(my_stack))