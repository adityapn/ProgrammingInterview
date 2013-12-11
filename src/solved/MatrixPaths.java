package solved;

import java.util.*;
        
public class MatrixPaths {
       
        public static void main(String[] args){
        
                int[][]A = {{1,2,3},{4,5,6},{7,8,9}};
                printPath(A);
        }
 
        static void printPath(int[][]A){
            printPath(A,0,0,"");
        }
        
        private static void printPath(int[][] A, int i, int j, String sofar) {
                if(i<A.length){
                        if(sofar.length() == 0){
                                sofar += A[i][j];
                                //System.out.println(" "+sofar);
                        }
                        else{
                                sofar += "-" + A[i][j];
                                //System.out.println(" "+sofar);
                        }
                        if(i==A.length-1){
                                printPath(A,i+1,j,sofar);
                                return;
                        }
                        //Handle 3 cases with j-1,j and j+1
                        if(j-1>=0)
                                printPath(A,i+1,j-1,sofar);
                        printPath(A,i+1,j,sofar);
                        if(j+1<A[0].length)
                                printPath(A,i+1,j+1,sofar);
                }else{
                        System.out.println(sofar);
                }
                        
        }
    
}
