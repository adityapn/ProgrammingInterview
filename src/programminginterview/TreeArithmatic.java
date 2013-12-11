package programminginterview;

public class TreeArithmatic 
{
	//now let's create a test case
	public static void main(String[] args)
	{
		//let's try compute 12*3+4*5
		//thus the tree should be
		//      +
		//   *     *
		//  12 3   4  5
		ATree myTree = new ATree("+");
		myTree.left = new ATree("*");	myTree.right = new ATree("*");
		myTree.left.left = new ATree("12");	myTree.left.right = new ATree("3");
		myTree.right.left = new ATree("4");	myTree.right.right = new ATree("5");
		compute(myTree);
		System.out.println("Result is "+values.pop());//expect 12*3+4*5 = 56
		System.out.println("Result (improved method) is "+computerWithoutstack(myTree));
	}

	//method 2, top down without stack
	public static int computerWithoutstack(ATree myTree)
	{
		if(myTree.left==null&&myTree.left==null)
		{
			return Integer.parseInt(myTree.value);//must be number
		}
		int leftResult = computerWithoutstack(myTree.left);
		int rightResult = computerWithoutstack(myTree.right);
		return compute(myTree.value.charAt(0), leftResult, rightResult);
	}

	//now it's time to run a postorder traversal of tree and compute results
	public static void compute(ATree myTree)
	{
		if(myTree!=null)//make sure it is necessary to go on
		{
			compute(myTree.left);
			compute(myTree.right);
			//now process this node
			//firstly as we discussed if it is a number, we push to stack
			if(!ifOperator(myTree.value))
			{
				values.push(Integer.parseInt(myTree.value));//parse string to int and push to stack
			}
			else//otherwise, pop operands from stack and compute and push back
			{
				int b = values.pop();
				int a = values.pop();//notice the order of operands, stack is LIFO
				char op = myTree.value.charAt(0);
				int tempResult = compute(op,a,b);
				values.push(tempResult);
			}
		}
	}

	//now before we process tree we need define a stack and some supporting methods
	//1. define a stack, for convenience, we define as a static object for easy testing
	static java.util.Stack<Integer> values = new java.util.Stack<Integer>();//generic type is preferred!

	//2. define supporting methods
	//the first support method is to judge if a string a number or operator
	private static boolean ifOperator(String in)
	{
		return in.equals("+")||in.equals("-")||in.equals("*")||in.equals("/");
	}

	//we also define a compute method to accept opeators and operands
	private static int compute(char op, int a, int b)//op is the operator
	{
		switch(op)
		{
			case '+': return a+b;
			case '-': return a-b;
			case '*': return a*b;
			case '/': return a/b;
		}
		return -1;//usually we do not come here unless invalid input, we ignore error processing
	}
}
//define my simple tree class
class ATree
{
	ATree left;
	ATree right;
	String value;
	public ATree(String in)
	{
		value  = in;
	}
}