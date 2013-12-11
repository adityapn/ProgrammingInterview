package programminginterview;

class kthLargest 
{
	//let's create a test case
	public static void main(String[] args)
	{
		int[] nums = new int[20];
		java.util.Random myRandom = new java.util.Random();
		System.out.print("Numbers: ");
		for(int i=0; i<nums.length;i++)
		{
			nums[i] = myRandom.nextInt(100);//each number is random from 0-99
			System.out.print(nums[i]+",");
		}
		System.out.println();
		System.out.println("10th largest value is "+FindKthLargest(nums, 10));
		System.out.print("After finding: ");
		for(int i=0; i<nums.length;i++)
		{
			System.out.print(nums[i]+",");
		}
		System.out.println();
		//notice the whole array is not sorted after we identified kth largest value!
	}

	//define method header
	public static int FindKthLargest(int[] nums, int k)
	{
		//firstly make sure k is valid between (1, nums.length)
		if(k<1||k>nums.length)
			return -1;//let's assume -1 as the default bad signal though in reality we should improve this
		//otherwise, we are going to use quick sort to solve this problem
		//though compared to full quicksort we only need to take care of the kth value at position!
		//thus we need two support values to know the region of array we focus on
		return FindKthLargest(nums, 0, nums.length-1, k);
	}

	public static int FindKthLargest(int[] nums, int start, int end, int k)
	{
		//this is the key method, the basic idea is to borrow the quick sort algorithm
		//by picking a pivot and put in place and check if it is value we are looking for
		int pivot = start;//assume pivot position is 1st element
		int left = start;
		int right = end;//we keep start/end untouched and copy values for processing in method
		while(left<=right)
		{
			//so we scan from left to right until we find a value which is larger than pivot value
			while(left<=right && nums[left]<=nums[pivot])
				++left;//after this loop, the value at left is larger than pivot position thus need swapping
			while(left<=right && nums[right]>=nums[pivot])
				--right;//similar for right one
			//now we swap if valid
			if(left<right)
			{
				Swap(nums, left, right);
			}
		}
		//after the loop, the correct pivot position should rely on right's position
		Swap(nums, pivot, right);

		//now different from quick sort, we firstly check if we can return from here
		if(k==right+1)//notice k is nth, start from 1 while index starts from 0
			return nums[right];//we immediately return as right position value is set!
		else if(k>right+1)//that means we have divided values to 2 groups, and kth largest can only exist in right half
			return FindKthLargest(nums, right+1, end, k);
		else//we only need focus on the left half
			return FindKthLargest(nums, start, right-1, k);
	}

	//define a support method to swap
	private static void Swap(int[] nums, int a, int b)
	{
		int tmp = nums[a];
		nums[a] = nums[b];
		nums[b] = tmp;
	}
}
