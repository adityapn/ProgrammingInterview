package solved;
import java.util.*;

public class PrintAfterkTerms {
    
    	class Node{
		Node left;
		Node right;
		int data;
	}
	Node tree = null;
	int c = 0;
	List<Integer> nodes = new ArrayList();
	public void add(int n){
		tree =	add_data(tree,n);
	}
	
	private Node add_data(Node tree,int da){
		
		if(tree == null){
			tree = new Node();
			tree.left = tree.right = null;
			tree.data = da;
                        nodes.add(da);
			c++;
			return  tree;
		}
		else if(c%2 == 0)
			tree.left = add_data(tree.left,da);
		else
			tree.right = add_data(tree.right,da);
		
		return tree;
	}
        private void afterNodes(int n){
                        
            for(int i=0;i<nodes.size();i++){
                  if(i >= (Math.pow(2, n)-1))
                       System.out.print(" "+nodes.get(i));                 
            }
            System.out.println("");
        
        }
        public static void main(String s[]){
            
            PrintAfterkTerms tr = new PrintAfterkTerms();
            tr.add(1);
            tr.add(2);
            tr.add(3);
            tr.add(4);
            tr.add(5);
            tr.add(8);            
            tr.afterNodes(2);
        
        }	   
}
