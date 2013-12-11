package solved;

/* 
 * Sort a linked list of 0s, 1s and 2s 
 */

public class SortLL {
    
    	class Node{
                Node link;
		int data;
        }	
	
	Node node;
	public SortLL(){
		node = null;
	}
	
	public void append(int da){
	
               Node temp,two;
		
		if(node == null){
			node = new Node();
			node.link = null;
			node.data = da;
			return ;
		}
		two = node;
		while(two.link!=null)
			two = two.link;	
				
		temp = new Node();
		temp.link = null;
		temp.data = da;
		two.link = temp;		
	}
	
	public void display(){		
		Node t;
		t = node;
		while(t!=null){
			System.out.println(t.data);
			t = t.link;
		}		
	}
        
        public void sort(){
		Node one,two,temp;
		temp= null;
		for(one=node;one!=null;one=one.link){
		     for(two=node;two!=null;two=two.link){
			   if(one.data<=two.data){
				temp = new Node();
				temp.data = one.data;
				one.data = two.data;
				two.data = temp.data;
			     }
			}		
		}
	}
	public static void main(String args[]){
            
		SortLL list = new SortLL();
		list.append(0);
		list.append(1);
		list.append(2);
                list.append(2);
                list.append(1);
                list.append(0);
                list.append(0);
		list.append(1);
		list.append(2);
                list.append(2);
                list.append(1);
                list.append(0);
                list.append(0);
		list.append(1);
		list.append(2);
                list.append(2);
                list.append(1);
                list.append(0);
                
                list.sort();
   		list.display();		
	}
    
}
