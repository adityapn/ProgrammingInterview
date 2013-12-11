package solved;

public class BSTORNOT {
    
    class Node{
        Node left;
        Node right;
        Integer data;
    }
    Node tree;
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
    public void isBST(){
        BST(tree);
    }
    private void BST(Node t){
        
        if((t.left == null && t.right== null)||t == null )
              System.out.println("True @ "+t.data);        
        else if(t.data>t.left.data && t.data < t.right.data){
            BST(t.left);
            BST(t.right);
        }
        
       
    }
    public void inorder(){
           in(tree);
    }
    public void in(Node t){
          if(t != null){
              in(t.left);
              System.out.println(" "+t.data);
              in(t.right);
          }
    }
    public void specificAdd(Node t  , int d){
        if(t == null){
            t = new Node();
            t.left = null;
            t.right = null;
            t.data = d;
        }else{
            System.out.println("not null");
        }  
    }
    public static void main(String ...s){
        
        BSTORNOT bst = new BSTORNOT();
        bst.add(20);
        bst.add(8);
        bst.add(22);
        bst.add(4);
        bst.add(12);
        bst.add(10);
        bst.add(14);
       
        bst.isBST();           
    
    }
    
}
