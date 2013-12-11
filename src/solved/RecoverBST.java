/*
 * Two elements of BST are swapped by mistake. You have to restore the tree without changing its structure.
 */

package solved;

import java.util.*;

public class RecoverBST {
    
    class Node{
        Node left;
        Node right;
        Integer data;
    }
    Node tree;
    int count = 0;
    List<Integer> nums = new ArrayList<Integer>();
    
    public void rebuild(){
        for(int i=0;i<10;i++){
            nums.add(i);
        }
        //tree = Build(tree,0,nums.size());        
    }
    public void print(int low , int high){
         
        if(low>=high){           
            return;
        }else{
            
            int mid = (low+high)/2;
            
            System.out.println(" "+nums.get(mid));
            print( mid+1, high);
            print( 0, mid-1);
            
        }
    }
    public void p(){
        print(0,nums.size());
    }
    public Node Build(Node newtree,int s,int e){
        int mid = (s+e)/2;
        
        if(newtree == null){
            newtree = new Node();            
            newtree.left = null;
            newtree.right= null;
            newtree.data = nums.get(mid);
        }
        newtree.left = Build(newtree.left,s,mid-1);
        newtree.right = Build(newtree.right,mid+1,e);

        return newtree;
    }
     public void inorder(){
           in(tree);
    }
    public void in(Node t){
          if(t != null){
              in(t.left);
              System.out.print(" "+t.data+" ");
              in(t.right);
          }
    }

    public static void main(String s[]){
           RecoverBST tr = new RecoverBST();           
           
           tr.rebuild();
           tr.p();
    }

    
}
