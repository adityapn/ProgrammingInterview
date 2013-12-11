package programminginterview;

import java.util.Stack;
class TreeTraversal 
{
	public static void main(String[] args)
	{
		//let's create a binary tree
		//    1
		//  2   3
		// 4 5 6 7
		MyTree t = new MyTree(1);
		t.left = new MyTree(2);			t.right = new MyTree(3);
		t.left.left = new MyTree(4);		t.left.right = new MyTree(5);
		t.right.left = new MyTree(6);		t.right.right = new MyTree(7);
		System.out.println("In order using recursion: ");
		t.InOrder();
		System.out.println("\nIn order without recursion: ");
		t.InOrderNoRecursion();
		System.out.println("\nPreorder using recursion: ");
		t.Preorder();
		System.out.println("\nPreorder without recursion: ");
		t.PreorderNoRecursion();
	}
}

class MyTree
{
	int value;
	MyTree left;
	MyTree right;
	public MyTree(int v)
	{
		value = v;
	}

	//we firstly implement an inorder using recursion
	public void InOrder()
	{
		if(left!=null)
			left.InOrder();
		System.out.print(value+", ");//print out as visiting it
		if(right!=null)
			right.InOrder();
	}

	//now implement a non-recursive inorder traversal method
	public void InOrderNoRecursion()
	{
		//firstly we need a support stack
		Stack<MyTree> myStack = new Stack<MyTree>();
		//now we start processing the tree
		//we also need a current focus to know where we are
		MyTree current = this;

		//the criteria to decide when we stop the loop is when current points to null and no nodes in stack
		while(current!=null || !myStack.isEmpty())
		{
			//firstly if current is not null, we push current to stack and shift focus to its left sub-tree
			if(current!=null)
			{
				myStack.push(current);
				current = current.left;
			}
			else//we need pop out nodes from the stack and at that time we shift focus to its right sub-tree
			{
				current = myStack.pop();
				System.out.print(current.value+", ");//print out as visiting it
				current = current.right;
			}
		}
	}

	//now we process with pre-order
	//firstly implement a recursive preorder method
	public void Preorder()
	{
		System.out.print(value+", ");
		if(left!=null)
			left.Preorder();
		if(right!=null)
			right.Preorder();
	}

	//now to implement the non-recursive preorder method
	public void PreorderNoRecursion()
	{
		//similar as the non-recursive inorder traversal we need a stack and current focus pointer
		Stack<MyTree> myStack = new Stack<MyTree>();
		MyTree current = this;
		//also we have the same criterial to decide when the loop stops
		while(current!=null || !myStack.isEmpty())
		{
			//firstly we keep print out each value, store its right sub-tree to stack and shift focus to left sub-tree
			if(current!=null)
			{
				System.out.print(current.value+", ");
				myStack.push(current.right);
				current = current.left;
			}
			else//t==null
			{
				current = myStack.pop();
			}
		}
	}
}
