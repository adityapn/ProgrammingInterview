package programminginterview;

public class PringAllPairsSumToM {
	//now let's create a simple test case
	public static void main(String[] args)
	{
		int[] sorted = {1,2,3,4,9,9,10};
		PrintAllPairs(sorted, 12);
	}


	//define method header
	public static void PrintAllPairs(int[] sorted, int M)
	{
		//as the key is to keep track of two indexes, left and right, we define the indexes
		int left = 0;//leftmost
		int right = sorted.length-1;//rightmost
		
		//now we start our loop, and only make sure left not meet right will we proceed
		while(left<right)
		{
			int tempSum = sorted[left] + sorted[right];//calculate the temp sum and use it to compare to M
			if(tempSum==M)//great we find one pair!
			{
				//format the output per line as "Sum{1,10}=11"
				System.out.println("Sum of {"+sorted[left]+", "+sorted[right]+"} = "+M);
				//do not forget the update both index values
				left++;
				right--;
			}
			else if(tempSum>M)//as the temp sum is bigger than M, 
								//we need more right focus left to make the future sum smaller
				right--;
			else//the only remaining case is temp sum smaller than M, so move left focus right 
				left++;
		}

	}
}
