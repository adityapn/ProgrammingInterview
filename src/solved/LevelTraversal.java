package solved;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LevelTraversal {
    static int c = 0;
    class Node{
        Node left;
        Node right;
        int data;
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
    public void reverseLevel(){
        LevelR(tree);
    }
    // Reverse of Level Order ( Bottom to top )
    public void LevelR(Node t){
        Queue<Node> tempq = new LinkedList<Node>();
        tempq.add(t);
        Stack<Node> stack = new Stack<Node>();
        
        while(!tempq.isEmpty()){
            Node temp = tempq.remove();
            stack.add(temp);
            count++;
            if(temp.left != null){
                tempq.add(temp.left);
            }
            if(temp.right != null){
                tempq.add(temp.right);
            }                        
        }
        printReverseLevel(stack);
    }
    private void printReverseLevel(Stack<Node> data){
        int c = count;
        int h = height(tree);
        
        while(!data.isEmpty()){
            if(expressed(c,h)){
                System.out.println("");
            }
            System.out.print(" "+data.pop().data+" ");
            c--;
        }
    }
    
    int count;
    // Level order ( Top to Bottom )DFS 
    public void levelP(Node t){
        
           Queue<Node> q = new LinkedList<Node>();
           count = 0;
           q.add(t);
           Node temp;  
           int h = height(tree);
           int sum = 0;
           while(!q.isEmpty()){                                           
               temp = q.remove();
               count++;
               if(expressed(count, h)){
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

    public static void main(String s[]){
        
           LevelTraversal tr = new LevelTraversal();
           
           tr.add(14);
           tr.add(7);
           tr.add(20);
           tr.add(3);
           tr.add(9);
           tr.add(17);
           tr.add(25);
           
           tr.add(1);
           tr.add(4);
           tr.add(8);
           tr.add(10);
           tr.add(15);
           tr.add(18);
           tr.add(23);
           tr.add(27);
           tr.add(56);
           tr.add(66);
           tr.add(76);
           tr.add(86);
           tr.add(96);
           
           
           // 14  7  20  3  9  17  25  4  15  23  21  24 
           tr.reverseLevel();
                                
    }
  
}
