package solved;

import java.util.LinkedList;
import java.util.Queue;

class BinaryTree {
	
	class Node{
		Node left;
		Node right;
		int data;
	}

	Node tree = null;
	int c = 1;
	
	public void add(int n){
		tree =	add_data(tree,n);
	}
	
	private Node add_data(Node tree,int da){
		
		if(tree == null){
			tree = new Node();
			tree.left = tree.right = null;
			tree.data = da;
			c++;
			return  tree;
		}
		else if(c%2 == 0)
			tree.left = add_data(tree.left,da);
		else
			tree.right = add_data(tree.right,da);
		
		return tree;
	}
        
        public int maxA(Node tr){
            
            if(tr.left == null && tr.right == null){                
                
                return tr.data;
            }
                
            if(tr.left == null){
                
                return tr.data + maxA(tr.right);
            }
                
            if(tr.right == null){
                
                return tr.data + maxA(tr.left);
            }                
             
             return Math.max(tr.data + maxA(tr.left), tr.data + maxA(tr.right));        
        }
        public void levelOrder(){
           levelP(tree);
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
           int h = height(tree);
           int sum = 0;
           while(!q.isEmpty()){                                           
               temp = q.remove();
               c++;
               if(expressed(c, h)){
                   System.out.println("");                   
               }
               System.out.print("  "+temp.data+"  ");
               
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
        public void maxSum(){
            int m = maxA(tree);
            System.out.println("Max is "+m);
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
	
	
    }
    
public class MaxSumOfNodes {
        
    public static void main(String ...a){
        
        BinaryTree bt = new BinaryTree();
        
        bt.add(1);
        bt.add(2);
        bt.add(3);
        bt.add(4);
        bt.add(5);
        bt.add(6);
        bt.add(7);
        bt.levelOrder();
        System.out.println(" ");
        bt.maxSum();
    
    }
    
}
