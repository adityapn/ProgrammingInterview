package solved;

import java.util.LinkedList;
import java.util.Queue;
public class BST {
    Node root;
    public BST(){
        root = null;
    }

    public void insert(int el){

        Node tmp = root, p=null;
        while(null!=tmp && el != tmp.data){
            p=tmp;
            if(el<tmp.data)
                tmp=tmp.left;
            else
                tmp=tmp.right;
        }
        if(tmp == null){
            if(null == p)
                root = new Node(el);
            else if(el <p.data)
                p.left= new Node(el);
            else
                p.right=new Node(el);
        }
    }//

    public void pathToSum(int sum) {
        pathToSum(root, sum);
    }//

    private boolean pathToSum(Node n, int sum) {
        if (null != n) {
            sum -= n.data;
            boolean found = pathToSum(n.left, sum);
            if (!found) {
                found = pathToSum(n.right, sum);
            }
            if (found) {
                System.out.println(n.data);
                return found;
            }
        }
        return 0 == sum ? true : false;
    }

    public static void main(String[] args){
      
        int[] input={50,25,75,10,35,60,100,5,20,30,45,55,70,90,102};
        BST bst = new BST();
    
        for(int i:input)
            bst.insert(i);
    
        bst.pathToSum(155);
        bst.levelOrder();
    }
    public void levelOrder(){
        levelP(root);
    }
    public boolean expressed(int n,int h){    
        for(int i=0;i<=h;i++){
            if(n == Math.pow(2, i)){
                return true;
            }
        }          
        return false;
    }
    // DFS 
    public void levelP(Node t){        
           Queue<Node> q = new LinkedList<Node>();
           int c = 0;
           q.add(t);
           Node temp ;  
           int h = height(root);
           int sum = 0;           
           while(!q.isEmpty()){                                           
               temp = q.remove();
               c++;
               if(expressed(c, h)){
                   System.out.println("");                   
               }
               System.out.print(" "+temp.data+" ");               
               if(temp.left != null){
                   q.add(temp.left);                   
               }   
               if(temp.right != null){
                   q.add(temp.right);                    
               }                 
          }
    }
    	/* returns maximum of two integers */
    int max(int a, int b){
 	return (a >= b)? a: b;
    }

/*  The function Compute the "height" of a tree. Height is the
    number of nodes along the longest path from the root node
    down to the farthest leaf node.*/

    int height(Node tree){
		
      /* base case tree is empty */
        if(tree == null)
            return 0;

         /* If tree is not empty then height = 1 + max of left
                height and right heights */
   	 return 1 + max(height(tree.left), height(tree.right));
      }
}

class Node{
    
    public int data;
    public Node left;
    public Node right;

    public Node(int el){
           data = el;
    }
    
}