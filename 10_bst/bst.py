import random


class Node:
    def __init__(self, value):
        self.L = None
        self.R = None
        self.key = -1
        self.value = value

    def add_value(self, value):
        if value == self.value:
            return
        if value < self.value:
            if self.L is None:
                self.L = Node(value)
            else:
                self.L.add_value(value)
        if value > self.value:
            if self.R is None:
                self.R = Node(value)
            else:
                self.R.add_value(value)

    @staticmethod
    def deleteNode(root, value):

        if root is None:
            return root

        if value < root.value:
            root.L = Node.deleteNode(root.L, value)
        elif (value > root.value):
            root.R = Node.deleteNode(root.R, value)

        else:
            if root.L is None:
                temp = root.R
                root = None
                return temp

            elif root.R is None:
                temp = root.L
                root = None
                return temp

            minValueNode = root.R.L

            while minValueNode.L is not None:
                minValueNode = minValueNode.L

            root.value = minValueNode.value

            root.R = Node.deleteNode(root.R, minValueNode.value)
        return root

    def get_larger(self):
        return self.R

    def get_smaller(self):
        return self.L


class BST:
    def __init__(self, root):
        self.root = Node(root)
        self.finded_node = None
        self.seek_value = None

    def insert(self, value):
        self.root.add_value(value)

    def remove(self, value):
        Node.deleteNode(self.root, value)

    def find(self, value):
        self.seek_value = value
        self.finded_node = None
        self.walk(self.root)
        return self.finded_node

    def print(self):
        self.walk(self.root)

    def walk(self, node):
        if node is None:
            return
        self.walk(node.L)
        self.use(node)
        if node.value == self.seek_value:
            self.finded_node = node
        self.walk(node.R)

    def use(self, node):
        pass
        # print(node.value)

#
# bst = BST(40)
# bst.insert(40)
# bst.insert(20)
# bst.insert(10)
# bst.insert(30)
# bst.insert(5)
# bst.insert(15)
# bst.insert(28)
# bst.insert(22)
# bst.insert(26)
# bst.remove(20)
# bst.remove(26)
# print(bst.find(10))

def random_tree(N):
    tree = BST(N//2)
    for x in range(N):
        tree.insert(random.randint(0, N))
    return tree

def sorted_tree(N):
    tree = BST(N//2)
    for x in range(N):
        tree.insert(x)
    return tree

def find_in_tree(tree, N):
    for x in range(N//10):
        tree.find(x)

def remove_from_tree(tree, N):
    for x in range(N//10):
        tree.remove(x)

N = 1000
r_tree = random_tree(N)
s_tree = sorted_tree(N)

find_in_tree(r_tree, N)
remove_from_tree(r_tree, N)

find_in_tree(s_tree, N)
remove_from_tree(s_tree, N)