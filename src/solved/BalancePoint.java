package solved;
// Status : Solved 
public class BalancePoint {
	//now we create a test case
	public static void main(String[] args)
	{
		int[] a = {1,2,3,7,6,5,9,5,6,7,5,2,-1};//expected 6th position
		System.out.println("(Naive) Balance point for a is index "+BalanceNaive(a));
		System.out.println("(Improve) Balance point for a is index "+BalanceImprove(a)+" Value "+a[BalanceNaive(a)]);
		System.out.println("(Best) Balance point for a is index "+BalanceBest(a)+" Value "+a[BalanceNaive(a)]);
	}
	
	public static int BalanceBest(int[] a)
	{
		int leftSum = a[0];
		int rightSum = 0;
		for(int i=0; i<a.length;i++)//notice we start from 2nd as 1st value is set
			rightSum += a[i];//each sum is sum of previous sum plus current value
		
		for(int i=0; i<a.length-1;i++)
		{
			if(leftSum==rightSum)
				return i;
			leftSum+=a[i+1];
			rightSum-=a[i];
		}
		return -1;//otherwise we return -1 as not found
	}
	
	//now we implement the improved method, using extra memory to achieve o(n) time performance
	public static int BalanceImprove(int[] a)
	{
		//as we discussed we need two extra arrays to store the sums from left to right and from right to left
		int[] leftSums = new int[a.length];
		int[] rightSums = new int[a.length];
		//now we compute sums for leftSums, but as each sum is depending on previous sum, we need assign the 1st sum to a[0]
		leftSums[0] = a[0];
		for(int i=1; i<a.length;i++)//notice we start from 2nd as 1st value is set
			leftSums[i] = leftSums[i-1]+a[i];//each sum is sum of previous sum plus current value
		
		//similarly we set right sums
		rightSums[a.length-1] = a[a.length-1];//we proceed from right to left for right sums
		for(int i=a.length-2;i>=0; i--)
			rightSums[i] = rightSums[i+1]+a[i];
		
		//now compare each value in left and right sum arrays to find match
		for(int i=0; i<leftSums.length;i++)
		{
			if(leftSums[i]==rightSums[i])
				return i;//return immediately when we find a match for balance point
		}
		return -1;//otherwise we return -1 as not found
	}
	
	//firstly let's implement the naive method
	//we return the balance index if found or -1 if not found
	public static int BalanceNaive(int[] a)
	{
		for(int i=0; i<a.length;i++)
		{
			//for each position, we compute left sum and right sum and compare, return if found equal left/right sum
			int leftSum = 0;
			int rightSum = 0;
			for(int m=0; m<=i; m++)
				leftSum+=a[m];
			for(int m=i; m<a.length;m++)
				rightSum+=a[m];
			if(leftSum==rightSum)
				return i;//index returned whenever equal left/right found
		}
		return -1;//if no return before that means no balance point found
	}
}
