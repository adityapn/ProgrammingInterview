package programminginterview;

class PrintSpiral 
{
	public static void main(String[] args)
	{
		int[][] nums = {{1,2,3, 10}, 
					{4,5,6, 20}, 
					{7,8,9, 30}};
		PringSpiral(nums);//so expected order is 1 2 3, 10, 20, 30,9 8 7 4 5 6 correct!
	}


	public static void PringSpiral(int[][] nums)
	{
		//so firstly we need index variables to know where we are
		int x = 0; int y = -1;//x and y stands for column and row indexes
		//y value need to be set as -1 initially so we can proceed whole line at first
		int index = 0;//as we discussed in slides, this index is to keep track of processing row/colomn index
		//now we start to process
		while(true)//we define a loop and will get out the loop at proper time
		{
			//so before printint out values, we need determine for this row/column, how many values to be printed
			//and if we look at a 3x3 matrix, the order will be 3,2,2,1,1 elements to be printed
			int thisLength = 0;//thus we need determine this value
			//firstly index will be telling us row/column we are looking
			if(index%2==0)//columns, horizontal scan
				thisLength = nums[0].length - (index/2);//think why this
			else//rows, vertical scan
				thisLength = nums.length - (index/2) - 1;//this is another place that notice first time to print the vertical column there is one element printed out already
			
			//before going we need check if this length is zero if so we quit
			if(thisLength==0) return;

			//otherwise, we now need decide direction, again as index is keep increasing, we need judging its value compared to 4 directions
			int xIncre = 0;
			int yIncre = 0;//they are important to know which direction to go
			switch(index%4)//assume order is right down left up and continue
			{
				case 0: yIncre = 1; break;//think we proceed to right, so only y index needs incrementing
				case 1: xIncre = 1; break;//down
				case 2: yIncre = -1; break;//left
				case 3: xIncre = -1; break;//up
			}

			//now we scan the whole row/column
			for(int i=0; i<thisLength;i++)
				System.out.print(nums[x+(i+1)*xIncre][y+(i+1)*yIncre]+" ");//pay attention to the index settings

			//after processing this particular row/column
			x = x+thisLength*xIncre;//we set the currentFocus to last element
			y = y+thisLength*yIncre;

			//do not forget update index and proceed
			index++;
		}
	}
}
