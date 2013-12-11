package programminginterview;

class Search2DSortedArray 
{
	//let's create a test case
	public static void main(String[] args)
	{
		int[][] sorted = {	{1,4,5}, 
							{2,6,7},
							{3,8,9}};
		Search(sorted, 3);//expect to be found at location (2,0)
		Search(sorted, 4);//expect to be found at location (0,1)
		Search(sorted, 10);//expected to be not found
	}


	//define the search method
	public static void Search(int[][] sorted, int k)//k is the value to be searched for
	{
		//as we discussed, we start from the lower-left corner of the 2-D array, similarly we can start from upper-right
		int x = sorted.length-1;//x stands for row count
		int y = 0;//y stands for column
		
		//let's also define a value to indicate whether we find or not
		boolean ifFound = false;

		//now we define our key loop to keep searching, the key is if (x,y) are valid index entries for the array
		while(x>=0 && y<=sorted[0].length-1)//notice y's length is controlled by sorted[0] which stands for the column count of the 2-D array
		{
			//now we judge the value at this particular position (x,Y) versus k
			if(sorted[x][y]>k)//as we discussed, if this value is larger than k, all the values in its right cannot be equal to k thus ignored
				x--;//we shift our focus to the upper row
			else if(sorted[x][y]<k)//oppositely, we shift our focus to right column 
				y++;
			else//they are equal, thus we find this value yeah!
			{
				ifFound = true;
				System.out.println("Found value "+k+" at ("+x+", "+y+")");
				break;//we can get out of the loop as we already find
			}
		}
		//when we come here we need to print out feedback if not found
		if(!ifFound)
			System.out.println("Not Found value "+k);
	}
}
