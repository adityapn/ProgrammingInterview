/*
 *  A cross-matrix is a one in which all the diagonal elements are same 
 *  and not repeated anywhere else.
 */

package solved;

import java.util.HashSet;

public class CrossMatrix {
    
    static HashSet<Integer> map = new HashSet<Integer>();
    static boolean crossMatrix = true;
    public static void main(String ...s){
        int matrix[][] = {{1,2,3},{4,5,6},{7,8,9}};
        findDiagnol(matrix,map);
        findOthers(map,matrix);
        if(crossMatrix)
            System.out.println("Yes ! Cross Matrix");
        else
            System.out.println("Not a cross");
    }
    static void findDiagnol(int mat[][],HashSet<Integer> maps){
            for(int i=0;i<mat.length;i++){
                maps.add(mat[i][i]);
            }
    }
    static void findOthers(HashSet<Integer> maps , int mat[][]){
            for(int i=0;i<mat.length;i++){
                for(int j=0;j<mat.length;j++){
                    if(i != j){
                        if(maps.contains(mat[i][j])){
                            crossMatrix = false;
                        }
                    }
                }
            }
    }
    
}
