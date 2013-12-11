/*
 *  Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
 *  column is set to 0 
 */
package OnArrayStackQueue;

public class MatrixProblemColAndRowTo0 {
    
      public static void main(String ...a){
          int matrix[][] = {{1,2,3},{4,0,5},{6,7,8}};
          matrix = makeMatrix(matrix,3 , 3);
          for(int i=0;i<3;i++){
              for(int j=0;j<3;j++){
                  System.out.print(" "+matrix[i][j]);
              }
              System.out.println("");
          }
      }
      static int[][] makeMatrix(int matrix[][] ,int rows , int cols){
            int[] row = new int[matrix.length]; 
            int[] column = new int[matrix[0].length];
            // Store the row and column index with value 0
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length;j++) {
                    if (matrix[i][j] == 0) {
                        row[i] = 1; 
                        column[j] = 1;
                    }
                }
            }

           // Set arr[i][j] to 0 if either row i or column j has a 0
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if ((row[i] == 1 || column[j] == 1)) {
                        matrix[i][j] = 0;
                    }
                }
            }
          return matrix;  
      }   
}
