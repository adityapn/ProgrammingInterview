package solved;

/*
 Question 
 * 
 * Given a matrix, write a program to print the elements in a circular way. Only two loops can be used. 
 * eg : 
 * 1 2 3 is the input matrix.
 * 8 9 4
 * 7 6 5
 * 
 * output : 1 2 3 4 5 6 7 8 9
 */


public class CircularMatrix {
    
    public static void main(String s[]){
    
        int matrix[][] = {{1,2,3},{8,9,4},{7,6,5}};
        int n = 3;
        int result[]  = new int[3];
        result = circularWay(matrix);
        for(int i=0;i<result.length;i++){
                System.out.println(" "+result[i]);
        }
    }
    public static int[] circularWay (int[][] matrix) {
		
		int[] result = new int[matrix.length*matrix[0].length];// 3*3 = 9
		int[][] hash = new int[matrix.length][matrix[0].length];
		int[][] moves = {{0,1},{1,0},{0,-1},{-1,0}};
		
		int i = 0;
		int j = 0;
		int m = 0;
		int pos = 0;
		
		while (hash[i][j] == 0) {
			
			int row = i + moves[m][0];
			int column = j + moves[m][1];
			
			if ((row < matrix.length) && (column < matrix[0].length)
					&& (row >= 0) && (column >= 0)
					&& (hash[row][column] == 0)) {
				
				result[pos] = matrix[i][j];
				pos++;
				hash[i][j] = 1;
				
				i = row;
				j = column;
				
			} else {
				m++;
				if (m > 3) 
                                    m = 0;
				
				 row = i + moves[m][0];
				 column = j + moves[m][1];
				
				 if ((hash[row][column] != 0)) {
	 
					 result[pos] = matrix[i][j];
					 hash[i][j] = 1;					 
				 }
			}
		}
		return result;
	} 
}
