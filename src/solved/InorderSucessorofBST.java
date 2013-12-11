package solved;

import java.util.*;


public class InorderSucessorofBST {
    
    class Node{
        Node left;
        Node right;
        Integer data;
    }
    Node tree;
    List<Integer> nodes = new ArrayList<Integer>();
    public void add(int data){
        tree = add_node(tree,data);
    }
    public Node add_node(Node tree , int d){
    
        if(tree == null){
            tree = new Node();
            tree.left = null;
            tree.right = null;
            tree.data = d;
        }
        else if (d <= tree.data){
          tree.left =  add_node(tree.left,d);
        }else{
          tree.right =  add_node(tree.right,d);
        }
        
        return tree;
    }
    public void inorder(){
           in(tree);
    }
    public void in(Node t){
          if(t != null){
              in(t.left);
              nodes.add(t.data);
              in(t.right);
          }
    }
    public void findSuccessor(int n){
             if(nodes.contains(n)){
               int temp = Collections.binarySearch(nodes, n);
               System.out.println("Success "+nodes.get(temp+1));               
             }else
                 System.out.println("Does not exsist");
    }
    public static void main(String ...s){
        
        InorderSucessorofBST t = new InorderSucessorofBST();
        
        t.add(20);
        t.add(8);
        t.add(22);
        t.add(4);
        t.add(12);
        t.add(10);
        t.add(14);
        t.inorder();
        t.findSuccessor(14);
    }

    
}
