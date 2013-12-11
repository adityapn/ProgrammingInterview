package solved;

public class InorderToBST {
    
    class Node{
        Node left;
        Node right;
        int data;
    }
    Node tree;
    public InorderToBST(){
        tree = new Node();
    }
    
    public void add(int data){         
         add_node(tree,data);
    }
    public void add_node(Node tree , int d){
    
        if(tree == null){            
            tree = new Node();
            tree.left = null;
            tree.right = null;
            tree.data = d;
            return;
        }
        
        add_node(tree.left,d);        
        add_node(tree.right,d);        
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

    public static void main(String ...s){
        
        InorderToBST t = new InorderToBST();
        t.add(1);
        t.add(2);
        t.add(3);
        t.add(4);
        t.add(5);
        t.add(6);
        t.add(7);
        
        t.inorder();
    
    }
    
    
}
