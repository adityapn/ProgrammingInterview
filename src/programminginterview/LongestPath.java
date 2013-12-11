package programminginterview;

class Response
{
	public Response(int c, Node l)
	{
		count = c;
		last  = l;
	}
	int count;
	Node last;
}
class Node
{
	public Node(int n)
	{
		value=n;
	}
	int value;
	Node right;
	Node left;
}
public class LongestPath
{
	static int max = 0;
	static Node[] r;
	
	static Response getLongestPath(Node root)
	{
		Response left=null, right=null;
		
		if(root.left == null && root.right==null)
			return new Response(1,root);
		
		if(root.left != null)
			left = getLongestPath(root.left);
		if(root.right != null)
			right = getLongestPath(root.right);
		
		if(root.left==null)
			return new Response(right.count+1, right.last);
		if(root.right==null)
			return new Response(left.count+1, left.last);
		
		if(left.count + right.count + 1 > max)
		{
			max = left.count + right.count +1;
			r[0] = left.last;
			r[1] = right.last;
		}
		if(left.count > right.count)
			return new Response(left.count+1, left.last);
			
		return new Response(right.count+1, right.last);
	}
	public static void main(String... args)
	{
		Node root = new Node(5);
		root.left = new Node(3);
		root.left.left = new Node(1);
		root.right = new Node(9);
		root.right.left = new Node(6);
		root.right.right = new Node(10);
		
		r=new Node[2];
		Response temp = getLongestPath(root);
		System.out.println(r[0].value +" "+ r[1].value);
	}
}