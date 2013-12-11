package programminginterview;

public class NQueenProblem {
	public static void main(String[] args) {
		//ok a test case to see if 4*4 results in 2 settings
		int N = 8;
		int[][] board = new int[N][N];
		//8 queen has 92 setters based on wikipedia
		System.out.println(""+N+"-Queen: "+GetNQueenSettings(board, 0, N));
	}
	//we start define the key method, as we are trying to know how many ways of placements
	//we need an int return type, and we need three input parameters, the board, the current row info
	//and the N (though optional, because it can be computed from board size)
	//board: 0 means unset, positive means set, negative means invalid!
	static int GetNQueenSettings(int[][] board, int currentRow, int N) {
		//firstly decide when the recursion stops
		if(currentRow == N) {
			return 1;//whenever we come to out of last row, we get a successful setting!
		}
		//otherwise, we try to set column by column in this row and continue
		int totalSettingCount = 0;
		for(int i=0; i<N; i++) {
			//firstly make sure it can be set (it is unset at that moment)
			if(board[currentRow][i] == 0) {
				board[currentRow][i] = 1+currentRow;//we use row-related info for settings!
				//now we need set invalid positions for remaining rows
				
				//assume we have such a method accepting an additional column index as parameter
				setInvalid(board, currentRow, N, i);
				
				//oh god, forget the most important recursive calling
				totalSettingCount += GetNQueenSettings(board, currentRow+1, N);
				
				//after that. we need recover everything before trying next one!
				board[currentRow][i] = 0;
				//similarly we assume we have such a method to recover the board as we discussed in slide
				recoverBoard(board, currentRow, N);//column index is not needed for recovery
			}
		}
		return totalSettingCount;
	}
	
	static void setInvalid(int[][] board, int currentRow, int N, int i) {
		//as we discussed in slides, we need set vertical and diagonal positions!
		for(int row=currentRow+1; row<N; row++) { //start from next line
			//firstly make sure the board can be set
			if(board[row][i] == 0)//vertical position
				board[row][i] = -(1+currentRow);
			//now check diagonal positions
			int rowGap = row - currentRow;
			if(i-rowGap>=0 && board[row][i-rowGap] == 0) {//left bottom diagonal position
				board[row][i-rowGap] = -(1+currentRow);
			}
			if(i+rowGap<N && board[row][i+rowGap] == 0) {//right bottom diagonal position
				board[row][i+rowGap] = -(1+currentRow);
			}
		}
	}
	
	static void recoverBoard(int[][] board, int currentRow, int N) {
		//recover is to check all remaining rows to see if index is higher than currentRow (setters)
		//OR less than -currentRow (invalids)
		for(int row=currentRow+1; row<N; row++) {
			for(int col=0; col<N; col++) {
				if(board[row][col] > currentRow || board[row][col] < -currentRow)
					board[row][col] = 0;
			}
		}
	}
}