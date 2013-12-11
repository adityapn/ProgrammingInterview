package programminginterview;

class TestSubBinaryTree 
{
	//create a test case
	public static void main(String[] args)
	{
		//let's create a parent tree of 
		//   1
		// 2  3
		//   4 5
		BinaryTree t1 = new BinaryTree(1);
		t1.left =  new BinaryTree(2); t1.right =  new BinaryTree(3);
		t1.right.left =  new BinaryTree(4);t1.right.right =  new BinaryTree(5);

		//we create a subtree
		// 3
		//4 6
		BinaryTree t2 = new BinaryTree(3);
		t2.left =  new BinaryTree(4); t2.right =  new BinaryTree(6);

		//test for equal from reference view
		if(ifSubTreeRef(t1, t1.left.right))//this time should be sub-tree
			System.out.println("T2 is a sub-tree of t1 (Reference)");
		else
			System.out.println("T2 is NOT a sub-tree of t1 (Reference)");

		//test for equal from value view
		if(ifSubTreeValue(t1, t2))//expect false now
			System.out.println("T2 is a sub-tree of t1 (Value)");
		else
			System.out.println("T2 is NOT a sub-tree of t1 (Value)");
	}

	//now play with the harder case, check if subtree from values
	public static boolean ifSubTreeValue(BinaryTree t1, BinaryTree t2)
	{
		//in this case we need firstly check if root values are equal, if so, we continue check children values
		//for both trees until we find match or not, this step should be tried until a true signal returned or
		//all the sub-trees have been visited for t1

		//firstly, we check if t2==null
		if(t2==null)
			return true;
		if(t1==null)//thus t2 is not-null in this case as the previous if clause solved the t2==null case
			return false;
		//now we need check if both trees' roots are the same
		if(t1.value==t2.value)
		{
			//then we need check if both t1 and t2's subtree are same
			if(ifSubTreeValue(t1.left, t2.left) && ifSubTreeValue(t1.right, t2.right))
				return true;//we found one if roots are same are all children trees are same
		}
		//other wise, we need go to the t1's left or right sub-tree to continue the equality finding
		return ifSubTreeValue(t1.left, t2) || ifSubTreeValue(t1.right, t2);//notice it is OR not AND
	}

	//now we start from the simpler case, compare if a tree is another's subtree based on reference value
	public static boolean ifSubTreeRef(BinaryTree t1, BinaryTree t2)
	{
		//the idea is simple, firstly check if t1 or t2 are null before comparing
		if(t2==null)
			return true;//no matter t1 is what, if t2 is null we accept it as a sub-tree
		if(t1==null)
			return false;//as t2 must be non-null value, if t1 is null t2 cannot be a sub-tree of t1
		//other wise, we compare if they are equal reference at this moment if not compare t1's child with t2
		return (t1==t2)
			    || ifSubTreeRef(t1.left, t2)
			    || ifSubTreeRef(t1.right, t2);
	}
}
//we firstly define a binary tree class
class SubBinaryTree
{
	int value;
	SubBinaryTree left;
	SubBinaryTree right;
	public SubBinaryTree(int k)
	{
		value = k;
	}
}
