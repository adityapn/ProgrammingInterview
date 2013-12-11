package programminginterview;
public class LargestSumMatrix {
	//finally, we create a test case
	public static void main(String[] args)
	{
		int[][] matrix = new int[100][100];
		java.util.Random myRandom = new java.util.Random();
		for(int i=0; i<matrix.length;i++)//per row
			for(int j=0; j<matrix[0].length;j++)//per column
			{
				matrix[i][j] = myRandom.nextInt(20)-10;//each value randoms from -10 to 10
			}
		System.out.println("Max sum for improved method "+MaxSumImprove(matrix));
		System.out.println("Max sum for naive method "+MaxSumNaive(matrix));//this method is slow for large case, as you can see it is stuck...
	}
	
	
	//ok. this is the key method definition, so we focus on arbitrary rows and do the problem in 1-D
	public static int MaxSumImprove(int[][] matrix)
	{
		int maxSum = 0;
		for(int i=0; i<matrix.length;i++)//start row
			for(int j=i; j<matrix.length;j++)//end row
			{
				//now we need a temp 1-D array to store sums per column
				int[] tempSums = new int[matrix[0].length];//notice the length
				for(int m=0; m<tempSums.length;m++)//per column
				{
					for(int p=i; p<=j; p++)//per row selected
						tempSums[m] += matrix[m][p];
				}
				//now we only need check the largest sum for the 1-D array tempSums
				int tempLargest = LargestSubSum(tempSums);
				if(tempLargest>maxSum)
					maxSum = tempLargest;
			}
		return maxSum;
	}
	
	//before we implement the maxSumMatrix, we implement the supporting largest subsequent sum for 1-D array
	private static int LargestSubSum(int[] arr)
	{
		int maxSum = 0;//this is value to return
		int tempSum = 0;//this is to keep track of current sum. check Q16 for more details
		for(int i=0; i<arr.length;i++)
		{
			//key idea to check if tempSum+this element is larger than 0 or not
			if(tempSum+arr[i]>0)//still can be part of the final largest sum's part
			{
				tempSum += arr[i];
				if(tempSum>maxSum)
					maxSum = tempSum;
			}
			else//this can be discarded as the possiblity being part for largest sum
				tempSum = 0;//reset
		}
		return maxSum;//do not forget to return
	}
	
	//firstly try the naive method
	public static int MaxSumNaive(int[][] matrix)
	{
		//the key is to select start point and end point and compute sum
		int maxSum = 0;
		for(int i=0; i<matrix.length;i++)//start point x
			for(int j=0; j<matrix[0].length;j++)//start point y
				for(int m=i; m<matrix.length;m++)//end point x, make sure end point is behine start point
					for(int n=j; n<matrix[0].length;n++)//end point y
					{
						int tempSum = 0;
						//now compute the sum from (i,j) to (m,n)
						for(int p=i; p<=m;p++)
							for(int q=j; q<=n;q++)
								tempSum+=matrix[p][q];
						if(tempSum>maxSum)
							maxSum = tempSum;//only update if we find a larger sum
					}
		return maxSum;//do not forget to return the maxSum
	}
}
