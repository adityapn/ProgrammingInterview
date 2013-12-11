package programminginterview;

class MaxSumSubset 
{
	//now let's create a test case
	public static void main(String[] args)
	{
		int[] nums = {-1,2,3,5,-2};
		//int[] nums = new int[10];
		//let's create a random array
		//java.util.Random myRandom = new java.util.Random();
		//for(int i=0; i<nums.length;i++)
		//{
		//	nums[i] = myRandom.nextInt(20)-10;//each number ranges from -10 to 10
		//	System.out.print(""+nums[i]+" ");
		//}
		//now we get the max sum subset
		System.out.println("\nMax sum is "+MaxSubsetSum(nums));
	}

	//define method header
	//we probably intrested to print out max sum index also!
	public static int MaxSubsetSum(int[] nums)
	{
		//we need define two key variables before loop
		//firstly we need a temp sum to keep track of the sum of numbers we processed so far
		//also we need a maxSum to keep track of the currently max sum so far for return purpose
		int tempSum = 0;
		int maxSum = 0;
		//we define the following three index variables to keep track of the sum's start and end indexes.
		int tempSumStartIndex = 0;
		int maxSumStart = 0;
		int maxSumEnd = 0;
		for(int i=0; i<nums.length;i++)
		{
			//as discussed in slides, the key is to decide if tempSum+nums[i]>0
			int futureSum = tempSum + nums[i];
			if(futureSum>0)//which means this can still be part of our final subset for max sum
			{
				tempSum = futureSum;
				//also check if the tempSum is larger than our maxSum recorded so far
				if(tempSum>maxSum)	
				{
					maxSum = tempSum;
					//whenver we update maxSum, we also update maxSum's indexes
					maxSumStart = tempSumStartIndex;
					maxSumEnd = i;//notice i in this closure is the end index
				}
			}
			else//which means the sum so far is negative or zero, which may not be a part of final subset for max sum
			{
				//thus we need reset tempSum
				tempSum = 0;
				//we made one error as we reset the sum that means we ignore the current index, so tempSum = i+1!
				tempSumStartIndex = i+1;//whenever we reset tempsum, we also reset tempSum's start index
			}
		}
		//finally return the maxSum
		//as we cannot return the index values to the method we print out before return in this method
		System.out.print("\n Max Start: "+maxSumStart+"\tEnd: "+maxSumEnd);

		return maxSum;
	}
}
