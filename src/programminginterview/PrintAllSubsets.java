package programminginterview;
public class PrintAllSubsets {
	//lastly let's create a test case
	public static void main(String[] args)
	{
		int[] nums = {1,2,3,4};
		PrintSubSet(nums);
	}
	
	//step 1, decide how many elements in a sub-array to be printed
	public static void PrintSubSet(int[] nums)
	{
		//now we process the first step
		for(int i=0; i<=nums.length;i++)//subset length could vary from 0 to nums.length
		{
			boolean[] ifPrint = new boolean[nums.length];
			PrintSubSet(nums, ifPrint, 0, i);//start from 0th index, and the size varies for the loop
		}
	}
	
	//step 2, this method processed the action to print out all possible combination of elements with fixed size
	//as we discussed in the slide, we need three additional variables to keep track of status
	//boolean array to know whether printed out or not, 
	//start is the start index to be printed to prevent duplicates
	//remain is keeping track of how many remaining elements to be processed for the subset action
	public static void PrintSubSet(int[] nums, boolean[] ifPrint, int start, int remain)
	{
		//firstly if remain==0, we done!
		if(remain==0)
		{
			System.out.print("{");
			//check each ifPrint status to decide print or not
			for(int i=0; i<ifPrint.length;i++)
			{
				if(ifPrint[i])
					System.out.print(nums[i]+",");
			}
			System.out.print("}\n");//format the output of one subset one line
		}
		else
		{
			//now is the key recursive part, we need process char by char from the start position until end
			//before that, we need determine whether we proceed or not to check if start+remain>nums.length
			if(start+remain>nums.length)//not possible even if all remaining element to be used
				;
			else
			{
				for(int i=start; i<nums.length;i++)
				{
					//now before we come to recursive part we have to make sure this position is not used
					if(!ifPrint[i])
					{
						//now assign its value to true as used indicator
						ifPrint[i] = true;
						//recursive call!
						PrintSubSet(nums, ifPrint, i+1, remain-1);//notice the update of start index and remain count
						//another key point! set the position back to false and proceed from next element
						ifPrint[i] = false;
					}
				}
			}
		}
	}
}
