class Node:
    def __init__(self,key):
        self.next = None
        self.key = key

class LinkedList:
    def __init__(self) -> None:
        self.head = None
        self.tail = None


def is_empty(linked_list):
    return linked_list.head is None

def enqueue(linked_list,key):
    new_node = Node(key)
    if is_empty(linked_list): ## could be replaced with: if linked_list.head is None
        linked_list.head = new_node
        linked_list.tail = new_node
        return
    linked_list.tail.next = new_node
    linked_list.tail = new_node

def deque(linked_list):
    result = linked_list.head.key
    linked_list.head = linked_list.head.next
    if is_empty(linked_list): ## could be replaced with: if linked_list.head is None
        linked_list.tail = None
    return result

def print_list(linked_list):
    current_node = linked_list.head
    while current_node is not None:
        print(current_node.key,end=" ")
        current_node = current_node.next
    print()

queue = LinkedList()


N = int(input())

for _ in range(N):
    read_input = input().split()
    if read_input[0] == "E":
        enqueue(queue,int(read_input[1]))
    else:
        print(deque(queue))



        

    

    

