class Node:

    def __init__(self):
        self.left = None
        self.right = None
        self.data=None

    def insert(self, data):
        if self.data:
            if data < self.data:
                if self.left is None:
                    self.left = Node()
                    self.left.setRoot(data)
                    print("left child <__main__.BinaryTree object at {}>".
                          format(hex(id(self.left))))
                else:
                    self.left.insert(data)
                    print("left tree <__main__.BinaryTree object at {}>".
                          format(hex(id(self.left))))
            elif data > self.data:
                if self.right is None:
                    self.right=Node()
                    self.right.setRoot(data)
                    print("right child <__main__.BinaryTree object at {}>".
                          format(hex(id(self.right))))
                else:
                    self.right.insert(data)
                    print("right tree <__main__.BinaryTree object at {}>".
                          format(hex(id(self.right))))
        else:
            self.data = data

    def inorderTraversal(self, root):
        res = []
        if root:
            res = self.inorderTraversal(root.left)
            res.append(root.data)
            res = res + self.inorderTraversal(root.right)
        return res
    
    def preorderTraversal(self, root):
        res = []
        if root:
            res.append(root.data)
            res = res + self.preorderTraversal(root.left)
            res = res + self.preorderTraversal(root.right)
        return res
    
    def postorderTraversal(self, root):
        res = []
        if root:
            res = self.postorderTraversal(root.left)
            res = res + self.postorderTraversal(root.right)
            res.append(root.data)
        return res

    def getRightChild(self):
        return self.right

    def getLeftChild(self):
        return self.left

    def setRoot(self,data):
        self.data=data

    def getRoot(self):
        return self.data

print("The binary tree will be created with your numbers.")
print("Please enter 10 numbers to create sorted binary tree")
val=int(input("Enter a number:"))
root=Node()
root.setRoot(val)
print("root: None")
for i in range (8):
    root.insert(int(input("Enter a number:")))
    print("root: {}".format(val))
print("...***...")
print("Pre-Order")
print(root.preorderTraversal(root))
print("...***...")
print("Post-Order")
print(root.postorderTraversal(root))
print("In-Order")
print(root.inorderTraversal(root))
print("...***...")
