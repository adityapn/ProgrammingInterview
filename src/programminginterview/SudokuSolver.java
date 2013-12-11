package programminginterview;

class SudokuSolver 
{
	//now let's write a test case
	public static void main(String[] args)
	{
		/*int[][] board = {
			{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
						};
		System.out.println("My sudoku");
		Print(board);
		//we firstly play with a simple example that no-values are set, any sukudo will fit
		if(Solve(board))
		{
			System.out.println("Find a solution!");
			Print(board);
		}
		else
		{
			System.out.println("No solution is found!");
		}
		*/
		//now we try a more difficult example
		int[][] board2 = { 
        { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
        { 5, 9, 3, 6, 0, 0, 0, 0, 0 },
        { 2, 6, 8, 0, 0, 0, 0, 0, 0 },
        { 4, 0, 1, 0, 0, 0, 3, 0, 0 },
        { 0, 0, 0, 4, 0, 0, 0, 9, 2 },
        { 0, 8, 0, 0, 0, 0, 0, 6, 0 },
        { 0, 2, 0, 0, 6, 1, 8, 0, 5 },
        { 0, 0, 0, 2, 3, 0, 0, 0, 1 },
        { 1, 0, 0, 0, 0, 8, 0, 3, 0 }
        };
		System.out.println("My sudoku 2");
		Print(board2);
		//we firstly play with a simple example that no-values are set, any sukudo will fit
		if(Solve(board2))
		{
			System.out.println("Find a solution!");
			Print(board2);
		}
		else
		{
			System.out.println("No solution is found!");
		}
	}

	//a support method to print out board
	public static void Print(int[][] board)
	{
		for(int i=0; i<9; i++)//suduko is 9*9
		{
			for(int j=0; j<9; j++)//suduko is 9*9
			{
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}

	//define the method header
	//assume all pre-set numbers are numbers between 1-9 and the values haven't set is zero
	public static boolean Solve(int[][] board)
	{
		//as we discussed in slide we need a support array with same size as board to keep track of status
		int[][] status = new int[board.length][board[0].length];
		//now we set the status, for each non-zero position we set status as 2 means fixed!
		for(int i=0; i<9; i++)//suduko is 9*9
		{
			for(int j=0; j<9; j++)//suduko is 9*9
			{
				status[i][j] = board[i][j]>0?2:0;
			}
		}
		//now we will use both arrays to start from the 1st element!
		return Solve(board, status, 0, 0);//we start from very first one element
	}

	//define the key recursive searching method
	//board is the values for the game, status is support array to know the status of each position
	//x,y is the coordinates of position we are intersted in now
	public static boolean Solve(int[][] board, int[][] status, int x, int y)
	{
		//now we start processing
		//first step, we judge if we come to the end, we start from (0,0) until (8,8) then (9,0) will be invalid and should stop!
		if(x==9)//we come to the end
		{
			//we need check of all values are set
			int count = 0;//we need 81 set values
			for(int i=0; i<9; i++)
			{
				for(int j=0; j<9; j++)//suduko is 9*9
				{
					count += status[i][j]>0?1:0;//we update the value only if status is non-zero as set
				}
			}
			if(count==81)//all set
				return true;//great we find one!
			else
				return false;//sorry this trial failed 
		}
		//other wise we can proceed further
		if(status[x][y]>=1)//if the current position has already been set!
		{
			//we step further to next value;
			int nextX = x;
			int nextY = y+1;//we proceed to the right if it is the end, we come to front of next row
			if(nextY==9)//last element
			{
				nextX = x+1; nextY = 0;
			}
			//recursive call of next position
			return Solve(board, status, nextX, nextY);//sorry we should return the value here!
		}
		else//this is the key of the method, we check row/column/3*3 box to decide all possible values
		{
			//we create a 9-length array to check what values have been used in nearby positions thus cannot be used
			boolean[] used = new boolean[9];
			//check row
			for(int i=0; i<9;i++)
			{
				if(status[x][i]>=1)
					used[board[x][i]-1] = true;//notice we call board[x][i] and use the value-1 as index to set used array
			}

			//similarly we chck column
			for(int i=0; i<9;i++)
			{
				if(status[i][y]>=1)
					used[board[i][y]-1] = true;
			}

			//now we need check the associated 3*3 box to check nearby values
			//the rows start from 0,3,6, columns also start from 0,3,6
			for(int i=x-(x%3);i<x-(x%3)+3;i++)//this makes sure we start from the correct rows
				for(int j=y-(y%3);j<y-(y%3)+3;j++)//y settings are similar
				{
					if(status[i][j]>=1)
						used[board[i][j]-1] = true;
				}
			
			//after the check of all row/column/3*3 box, we try to assign each possible value to current position and try next!
			//also remember the use of status array is for further recovery if that try failed, so we set status to 1 
			//to be different from 2 (pre-fixed) so later we can reverse the settings
			for(int i=0; i<used.length;i++)
			{
				if(!used[i])//notice only those unused values can be set here
				{
					//we set and proceed and lastly reverse the settings for next iteration!
					status[x][y] = 1;//1 as we-set status, different from 0-nonset and 2-pre-fixed
					board[x][y] = i+1;//index+1 is the value
					//we repeat the index increasing operation
					int nextX = x;
					int nextY = y+1;//we proceed to the right if it is the end, we come to front of next row
					if(nextY==9)//last element
					{
						nextX = x+1; nextY = 0;
					}
					//recursive call of next position
					if(Solve(board, status, nextX, nextY))
						return true;

					//now it means the setting failed we should reverse the setting to try next value
					for(int m=0; m<9; m++)
						for(int n=0; n<9; n++)
						{
							//only reverse-set those values behind current (x,y) position
							if(m>x||(m==x&&n>=y))
							{
								if(status[m][n]==1)//only reverse those we-set nodes
								{
									status[m][n] = 0;
									board[m][n] = 0;
								}
							}
						}
				}
			}
		}
		//do not forget to return a default false signal
		return false;
	}
}
