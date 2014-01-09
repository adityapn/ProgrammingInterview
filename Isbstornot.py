class BinaryTree:    
    # Structure of the binart tree node
    class Node:
        # visited is used to avoid loop with in a tree 
        left , right , value , visited = None , None , None , False
        def __init__(self,data):
            self.value = data
    # root node the binary tree
    root = None
    # Counter to keep track of no.of.elements that are added
    counter = 0

    # Add function for adding value in to the tree
    def add(self,data):
        that = self
        def add_into(node,data):            
            if node is None:
                node = self.Node(data)
                node.left = None
                node.right = None
            # If the counter is even add it to the left sub tree
            elif that.counter%2 == 0:
               that.counter += 1
               node.left = add_into(node.left,data)
            else:
                # Else add it to right sub tree
                that.counter += 1
                node.right = add_into(node.right,data)
            return node
        self.root = add_into(self.root,data)

    # Do an inorder traversal in recurssive way
    def inorder(self):
         def inorder_trav(node):
             if node is not None:
                 inorder_trav(node.left)
                 print(node.value)
                 inorder_trav(node.right)
         inorder_trav(self.root)

    # function to check if the given tree is binary tree or not
    def isBstorNot(self):
        result = True
        def isbst(node):
            # base condition , check if the node is none or not
            if node is not None:
                # Check if the node has left tree or not and also this node is already visited
                if node.left is not None:
                    if node.visited is False:                    
                        if node.left.value > node.value:
                            return False
                        else:
                            # Repeat the process recurssively with left sub tree
                            result = isbst(node.left)                                                        
                    else:
                        # If the node is already visited , mean it has loop
                        return False
                else:
                    # If you reach the last node then return true
                    return True
                # Check if the right sub tree is none or not
                if node.right is not None:
                    if not node.visited:
                        if node.right.value < node.value:
                            return False
                        else:
                            # do recursively with right sub tree
                            result = isbst(node.right)
                    else:
                        # There is loop , so say it false
                        return False
                else:
                    return True
                
                # Mark visted node as visited
                node.visited = True
                

            return result
        
        print isbst(self.root)

tree = BinaryTree()
items = [4,2,5]
for item in items:
    tree.add(item)
tree.inorder()
tree.isBstorNot()
