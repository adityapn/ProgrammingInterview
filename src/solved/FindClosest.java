package solved;

public class FindClosest 
{
	//now we create a test case
	public static void main(String[] args)
	{
		//firstly create a test tree as
		//    100
		//  50   200
		// 10 60 150 300
		Tree myBST = new Tree(100);
		myBST.left = new Tree(50);	myBST.right = new Tree(200);
		myBST.left.left = new Tree(10);	myBST.left.right = new Tree(60);
		myBST.right.left = new Tree(150);	myBST.right.right = new Tree(300);

		System.out.println("Closest value in BST to 120 is "+GetClosest(myBST, 120));
		System.out.println("Closest value in BST to 80 is "+GetClosest(myBST, 80));
		System.out.println("Closest value in BST to 1000 is "+GetClosest(myBST, 1000));
		System.out.println("Closest value in BST to 0 is "+GetClosest(myBST, 0));
	}


	//final method to declare, after we find the 'min diff' we return diff+v as returned value
	public static int GetClosest(Tree t, int v)
	{
		int minDiff = Min_Diff(t, v);
		return minDiff+v;
	}

	//now come to define the key method
	public static int Min_Diff(Tree t, int v)
	{
		//as we discussed in slides, the key of finding 'closest value' is to find the minimal diff
		if(t == null)//make sure it is not an empty tree
			return Integer.MAX_VALUE;
		//now check the value to determine which sub-direction to search for the 'minimal diff'
		if(t.value<v)//which means the closest value can only exist in root or some value in its right sub-tree
			return smallDiff(t.value-v,Min_Diff(t.right, v)); //notice we recursively call the method 
		else//can only exist in either root or its left subtree
			return smallDiff(t.value-v,Min_Diff(t.left, v));
	}


	//firstly define a supportive method to determine the smaller difference
	private static int smallDiff(int a, int b)
	{
		if(Math.abs(a)>Math.abs(b))
			return b;
		
                return a;
	}
}

class Tree {
	int value;
	Tree left;
	Tree right;
	public Tree(int a)
	{
           value = a;
	}
}
