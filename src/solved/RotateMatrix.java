/*
 * Rotate a nXn matrix by 90 degrees
 * 
 */
package solved;

public class RotateMatrix {        
    
    public static void main(String ...s){
        
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] temp = {{1,2,3},{4,5,6},{7,8,9}};
        int n = 3;
        int level = 3;      
        for(int i=0;i<3;i++){
              level--;
              for(int j=0;j<n;j++){                                    
                       matrix[j][level] = temp[i][j];
              }  
        }
        printMatrix(matrix);
    }
    static void printMatrix(int matrix[][]){
        
        for(int i=0;i<3;i++){        
              for(int j=0;j<3;j++){                                    
                     System.out.print(" "+matrix[i][j]);                    
              }  
              System.out.println("");
        }            
    }    
}
