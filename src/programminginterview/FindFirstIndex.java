package programminginterview;

class  FindFirstIndex
{
	//now create a test case
	public static void main(String[] args)
	{
		int[] nums = {1,2,2,3,3,3,3,3,3,3,3,4,5,6,7,8,9};
		System.out.println("First index of number 3 is "+GetFirstIndex(nums, 3, 0, nums.length-1));
		//notice how the method is called from main block, the start=0 and end=length-1
	}

	//define method header
	//notice we define a same header as a normal binary search
	//nums are the sorted array, a is the number we are looking for
	//start and end are two index values to keep track of the current focus sub-array
	public static int GetFirstIndex(int[] nums, int a, int start, int end)
	{
		//firstly, check if sub-array is valid
		if(end<start) 
                    return -1;//if no element left for analyzing, return -1 as invalid,
		//now check the sub-array to see if possibly it contains a
		if(nums[start]>a) 
                    return -1;//because even the smallest element is larger than a, not possible!
		if(nums[end]<a) 
                    return -1; //similarly, if largest value is smaller than a, not possible to contain a

		//now is the key, before we go, we need check if first element is a
		if(nums[start]==a) 
                    return start; //this is the key, we need find the beginning position of all as

		//now coming to the binary search part
		int mid = (start+end)/2;
		if(nums[mid]==a)
		{
			//we have two choice, either mid position is candidate, or the index we find in the left half can be
			int leftIndex = GetFirstIndex(nums, a, start, mid-1);//recursive call
			return leftIndex==-1?mid:leftIndex; //only if leftIndex is valid (not equal to -1) will return leftIndex, otherwise, return mid!
		}
		else if(nums[mid]>a)//which means a can only appear in left half!
			return GetFirstIndex(nums, a, start, mid-1);
		else//only possible in right half
			return GetFirstIndex(nums, a, mid+1, end);
		
	}
}
