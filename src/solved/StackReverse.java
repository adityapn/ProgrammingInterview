package solved;

import java.util.*;

public class StackReverse {
    
         public static void main(String args[])
	{
		Stack<Integer> s=new Stack<Integer>();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the no. of no.s to be pushed ");
		int n=sc.nextInt();
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter");
			s.push(sc.nextInt());
		}
		reverse(s);
		System.out.println("Stack after reversal is ");
		while(!s.isEmpty())
		System.out.println(s);
	}
	public static void reverse(Stack<Integer> s)
	{
		if(s.isEmpty())
		return;
		int x=s.pop();
		reverse(s);
		s.push(x);
	}
    
}
