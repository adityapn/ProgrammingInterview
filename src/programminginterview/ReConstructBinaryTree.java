package programminginterview;

class ReConstructBinaryTree 
{
	//now create a test case
	public static void main(String[] args)
	{
		//assume we want to reconstruct the binary tree
		//    1
		//   2 3
		//    4 5
		//try a more complicated case for example
		int[] preOder = {1,2,3,4,5};
		int[] inOrder = {2,1,4,3,5};
		BinaryTree myTree = Construct(preOder, 0, preOder.length-1, inOrder, 0, inOrder.length-1);
		//verify if it is the tree 
		System.out.print("in-order: ");
		myTree.Traversal_InOrder();
		System.out.print("\npre-order: ");
		myTree.Traversal_PreOrder();
	}

	//now we create the method to construct the binary tree based on preOrder and inOrder traversal
	//notice this is a recursive call by picking root per step and reconstruct the sub trees
	//we need additional support index values to know where the sub tree indexes start and end
	public static BinaryTree Construct(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd)
	{
		//firstly check if there is no element or only one element then immediately return
		if(preStart>preEnd)
			return null;
		if(preStart==preEnd)
			return new BinaryTree(pre[preStart]);
		//otherwise, we use our defined strategy, as the first element in pre-order is the root
		//and we find the value in inorder array to determine how many 'left' elements in there and use
		//that to construct the left sub-tree, same for right-subtree

		int rootIndexInorder = 0;
		for(int i=inStart; i<=inEnd; i++)
		{
			if(in[i]==pre[preStart])//we find the first(root) of preorder array in the in-order array
			{
				rootIndexInorder = i;
				break;
			}
		}

		//now we know how many values in left-subTree
		int leftSubCount = rootIndexInorder - inStart;
		int rightSubCount = inEnd - rootIndexInorder;//same for right sub-tree

		//before that we need build our tree
		BinaryTree theTree = new BinaryTree(pre[preStart]);

		//knowing the span we can construct the left sub-tree
		theTree.left = Construct(pre, preStart+1, preStart+leftSubCount, in, inStart, inStart+leftSubCount-1);
		theTree.right = Construct(pre, preStart+leftSubCount+1, preEnd, in, inStart+leftSubCount+1, inEnd);

		return theTree;
	}
}
class BinaryTree
{
	int value;
	BinaryTree left;
	BinaryTree right;
	public BinaryTree(int k)
	{
		value = k;
	}
	//we reused the binary tree class in our last example, we also added two traversal method
	public void Traversal_InOrder()
	{
		if(this!=null)
		{
			if(left!=null)
				left.Traversal_InOrder();
			System.out.print(value+",");
			if(right!=null)
				right.Traversal_InOrder();
		}
	}
	public void Traversal_PreOrder()
	{
		if(this!=null)
		{
			System.out.print(value+",");
			if(left!=null)
				left.Traversal_PreOrder();
			if(right!=null)
				right.Traversal_PreOrder();
		}
	}
}
